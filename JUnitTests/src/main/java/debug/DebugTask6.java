package debug;

public class DebugTask6 {
    public static void main(String[] args) {
        countdown(5);
    }
    public static void countdown(int n) {
        if (n < 1) throw new IllegalArgumentException("Numbers >= 1 are only acceptable");

        while (n >= 1) {
            System.out.println(n);
            n = n - 1;
        }
    }
}
