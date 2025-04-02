import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestEvenNumbers {

    @ParameterizedTest
    @ValueSource(ints = {2, 44, 600})
    public void testEvenNumbers(int n){
        Assertions.assertTrue(NumberUtility.isEven(n), "Expected " + n + " to be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 67, 589})
    public void testNotEvenNumbers(int n){
        Assertions.assertFalse(NumberUtility.isEven(n), "Expected " + n + " to be NOT even");
    }

    @Test
    public void testZeroValue(){
        Assertions.assertTrue(NumberUtility.isEven(0), "Expected 0 to be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -44, -600})
    public void testNegativeEvenNumbers(int n){
        Assertions.assertTrue(NumberUtility.isEven(n), "Expected " + n + " to be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -67, -589})
    public void testNegativeNotEvenNumbers(int n){
        Assertions.assertFalse(NumberUtility.isEven(n), "Expected " + n + " to be NOT even");
    }

}
