import java.util.Arrays;

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

}
