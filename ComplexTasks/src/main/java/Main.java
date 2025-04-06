import Task1.EntityManager;
import Task1.InvalidUserException;
import Task1.User;
import Task1.UserValidator;
import Task3.GradeService;
import Task3.InvalidGradeException;
import Task3.StudentGrade;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidUserException, InvalidGradeException {
        /*EntityManager<User> manager = new EntityManager<User>();
        User u1 = new User("Name1", 100, "u1@.com",  "active");
        User u2 = new User("invalid", 18, "u11@mail.com","blocked");
        User u3 = new User("Name2", 17, "u2@mail.com","invited");
        User u4 = new User("Name3", 101, "u3@mail.com","active");

        manager.addUser(u1);
        manager.addUser(u2);
        manager.addUser(u3);
        manager.addUser(u4);

        UserValidator.setValidationFlag(true);
        boolean validU1 = UserValidator.validateUser(u1);
        boolean validU2 =UserValidator.validateUser(u2);
        boolean validU3 =UserValidator.validateUser(u3);
        boolean validU4 =UserValidator.validateUser(u4);

         */

        StudentGrade<Double> sg1 = new StudentGrade<>("s1", "math", -6.8);
        StudentGrade<Double> sg2 = new StudentGrade<>("s2", "math", 9.00);
        StudentGrade<Integer> sg3 = new StudentGrade<>("s3", "math", 5);
        StudentGrade<Double> sg4 = new StudentGrade<>("s4", "literature", 8.5);
        StudentGrade<Integer> sg5 = new StudentGrade<>("s5", "literature", 10);

        GradeService<Number> gs = new GradeService<>();
        gs.addGrade(sg1);
        gs.addGrade(sg2);
        gs.addGrade(sg3);
        gs.addGrade(sg4);
        gs.addGrade(sg5);

        double average = gs.averageGrade("math");
        int a = 1;

    }
}