import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestFindAverage {

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3.00),
                Arguments.of(new int[]{10}, 10.00)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testAverage(int[] array, double expectedResult){
        Assertions.assertEquals(expectedResult, NumberUtility.findAverage(array));
    }

    @Test
    public void testExceptonOnNull(){
        Assertions.assertThrows(NullPointerException.class, () -> NumberUtility.findAverage(null));
    }
}
