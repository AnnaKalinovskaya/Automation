import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class TestGCD {

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(24, 36, 12),
                Arguments.of(101, 103, 1),
                Arguments.of(0, 10, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testGCD(int a, int b, int expectedResult){
        Assertions.assertEquals(expectedResult, NumberUtility.gcd(a, b));
    }
}
