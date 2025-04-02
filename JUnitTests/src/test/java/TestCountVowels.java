import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TestCountVowels {

    private static Stream<Object[]> validStrings(){
        return Stream.of(
                new Object[]{"hello", 2},
                new Object[]{"java", 2},
                new Object[]{"AEIOU", 5},
                new Object[]{"", 0}
        );
    }


    @ParameterizedTest
    @MethodSource("validStrings")
    public void testValidStrings(String s, int expectedCount){
        Assertions.assertEquals(expectedCount, StringUtility.countVowels(s), "Vowels count in string: " + s + " is incorrect");
    }

    @Test
    public void testNullValue(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtility.countVowels(null), "IllegalArgumentException is expected on null value");
    }

    @ParameterizedTest
    @ValueSource(strings = {"rtgt", "THFG", "r"})
    public void testNoVowelsStrings(String s){
        Assertions.assertEquals(0, StringUtility.countVowels(s), "Expected vowels counter to be 0 for string: " + s);
    }

}
