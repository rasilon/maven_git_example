package com.rasilon.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.rasilon.util.GitInfo;

public class SCMTest {
    public static void main(String[] args) {
        System.out.println(GitInfo.getInfo());
    }
}
