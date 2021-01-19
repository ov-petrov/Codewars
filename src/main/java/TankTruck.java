import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TankTruck {

    public static void main(String[] args) {
        System.out.println(solEquaStr(90005));

    }

    public static String solEquaStr(long n) {
        List<Map.Entry<Long, Long>> result = new ArrayList<>();

        for (long i = n; i > (long) Math.sqrt(n); i--) {
            for (long j = 0; j < i; j++) {
                long eq = equation(i, j);

                if (eq == n)
                    result.add(new AbstractMap.SimpleEntry<>(i, j));
            }
        }

        return result.stream()
                .map(v -> String.format("[%s, %s]", v.getKey(), v.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static long equation(long x, long y) {
        return (long) Math.floor(Math.pow(x, 2) - (4 * Math.pow(y, 2)));
    }

    public static int longestPalindrome(final String s) {
        if (s == null || s.isEmpty())
            return 0;

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                StringBuilder sb = new StringBuilder(s.subSequence(i, j));
                if (sb.length() <= max)
                    break;
                if (sb.toString().equals(sb.reverse().toString())) {
                    max = sb.length();
                    break;
                }
            }
        }

        return max;
    }


}
