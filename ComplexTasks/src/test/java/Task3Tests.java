import Task3.GradeService;
import Task3.InvalidGradeException;
import Task3.StudentGrade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class Task3Tests {

    private static GradeService<Number> gs = new GradeService<>();

    private static Stream<Arguments> invalidGrade(){
        return Stream.of(
                Arguments.of(new StudentGrade<>("s1", "math", -6.8)),
                Arguments.of(new StudentGrade<>("s2", "math", -0.01))
        );
    }

    private static Stream<Arguments> validGrade(){
        return Stream.of(
                Arguments.of(new StudentGrade<>("s3", "math", 9.00)),
                Arguments.of(new StudentGrade<>("s4", "math", 0.00)),
                Arguments.of(new StudentGrade<>("s3", "math", 5)),
                Arguments.of(new StudentGrade<>("s4", "literature", 8.5)),
                Arguments.of(new StudentGrade<>("s5", "literature", 10))
        );
    }

    @ParameterizedTest
    @MethodSource("validGrade")
    public void validGrade(StudentGrade<Number> grade) throws InvalidGradeException {
        gs.addGrade(grade);
        Assertions.assertTrue(gs.getList().contains(grade), "Grade was not added for student: " + grade.getName());
    }

    @ParameterizedTest
    @MethodSource("invalidGrade")
    public void invalidGrade(StudentGrade<Number> negativeGrade){
        Assertions.assertThrows(InvalidGradeException.class, () -> gs.addGrade(negativeGrade), "Negative grade was successfully added");
    }

    //should be run after previous tests (if run in isolation from others, list of grades will be empty since grades are added in previous tests)
    @Test
    public void averageGrade(){
        List<StudentGrade<Number>> expectedListFilteredBySubject = gs.getList().stream().filter(g -> g.getSubject().equals("math")).toList();
        double expectedAverage = expectedListFilteredBySubject.stream().mapToDouble(g -> g.getGrade().doubleValue()).sum() / expectedListFilteredBySubject.size();
       Assertions.assertEquals(expectedAverage, gs.averageGrade("math"), "Average grade result is incorrect");

    }
}
