package Task1;

public class User {

    private int age;
    private String name;
    private String status;
    private String email;

    public User (String name, int age, String email, String status){
        this.age = age;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public String getStatus(){
        return this.status;
    }

    public String getEmail(){
        return this.email;
    }


}
