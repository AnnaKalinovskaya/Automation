package patterns.singleton;

public class Main {

    public static void main (String[] args){
        Logger.getInstance().recordEvent("Connected to DB successfully");
        Logger.getInstance().recordEvent("Method is depricated");
        ConfigurationManager.getInstance().setDataBaseConnection("some URL", "name1", "my_pass");
        System.out.println(ConfigurationManager.getInstance().getDataBase().getUrl());

    }
}
