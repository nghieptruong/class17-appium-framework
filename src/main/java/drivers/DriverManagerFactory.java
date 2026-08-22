package drivers;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String platform) {
        return switch (platform) {
            case "android" -> new AndroidDriverManager();
            case "ios" -> new IOSDriverManager();
            default -> null;
        };
    }
}
