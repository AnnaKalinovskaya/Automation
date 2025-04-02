import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestValidPassword {


    @ParameterizedTest
    @ValueSource(strings = {"Password1"})
    public void testValidPass(String s){
        Assertions.assertTrue(StringUtility.isValidPassword(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pass", ""})
    public void testInvalidPass(String s){
        Assertions.assertFalse(StringUtility.isValidPassword(s));
    }

    @Test
    public void testNull(){
        Assertions.assertFalse(StringUtility.isValidPassword(null));
    }

}
