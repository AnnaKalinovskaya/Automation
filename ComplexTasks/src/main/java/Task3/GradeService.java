package Task3;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {

    private List<StudentGrade<T>> list = new ArrayList<>();

    public synchronized List<StudentGrade<T>> getList(){
        return this.list;
    }

    public synchronized void addGrade(StudentGrade grade) throws InvalidGradeException {
        if (grade.getGrade().doubleValue() < 0.00){
            throw new InvalidGradeException(grade.getName() + " has a negative grade");
        } else list.add(grade);
    }

    public double averageGrade (String subject){
        List<T> gradesBySubject = list.stream().filter(grade -> grade.getSubject().equals(subject))
                .map(studentGrade -> studentGrade.getGrade()).toList();
        int size = gradesBySubject.size();
        return gradesBySubject.stream().mapToDouble(Number::doubleValue).sum() / size;
    }
}
