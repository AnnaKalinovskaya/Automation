import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestValidEmail {

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "testAnother@example.com"})
    public void testValidEmail(String email){
        Assertions.assertTrue(StringUtility.isValidEmail(email), "Expected email: " + email + " to be valid");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bad@.com", "no-at-symbol"})
    public void testInvalidEmail(String email){
        Assertions.assertFalse(StringUtility.isValidEmail(email), "Expected email: " + email + " to be INVALID");
    }

    @Test
    public void testNullValue(){
        Assertions.assertFalse(StringUtility.isValidEmail(null), "Email is invalid as null");
    }

}
