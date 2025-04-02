import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestPhoneNumber {

    @ParameterizedTest
    @ValueSource(strings = {"+1 1234567890", "+1 1234567666"})
    public void testValidPhone(String number){
        Assertions.assertTrue(StringUtility.isValidPhoneNumber(number), "Expected phone number to be valid: " + number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "invalid"})
    public void testInvalidPhone(String number){
        Assertions.assertFalse(StringUtility.isValidPhoneNumber(number), "Expected phone number to be INVALID: " + number);
    }

}
