import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestCountWords {

    private static Stream<Object[]> dataProvider(){
        return Stream.of(
                new Object[] {"", 0},
                new Object[] {"fdjhsjdf.sdfjsd sdfkd sfd", 3},
                new Object[] {"fdjhsjdf", 1}
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testWordsCount(String s, int expectedCounter){
        Assertions.assertEquals(expectedCounter, StringUtility.countWords(s));
    }

    @Test
    public void testException(){
        Assertions.assertThrows(NullPointerException.class, () -> StringUtility.countWords(null));
    }
}
