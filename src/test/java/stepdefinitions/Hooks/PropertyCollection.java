package stepdefinitions.Hooks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyCollection {

    static String property_value;

    static File file = new File("src/main/java/configuration/configuration.properties");

    public static String get_property_for(String property_key) {
        try (FileReader fileReader = new FileReader(file)) {

            InputStream inputStream = PropertyCollection.class.getClassLoader().getResourceAsStream("configuration/configuration.properties");
            Properties p = new Properties();
            p.load(inputStream);

            property_value = p.getProperty(property_key);
            return property_value;
        } catch (IOException e) {
            throw new IllegalArgumentException("can not read the property file", null);
        }

    }
}



