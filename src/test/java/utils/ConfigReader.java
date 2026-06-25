package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties not found");
            }

            PROPERTIES.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}