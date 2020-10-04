import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        Integer[] array = {5, 3, 8, 11, 14, 56, 766, 543};
        Integer[] sortedArray = GrokingAlgorithms.quickSort(array);
        Stream.of(sortedArray).forEach(v -> System.out.print(v + " "));

    }
}
