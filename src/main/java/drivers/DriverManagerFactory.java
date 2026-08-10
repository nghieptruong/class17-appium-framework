package drivers;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String browser) {
        return switch (browser) {
            case "chrome" -> new ChromeDriverManager();
            case "firefox" -> new FirefoxDriverManager();
            case "safari" -> new SafariDriverManager();
            case "edge" -> new EdgeDriverManager();
            default -> null;
        };
    }
}
