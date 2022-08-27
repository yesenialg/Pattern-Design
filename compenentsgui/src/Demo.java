import app.Application;
import factories.GUIFactory;
import factories.MacOSFactory;
import factories.WindowsFactory;
/**
 * CODIGO DE GURU:
 https://refactoring.guru/es/design-patterns/abstract-factory/java/example

 * Demo class. Everything comes together here.
 */
public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        //String osName = System.getProperty("os.name").toLowerCase();
        String osName = "windows";
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}