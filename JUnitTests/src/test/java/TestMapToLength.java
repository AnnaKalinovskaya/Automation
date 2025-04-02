import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TestMapToLength {

    private static Stream<Arguments> dataProvider(){
        return Stream.of(Arguments.of(List.of("Java", "C++", "Go" ), List.of(4, 3, 2)));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testValidList(List<String> words, List<Integer> expectedResult){
        Assertions.assertEquals(expectedResult, StringUtility.mapToLengths(words));
    }

    @Test
    public void testEmptyList(){
        Assertions.assertThrows(NullPointerException.class, () -> StringUtility.mapToLengths(null));
    }
}
