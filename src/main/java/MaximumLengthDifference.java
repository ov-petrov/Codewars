import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthDifference {

    public static void main(String[] args) {
        System.out.println("mxdiflg Fixed Tests");
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};

        System.out.println(mxdiflg(s1, s2));
    }

    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0)
            return -1;

        int[] res = new int[4];
        Comparator<String> comparator = Comparator.comparing(String::length);
        Arrays.stream(a1).max(comparator).ifPresent(v -> res[0] = v.length());
        Arrays.stream(a1).min(comparator).ifPresent(v -> res[1] = v.length());
        Arrays.stream(a2).max(comparator).ifPresent(v -> res[2] = v.length());
        Arrays.stream(a2).min(comparator).ifPresent(v -> res[3] = v.length());

        return Math.max(res[0] - res[3], res[2] - res[1]);
    }

}
