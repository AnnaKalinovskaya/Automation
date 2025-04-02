import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TestFindSeconMax {

    private static Stream<Object[]> validArrays(){
        return Stream.of(
                new Object[]{new int[]{1, 2, 3, 4}, 3},
                new Object[]{new int[]{45, 60, 30, 4}, 45},
                new Object[]{new int[]{5, 5, 1, 8, 7}, 7}
        );
    }

    private static Stream<int[]> invalidArrays(){
        return Stream.of(
                new int[]{5, 5, 5, 5},
                new int[]{4}
        );
    }



    @ParameterizedTest
    @MethodSource("validArrays")
    public void testValidArray(int[] ints, int expectedResult){
        Assertions.assertEquals(expectedResult, NumberUtility.findSecondMax(ints), "Actual Second Max doesn't correspond to expected");
    }

    @ParameterizedTest
    @MethodSource("invalidArrays")
    public void testException(int[] array){
        Assertions.assertThrows(IllegalArgumentException.class, () -> NumberUtility.findSecondMax(array));

    }
}
