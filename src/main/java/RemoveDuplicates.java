import java.util.Scanner;

/**
 * Legend
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
 * Требуется удалить из него все повторения.
 * Желательно получить решение, которое не считывает входной файл
 * целиком в память, т.е., использует лишь константный объем памяти в процессе работы.
 * <p>
 * Input format
 * Первая строка входного файла содержит единственное число n, n ≤ 1000000.
 * На следующих n строк расположены числа — элементы массива, по одному на строку.
 * Числа отсортированы по неубыванию.
 * <p>
 * Output format
 * Выходной файл должен содержать следующие в порядке возрастания
 * уникальные элементы входного массива.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length == 0) return;

        int previous = scanner.nextInt();
        System.out.println(previous);
        if (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                int current = scanner.nextInt();
                if (current != previous) {
                    System.out.println(current);
                    previous = current;
                }
            }
        }
    }
}
