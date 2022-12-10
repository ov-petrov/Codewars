import java.util.Scanner;

/**
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 * Желательно получить решение, работающее за линейное время и при этом
 * проходящее по входному массиву только один раз.
 * Формат ввода
 * Первая строка входного файла содержит одно число n, n ≤ 10000.
 * Каждая из следующих n строк содержит ровно одно число — очередной элемент массива.
 * Формат вывода
 * Выходной файл должен содержать единственное число — длину самой длинной последовательности
 * единиц во входном массиве.
 */
public class ConsecutiveOnes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceLength = scanner.nextInt();

        int maxSequence = 0;
        int currentSequence = 0;
        for (int i = 0; i < sequenceLength; i++) {
            int number = scanner.nextInt();
            if (number == 1) {
                currentSequence++;
            } else {
                currentSequence = 0;
            }
            if (currentSequence > maxSequence) {
                maxSequence = currentSequence;
            }
        }

        System.out.println(maxSequence);
    }
}
