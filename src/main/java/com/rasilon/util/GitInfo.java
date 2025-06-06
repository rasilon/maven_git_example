package com.rasilon.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GitInfo {
    private static GitInfo singleton = null;

    public static String getInfo() {
        if(singleton == null) return initialiseInfo();
        return singleton.getCachedInfo();
    }

    private static synchronized String initialiseInfo() {
        if(singleton != null) return singleton.getCachedInfo();
        singleton = new GitInfo();
        singleton.buildCache();
        return singleton.getCachedInfo();
    }

    private String cachedJSON = null;

    private void buildCache() {
        try (InputStream input = GitInfo.class.getClassLoader().getResourceAsStream("git.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();;
            cachedJSON = gson.toJson(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load git info",ex);
        }
    }

    private String getCachedInfo() {
        return cachedJSON;
    }

}
