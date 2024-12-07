package java.code.goldenhammer.singleton;

public class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void run() {
        logger.log("Application is running");
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        Application app = new Application(logger);
        app.run();
    }
}