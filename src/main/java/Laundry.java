import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Laundry {

    // Есть прачечная с N стиральными машинами. На входе в прачечную в очереди стоят M человек для того, чтобы постирать свои вещи.
    // Про каждого человека известно, сколько времени он будет стирать свои вещи. Каждый человек использует первую освободившуюся машину.
    // Сколько времени займёт стирка всех вещей?
    public static void main(String[] args) {

        int n = 5;
        List<Integer> clients = Arrays.asList(12, 14, 18, 10, 6, 4, 2, 12, 18, 19, 18, 8, 7, 4, 2, 6, 7);
        List<Integer> washMachines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            washMachines.add(0);
        }

        clients.forEach(
                client -> {
                    int machineIndex = findMachineWithLowestLoad(washMachines);
                    washMachines.set(machineIndex, washMachines.get(machineIndex) + client);
                });

        System.out.println(washMachines.stream().max(Integer::compareTo).orElse(0));

    }

    private static int findMachineWithLowestLoad(List<Integer> machines) {
        if (machines.isEmpty())
            return -1;

        int lowestLoad = machines.get(0);
        int machineIndex = 0;
        for (int i = 0; i < machines.size(); i++) {
            int currentMachineLoad = machines.get(i);

            if (currentMachineLoad == 0)
                return i;
            else {
                if (currentMachineLoad < lowestLoad) {
                    lowestLoad = currentMachineLoad;
                    machineIndex = i;
                }
            }
        }

        return machineIndex;
    }
}
