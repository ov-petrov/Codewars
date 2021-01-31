import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.stream(removeDuplicates(data)).forEach(System.out::println);
    }

    private static int getLongestSequence(int[] data, int digit) {
        int bestLongest = 0;
        int longest = 0;
        for (int current : data) {
            if (current == digit)
                longest++;
            else {
                if (longest > bestLongest)
                    bestLongest = longest;
                longest = 0;
            }
        }
        if (longest > bestLongest)
            bestLongest = longest;

        return bestLongest;
    }

    private static int[] removeDuplicates(int[] data) {
        return Arrays.stream(data).distinct().toArray();
    }

    @Test
    public void tests2() {
        Assert.assertArrayEquals(new int[]{2, 5, 8}, removeDuplicates(new int[]{2, 2, 2, 5, 5, 8, 8, 8, 8}));
    }

    @Test
    public void tests() {
        Assert.assertEquals(2, getLongestSequence(new int[]{1, 0, 1, 0, 1, 1, 5, 7, 8}, 1));
        Assert.assertEquals(0, getLongestSequence(new int[]{}, 1));
        Assert.assertEquals(0, getLongestSequence(new int[]{2}, 1));
        Assert.assertEquals(6, getLongestSequence(new int[]{1, 1, 1, 1, 1, 1}, 1));

    }


}