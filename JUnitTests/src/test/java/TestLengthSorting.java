import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TestLengthSorting {

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(List.of("Java", "C", "Python"), List.of("C", "Java", "Python")),
                Arguments.of(List.of("aa", "bb", "cc"), List.of("aa", "bb", "cc"))
        );

    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSorting(List<String> words, List<String> expectedResult){
        Assertions.assertEquals(expectedResult, StringUtility.sortByLength(words));
    }

    @Test
    public void testNullList(){
        Assertions.assertThrows(NullPointerException.class, () -> StringUtility.sortByLength(null));
    }


}
