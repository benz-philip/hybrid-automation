package com.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import org.yaml.snakeyaml.Yaml;
import com.framework.logger.Log;

public class Config {

    static Properties conf = new Properties();

    /**
     * Method to initialize configuration.
     */
    public static Properties initializeConfig() {
        try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            conf.load(fis);

            Map<String, String> additionalConfig = null;
            String platformProperty = System.getProperty("environment");
            String platform = (platformProperty != null) ? platformProperty : "SAMSUNG_ANDROID";
            additionalConfig = parseYaml("src/main/resources/sessions.yml", platform);
            loadDeviceProperty(additionalConfig);
        } catch (Exception e) {
            Log.warn(e.getMessage());
        }
        return conf;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String> parseYaml(String filename, String parameter) throws IOException {
        FileInputStream fis = null;
        Map<String, Object> platforms;
        Map<String, String> configs = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/" + filename);
            platforms = new Yaml().load(fis);
            for (Entry<String, Object> key : platforms.entrySet()) {
                if (key.getKey().equalsIgnoreCase(parameter)) {
                    configs = (Map<String, String>) key.getValue();
                    break;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return configs;
    }

    /**
     * Method to load properties specific for the emulator/device
     *
     * @param: properties
     *             the map of emulator properties read from the sessions.yml file
     */

    public static void loadDeviceProperty(Map<String, String> properties) {
        for (Entry<String, String> config : properties.entrySet()) {
            conf.setProperty(config.getKey(), config.getValue());
        }
    }

}
