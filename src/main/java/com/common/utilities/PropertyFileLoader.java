package com.common.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLoader {

    public static Properties loadProperties(String filePath) throws IOException {
        FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configuration/devconfig.properties");
        Properties ps = new Properties();
        ps.load(fi);
        return ps;
    }

    public static String getProperty(String keyvalue, String filePath) throws IOException {
        Properties ps = loadProperties(System.getProperty("user.dir")+"/src/test/resources/configuration/devconfig.properties");
        return ps.getProperty(keyvalue);
    }
}
