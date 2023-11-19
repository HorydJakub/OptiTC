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
        // if string is between double quotes, delete them
        String url = properties.getProperty("sql.url");
        if (url.startsWith("\"") && url.endsWith("\"")) {
            url = url.substring(1, url.length() - 1);
        }
        return url;
    }

    public String getSqlUser() {
        // if string is between double quotes, delete them
        String user = properties.getProperty("sql.user");
        if (user.startsWith("\"") && user.endsWith("\"")) {
            user = user.substring(1, user.length() - 1);
        }
        return user;
    }

    public String getSqlPassword() {
        // if string is between double quotes, delete them
        String password = properties.getProperty("sql.password");
        if (password.startsWith("\"") && password.endsWith("\"")) {
            password = password.substring(1, password.length() - 1);
        }
        // if password is equal double quotes, return empty string
        if (password.equals("\"\"")) {
            password = "";
        }
        return password;
    }
}
