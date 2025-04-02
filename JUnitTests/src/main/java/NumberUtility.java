import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtility {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    public static int findSecondMax(int[] numbers) {
        int[] sortedNumbers = Arrays.stream(numbers).distinct().sorted().toArray();
        return Arrays.stream(sortedNumbers).skip(sortedNumbers.length - 2).findFirst().orElseThrow();
    }

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public static double findAverage(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static boolean hasDuplicates(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() != numbers.length;
    }


}
