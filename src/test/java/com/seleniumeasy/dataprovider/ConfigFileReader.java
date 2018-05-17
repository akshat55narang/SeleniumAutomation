package com.seleniumeasy.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties prop;
    private FileInputStream fis;
    public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    private static final String PROP_LOCATION = CURRENT_DIRECTORY+"/src/test/resources/data.properties";

    public ConfigFileReader() {
        prop = new Properties();
        try {
            fis = new FileInputStream(PROP_LOCATION);
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getApplicationURL() {
        String url = prop.getProperty("url");
        if(url != null){
            return url;
        }
        else {
            throw new RuntimeException("URL not set");
        }
    }

    public String getBrowser() {
        String browser = prop.getProperty("browser");
        if(browser != null){
            return browser;
        }
        else {
            throw new RuntimeException("browser not set");
        }
    }

    public Long getImplicitWait() {
        Long implicitWait = Long.parseLong(prop.getProperty("implicitWait"));
        if(implicitWait != null){
            return implicitWait;
        }
        else {
            throw new RuntimeException("implicitWait not set");
        }
    }

    public Long getExplicitWait() {
        Long explicitWait = Long.parseLong(prop.getProperty("explicitWait"));
        if(explicitWait != null){
            return explicitWait;
        }
        else {
            throw new RuntimeException("explicitWait not set");
        }
    }

    public String getChromeDriverPath() {
        String chromeDriverPath = CURRENT_DIRECTORY + prop.getProperty("chromeDriverPath");
        if(chromeDriverPath != null){
            return chromeDriverPath;
        }
        else {
            throw new RuntimeException("URL not set");
        }
    }

}
