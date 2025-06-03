package com.rasilon.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SCMTest {
    public static void main(String[] args) {

        try (InputStream input = SCMTest.class.getClassLoader().getResourceAsStream("git.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            prop.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
