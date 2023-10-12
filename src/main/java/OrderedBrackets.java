import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Legend
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n,
 * упорядоченные лексикографически.
 * В задаче используются только круглые скобки.
 * Желательно получить решение, которое работает за время, пропорциональное общему
 * количеству правильных скобочных последовательностей в ответе, и при этом использует объём памяти, пропорциональный n.
 * <p>
 * Формат ввода
 * Единственная строка входного файла содержит целое число n, 0 ≤ n ≤ 11
 * <p>
 * Формат вывода
 * Выходной файл содержит сгенерированные правильные скобочные последовательности, упорядоченные лексикографически.
 */
public class OrderedBrackets {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int bracketsCount = Integer.parseInt(reader.readLine()) * 2;
        char[] brackets = new char[bracketsCount];
        int brDifference = 0;
        int index = 0;

        process(brDifference, index, bracketsCount, brackets);
    }

    private static void process(int brDifference, int index, int bracketsCount, char[] brackets) {
        if (brDifference <= bracketsCount - index - 2) {
            brackets[index] = '(';
            process(brDifference + 1, index + 1, bracketsCount, brackets);
        }
        if (brDifference > 0) {
            brackets[index] = ')';
            process(brDifference - 1, index + 1, bracketsCount, brackets);
        }
        if (index == bracketsCount && brDifference == 0) {
            System.out.println(new String(brackets));
        }
    }
}
