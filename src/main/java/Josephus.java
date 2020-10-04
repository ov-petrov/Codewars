import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static List<Integer> josephusPermutation(final List<Integer> items, final int k) {
        final List<Integer> result = new ArrayList<Integer>();
        List<Integer> removing = new ArrayList<Integer>(items);

        int step = 0;

        while (!removing.isEmpty()) {
            if (step < removing.size() - 1) {
                step += k - 1;
                result.add(removing.remove(step));
            } else {
                if (removing.size() == 1)
                    result.add(removing.remove(step));

                int buff = removing.size() - step;
                step = step - buff;
            }
        }

        return result;
    }


}