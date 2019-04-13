package dev.spiti.utilties.configreader.readers;

import dev.spiti.utilties.configreader.ConfigReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BaseConfig implements ConfigReader {

    public static final String BASIC = "project";
    public Map<String, String> properties;


    public String getPath() {
        return System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "test" + File.separator
                + "resources" + File.separator;
    }

    public Map<String, String> readConfig(String env) {
        return new HashMap<>();
    }


    public Map<String, String> getConfig() {
        return new HashMap<>();
    }

    public String makeKey(String... parts) {
        return String.join(".", parts);
    }

    public void mergeProperties(Map<String, String> props) {
        props.forEach(properties::putIfAbsent);
    }


}
