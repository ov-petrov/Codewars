//Enough is enough!
//        Alice and Bob were on a holiday.
//        Both of them took many pictures of the places they've been,
//        and now they want to show Charlie their entire collection.
//        However, Charlie doesn't like these sessions, since the motive usually repeats.
//        He isn't fond of seeing the Eiffel tower 40 times. He tells them that he will
//        only sit during the session if they show the same motive at most N times. Luckily,
//        Alice and Bob are able to encode the motive as a number. Can you help them to remove
//        numbers such that their list contains each number only up to N times, without changing the order?
//
//        Task
//        Given a list lst and a number N, create a new list that contains each number of lst at most N times
//        without reordering. For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
//        drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3,
//        which leads to [1,2,3,1,2,3].

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EnoughIsEnough {

    public static void main(String[] args) {
        int[] res = deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3);
        Arrays.stream(res).forEach(v -> System.out.print(v + ", "));
        System.out.println();
        System.out.println("1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5");
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Long> grouped = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        int extra = grouped.values().stream()
                .filter(aLong -> aLong > maxOccurrences)
                .map(aLong -> aLong - maxOccurrences)
                .mapToInt(Long::intValue)
                .sum();

        Map<Integer, Long> filtered = grouped.entrySet().stream()
                .filter(v -> v.getValue() > maxOccurrences)
                .collect(Collectors.toMap(Map.Entry::getKey, v -> 0L));

        int[] result = new int[elements.length - extra];
        int counter = 0;
        for (int element : elements) {
            if (filtered.containsKey(element)) {
                filtered.replace(element, filtered.get(element) + 1);
                if (filtered.get(element) <= maxOccurrences) {
                    result[counter] = element;
                    counter++;
                }
            } else {
                result[counter] = element;
                counter++;
            }
        }

        return result;
    }
}
