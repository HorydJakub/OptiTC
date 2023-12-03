package core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class PropertiesHandler {

    private Properties properties = new Properties();

    public PropertiesHandler() {
        loadProperties();
    }

    public static void updatePropertiesFile(String url, String username, String password) {

        // Update the values
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        propertiesHandler.properties.setProperty("sql.url", "\"" + url + "\"");
        propertiesHandler.properties.setProperty("sql.user", "\"" + username + "\"");
        propertiesHandler.properties.setProperty("sql.password", "\"" + password + "\"");

        // Save the file
        propertiesHandler.saveProperties();
    }

    public static void createPropertiesFile(String url, String username, String password) {

            // Create the file
            PropertiesHandler propertiesHandler = new PropertiesHandler();
            propertiesHandler.properties.setProperty("sql.url", "\"" + url + "\"");
            propertiesHandler.properties.setProperty("sql.user", "\"" + username + "\"");
            propertiesHandler.properties.setProperty("sql.password", "\"" + password + "\"");

            // Save the file
            propertiesHandler.saveProperties();
    }

    public static void createDefaultPropertiesFile() {
        String resourcesDirPath = "src\\main\\resources";
        File resourcesDir = new File(resourcesDirPath);
        File defaultPropertiesFile = new File(resourcesDir, "default.properties");
        File configPropertiesFile = new File(resourcesDir, "config.properties");

        if (!defaultPropertiesFile.exists()) {
            if (configPropertiesFile.exists()) {
                try {
                    Files.copy(configPropertiesFile.toPath(), defaultPropertiesFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("default.properties has been created.");
                } catch (IOException e) {
                    System.err.println("There was an error during creation of the file: " + e.getMessage());
                }
            } else {
                System.out.println("config.properties does not exist. Please pull the latest version of the project.");
            }
        }
    }
    private void saveProperties() {
        try {
            String filePath = PropertiesHandler.class.getClassLoader().getResource("default.properties").getPath();
            if (filePath != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                properties.store(fileOutputStream, null);
                fileOutputStream.close();
            } else {
                System.out.println("Sorry, unable to find default.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static boolean isDefaultPropertiesFileExists() {
        return PropertiesHandler.class.getClassLoader().getResource("default.properties") != null;
    }
}
