import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestSplitString {

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of("Java,Python,C++", ",", new String[]{"Java", "Python", "C++"}),
                Arguments.of("", ",", new String[]{""}),
                Arguments.of("word", ",", new String[]{"word"})
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testSplit(String s, String delimiter, String[] expectedResult){
        Assertions.assertTrue(Arrays.equals(expectedResult, StringUtility.splitString(s, delimiter)));
    }
}
