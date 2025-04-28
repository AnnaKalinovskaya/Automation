package patterns.singleton;

public class Logger {

    private static Logger logger;

    private Logger(){}

    public static Logger getInstance(){
        if (logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public void recordEvent(String eventDetails){
        System.out.println(eventDetails);
    }
}
