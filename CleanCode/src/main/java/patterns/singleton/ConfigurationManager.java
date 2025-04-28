package patterns.singleton;

public class ConfigurationManager {

    private DataBase db = DataBase.getInstance();

    private String folderPath;

    private String logLevel;
    private String logFiePath;

    private static ConfigurationManager configurationManager;

    private ConfigurationManager(){}

    public static ConfigurationManager getInstance(){
        if (configurationManager == null){
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    public void setDataBaseConnection(String url, String userName, String pass){
        this.db.setUrl(url);
        this.db.setUserName(userName);
        this.db.setPassword(pass);
    }

    public DataBase getDataBase(){
        return this.db;
    }

    public void setFolderPath(String path){
        this.folderPath = folderPath;
    }

    public String getFolderPath(){
        return this.folderPath;
    }

    public void setLogLevel (String level){
        this.logLevel = level;
    }

    public String getLogLevel(){
        return this.logLevel;
    }

    public void setLogFiePath(String path){
        this.logFiePath = path;
    }
    public String getLogFilePath(){
        return this.logFiePath;
    }


}
