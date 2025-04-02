import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestFilterEvenNumbers {

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 4, 6)),
                Arguments.of(List.of(1, 3, 5), new ArrayList<Integer>())

        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testValidListWithEvenNumbers(List<Integer> initialList, List<Integer> expectedList){
        Assertions.assertEquals(expectedList, NumberUtility.filterEvenNumbers(initialList));
    }

    @Test
    public void testNullList(){
        Assertions.assertThrows(NullPointerException.class, () -> NumberUtility.filterEvenNumbers(null));
    }
}
