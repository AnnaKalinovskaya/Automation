import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestDuplicates {

    private static Stream<Arguments> noDuplicates(){
        return Stream.of(Arguments.of(new int[] {1, 2, 3, 4, 5}));
    }

    private static Stream<Arguments> hasDuplicates(){
        return Stream.of(Arguments.of(new int[] {1, 2, 2, 3}));
    }

    @ParameterizedTest
    @MethodSource("noDuplicates")
    public void testWithNoDuplicated(int[] array){
        Assertions.assertFalse(NumberUtility.hasDuplicates(array));
    }

    @ParameterizedTest
    @MethodSource("hasDuplicates")
    public void testWithDuplicated(int[] array){
        Assertions.assertTrue(NumberUtility.hasDuplicates(array));
    }

    @Test
    public void testNull(){
        Assertions.assertThrows(NullPointerException.class, () -> NumberUtility.hasDuplicates(null));
    }

}
