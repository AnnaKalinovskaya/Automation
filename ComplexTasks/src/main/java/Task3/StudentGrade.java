package Task3;

public class StudentGrade <T extends Number>{

    private String studentName;
    private String subject;
    private T grade;

    public StudentGrade(String studentName, String subject, T grade){
        this.studentName = studentName;
        this.subject = subject;
        this.grade = grade;
    }

    public String getName(){
        return this.studentName;
    }

    public String getSubject(){
        return this.subject;
    }

    public T getGrade(){
        return this.grade;
    }
}
