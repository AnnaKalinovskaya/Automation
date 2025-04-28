package patterns.singleton;

public class DataBase {

    private String url;
    private String userName;
    private String password;

    private DataBase(){}

    private static DataBase db;

    public static DataBase getInstance(){
        if (db == null){
            db = new DataBase();
        }

        return db;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
