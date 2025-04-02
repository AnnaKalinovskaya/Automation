import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TestAnagram {

    private static Stream<Arguments> anagrams(){
        return Stream.of(Arguments.of("listen", "silent"));
    }

    private static Stream<Arguments> notAnagrams(){
        return Stream.of(Arguments.of("java", "python"));
    }

    @ParameterizedTest
    @MethodSource("anagrams")
    public void testAnagrams(String s1, String s2){
        Assertions.assertTrue(StringUtility.isAnagram(s1, s2));
    }

    @ParameterizedTest
    @MethodSource("notAnagrams")
    public void testNotAnagrams(String s1, String s2){
        Assertions.assertFalse(StringUtility.isAnagram(s1, s2));
    }

    @Test
    public void testNull(){
        Assertions.assertFalse(StringUtility.isAnagram(null, null));
    }

}