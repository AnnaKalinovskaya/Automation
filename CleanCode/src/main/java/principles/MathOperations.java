package principles;

import java.util.Arrays;

public class MathOperations {

        public int add(int ... numbers) {
            return Arrays.stream(numbers).sum();
        }

}
