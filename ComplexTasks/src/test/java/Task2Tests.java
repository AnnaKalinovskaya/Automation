import Task1.InvalidUserException;
import Task1.User;
import Task1.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Task2Tests {

    private static Stream<Arguments> names(){
        return Stream.of(
                Arguments.of(new User("Peter", 20, "peter@mail.com", "active"),
                        new User("mark", 21, "mark@mail.com", "active"))
        );
    }

    private static Stream<Arguments> validAges(){
        return Stream.of(
                Arguments.of(new User("Peter", 18, "peter@mail.com", "active")),
                Arguments.of(new User("Mark", 19, "mark@mail.com", "active")),
                Arguments.of(new User("Glory", 99, "glory@mail.com", "active")),
                Arguments.of(new User("Berth", 100, "berth@mail.com", "active"))
        );
    }

    private static Stream<Arguments> invalidAges(){
        return Stream.of(
                Arguments.of(new User("Ally", 17, "ally@mail.com", "active")),
                Arguments.of(new User("Paul", 101, "paul@mail.com", "active"))
        );
    }

    private static Stream<Arguments> invalidEmail(){
        return Stream.of(
                Arguments.of(new User("User1", 43, "umail.com", "active")),
                Arguments.of(new User("User2", 34, "u@.com", "active")),
                Arguments.of(new User("User4", 60, "u-u@mail.r", "active")),
                Arguments.of(new User("User3", 24, "user@mail", "active"))
        );
    }


    @BeforeAll
    public static void setValidationFlag(){
        UserValidator.setValidationFlag(true);
    }

    @ParameterizedTest
    @MethodSource("names")
    public void testNameValidation(User validName, User invalidName) throws InvalidUserException {
        Assertions.assertTrue(UserValidator.validateUser(validName), "Invalid name: " + validName.getName());
        Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(invalidName),
                "Invalid name was accepted as valid: " + invalidName.getName());
    }

    @ParameterizedTest
    @MethodSource("validAges")
    public void testValidAge(User validAge) throws InvalidUserException {
        Assertions.assertTrue(UserValidator.validateUser(validAge), "Invalid age: " + validAge.getName());
    }

    @ParameterizedTest
    @MethodSource("invalidAges")
    public void testInvalidAge(User inValidAge) {
        Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(inValidAge),
                "Invalid age was accepted as valid: " + inValidAge.getName());
    }

    @ParameterizedTest
    @MethodSource("invalidEmail")
    public void testInvalidEmail(User inValidEmail) {
        Assertions.assertThrows(InvalidUserException.class, () -> UserValidator.validateUser(inValidEmail),
                "Invalid age was accepted as valid: " + inValidEmail.getName());
    }
}
