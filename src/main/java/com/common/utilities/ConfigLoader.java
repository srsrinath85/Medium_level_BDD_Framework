package com.common.utilities;

import com.waf.constants.Environment;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private final Properties prop;

    public ConfigLoader() throws IOException {
        String environment = System.getProperty("env", String.valueOf(Environment.DEV));
        String propertiesFilePath = "src/test/resources/configuration/" + environment.toLowerCase()
                + "config.properties";
        prop = PropertyFileLoader.loadProperties(propertiesFilePath);
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}