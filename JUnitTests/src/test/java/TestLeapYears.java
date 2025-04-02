import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class TestLeapYears {

    @ParameterizedTest
    @ValueSource(ints = {2020, 2000, 1600})
    public void testLeapYears(int year){
        Assertions.assertTrue(NumberUtility.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {2021, 2022})
    public void testNonLeapYears(int year){
        Assertions.assertFalse(NumberUtility.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {1900, 2100})
    public void testDivisionCondition(int year){
        Assertions.assertFalse(NumberUtility.isLeapYear(year));
    }

}
