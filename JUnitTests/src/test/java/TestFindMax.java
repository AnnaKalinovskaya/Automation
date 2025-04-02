import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class TestFindMax {

    private static Stream<Object[]> validArrays(){
        return Stream.of(
                new Object[] { new int[] {3, 5, 7, 2}, 7},
                new Object[] { new int[] {37, 54, 7, 2}, 54},
                new Object[] { new int[] {-3, -5, -7, -2}, -2},
                new Object[] { new int[] {-37, -54, -7, -66}, -7},
                new Object[] { new int[] {5}, 5}

        );
    }


    @ParameterizedTest
    @MethodSource("validArrays")
    public void testValidArrays (int[] array, int expectedMax){
        Assertions.assertEquals(expectedMax, NumberUtility.findMax(array));
    }

    @Test
    public void testEmptyArray(){
        Assertions.assertThrows(NullPointerException.class, () -> NumberUtility.findMax(null));
    }

}
