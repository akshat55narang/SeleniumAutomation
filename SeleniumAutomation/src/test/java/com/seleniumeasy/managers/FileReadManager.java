package com.seleniumeasy.managers;

import com.seleniumeasy.dataprovider.ConfigFileReader;

public class FileReadManager {
    private ConfigFileReader configFileReader;
    private static FileReadManager fileReadManager = new FileReadManager();

    private FileReadManager(){

    }

    public static FileReadManager getInstance(){
        return fileReadManager;
    }

    public ConfigFileReader getConfigFileReader(){
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
    }

}
