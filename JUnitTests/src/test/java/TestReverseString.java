import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestReverseString {

    private static Stream<Object[]> validStrings(){
        return Stream.of(
                new Object[] {"tre", "ert"},
                new Object[] {"a", "a"},
                new Object[] {"ppapp", "ppapp"},
                new Object[] {"P 123", "321 P"}
        );
    }


    @ParameterizedTest
    @MethodSource("validStrings")
    public void testValidStrings (String initialString,String expectedReversed){
        Assertions.assertEquals(expectedReversed, StringUtility.reverse(initialString), "Reversion failed");
    }

    @Test
    public void testEmptyString(){
        Assertions.assertEquals("", StringUtility.reverse(""), "Empty String reversion failed");
    }

    @Test
    public void testNullValue (){
        Assertions.assertNull(StringUtility.reverse(null), "Null string reversion failed");
    }
}
