package core;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Properties;

public class PropertiesHandler {

    private Properties properties = new Properties();
    private final String configFile = "config.properties";

    public PropertiesHandler() {
        loadProperties();
    }

    public static void updateProperties(String url, String user, String password) {
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        propertiesHandler.properties.setProperty("sql.url", url);
        propertiesHandler.properties.setProperty("sql.user", user);
        propertiesHandler.properties.setProperty("sql.password", password);
        propertiesHandler.savePropertiesToFile();
    }

    private void savePropertiesToFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(configFile);
            if (inputStream != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                properties.store(outputStream, null);
                inputStream.close();

                Path originalFilePath = Paths.get(classLoader.getResource(configFile).toURI());
                Files.write(originalFilePath, outputStream.toByteArray(), StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                System.out.println("Sorry, unable to find " + configFile);
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFile)) {
            if (input != null) {
                properties.load(input);
            } else {
                System.out.println("Sorry, unable to find " + configFile);
            }
        } catch (IOException e) {
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
