import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestValidJson {

    @ParameterizedTest
    @ValueSource(strings = {"{\"key\":\"value\"}"})
    public void testValidJson(String json){
        Assertions.assertTrue(StringUtility.isValidJson(json));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid json"})
    public void testInvalidJson(String json){
        Assertions.assertFalse(StringUtility.isValidJson(json));
    }

    @Test
    public void testNull(){
        Assertions.assertFalse(StringUtility.isValidJson(null));
    }


}
