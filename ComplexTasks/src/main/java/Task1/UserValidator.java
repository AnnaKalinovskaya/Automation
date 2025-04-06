package Task1;

public class UserValidator {

    private static boolean validationEnabled;

    public static boolean getValidationFlag(){
        return validationEnabled;
    }

    public static void setValidationFlag(boolean value){
        validationEnabled = value;
    }

    private static void validateName(User user) throws InvalidUserException {
        if (user.getName() == null || user.getName().charAt(0) == user.getName().toLowerCase().charAt(0)) {
            throw new InvalidUserException (user.getName() + " has invalid name: null or first letter is not in upper case");
        }
    }

    private static void validateAge (User user) throws InvalidUserException{
        if (user.getAge() < 18 || user.getAge() > 100){
            throw new InvalidUserException (user.getName() + " has invalid age: should be from 18 to 100");
        }
    }

    private static void validateEmail (User user) throws InvalidUserException{
        if (!user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")){
            throw new InvalidUserException (user.getName() + " has invalid email: pattern must be name@email.com");
        }
    }

    public static boolean validateUser(User u) throws InvalidUserException {
        if (getValidationFlag()) {
                validateName(u);
                validateAge(u);
                validateEmail(u);
                return true;
        } else return true;
    }
}
