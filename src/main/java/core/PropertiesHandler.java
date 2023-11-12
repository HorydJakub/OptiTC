package core;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {

    private Properties properties = new Properties();

    public PropertiesHandler() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSqlUrl() {
        return properties.getProperty("sql.url");
    }

    public String getSqlUser() {
        return properties.getProperty("sql.user");
    }

    public String getSqlPassword() {
        return properties.getProperty("sql.password");
    }
}
