import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TestFactorial {

    private static Stream<Object[]> dataProvider(){
        return Stream.of(
                new Object[]{1, 1},
                new Object[]{5, 120},
                new Object[]{7, 5040},
                new Object[]{0, 1}
        );
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testFactorial(int n, int expectedFactorial){
        Assertions.assertEquals(expectedFactorial, NumberUtility.factorial(n), "Expected factorial of " + n + " == " + expectedFactorial);
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, -55, -10})
    public void testNegativeNumbers(int n){
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumberUtility.factorial(n), "Expected IllegalArgumentException to be thrown");
    }

}
