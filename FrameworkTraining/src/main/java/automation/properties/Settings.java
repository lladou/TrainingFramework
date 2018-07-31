package automation.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private final static String PROPERTIES_FILE_NAME = "config.properties";
    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                InputStream resourceAsStream = Settings.class.getClassLoader()
                        .getResourceAsStream(PROPERTIES_FILE_NAME);
                if (resourceAsStream != null) {
                    properties.load(resourceAsStream);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        return properties;
    }

    public static String getDbConnectionString() {
        return getProperties().getProperty("dbConnectionString");
    }

    public static String getLiveMessageApiUrl() {
        return getProperties().getProperty("liveMessageApiUrl");
    }

    public static String getLiveMessageUsername() {
        return getProperties().getProperty("liveMessageUsername");
    }

    public static String getLiveMessagePassword() {
        return getProperties().getProperty("liveMessagePassword");
    }

    public static String getLiveMessageAdminAccountId() {
        return getProperties().getProperty("liveMessageAdminAccountId");
    }

    public static String getLiveMessageAdminPassword() {
        return getProperties().getProperty("liveMessageAdminPassword");
    }

    public static String getForceApiVersion() {
        return getProperties().getProperty("forceApiVersion");
    }

    public static String getForceLoginUrl() {
        return getProperties().getProperty("forceLoginUrl");
    }

    public static String getForceUsername() {
        return getProperties().getProperty("forceUsername");
    }

    public static String getForcePassword() {
        return getProperties().getProperty("forcePassword");
    }

    public static String getForceClientId() {
        return getProperties().getProperty("forceClientId");
    }

    public static String getForceClientSecret() {
        return getProperties().getProperty("forceClientSecret");
    }
}
