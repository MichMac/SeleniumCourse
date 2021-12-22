package configuration;

import driver.BrowserType;

import java.net.URL;

public class TestRunProperties {

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

    public static boolean getIsRemoteRun(){
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }

    public static String getGridUrl(){
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }
}

