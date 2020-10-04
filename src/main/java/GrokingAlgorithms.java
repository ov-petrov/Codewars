import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class GrokingAlgorithms {
    /**
     * See Arrays.binarySearch
     *
     * @param array int[]
     * @param item  int
     * @return int
     */
    private static int binarySearch(int[] array, int item) {
        int low = 0;
        int max = array.length - 1;
        int half = max / 2;

        while (low != max) {
            if (array[half] == item)
                return half;

            if (array[half] < item) {
                low = half;
                half += (max - low) / 2;
            } else {
                max = half;
                half -= (max - low) / 2;
            }
        }

        return -1;
    }

    /**
     * Recursive sum of queue
     *
     * @param queue Queue<Integer>
     * @return int
     */
    private static int sum(Queue<Integer> queue) {
        if (queue.isEmpty())
            return 0;
        if (queue.size() == 1)
            return queue.poll();
        return queue.poll() + sum(queue);
    }

    /**
     * Recursive size of queue
     *
     * @param queue Queue<?>
     * @return int
     */
    private static int size(Queue<?> queue) {
        if (queue.isEmpty())
            return 0;

        queue.remove();
        return 1 + size(queue);
    }

    public static Integer[] quickSort(Integer[] array) {
        if (array.length < 2)
            return array;

        int pivot = array[0];
        Map<Boolean, List<Integer>> lessAndGreater = Arrays.stream(array)
                .filter(v -> v != pivot)
                .collect(Collectors.partitioningBy(v -> v <= pivot));

        Integer[] sortedLess = quickSort(lessAndGreater.get(true).toArray(new Integer[0]));
        Integer[] sortedGreater = quickSort(lessAndGreater.get(false).toArray(new Integer[0]));
        List<Integer> result = Arrays.stream(sortedLess).collect(Collectors.toList());
        result.add(pivot);
        result.addAll(Arrays.stream(sortedGreater).collect(Collectors.toList()));
        return result.toArray(new Integer[0]);
    }

}
