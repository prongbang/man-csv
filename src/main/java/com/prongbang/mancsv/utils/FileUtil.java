package com.prongbang.mancsv.utils;


import java.nio.file.Paths;

/**
 * Created by prongbang on 10/13/2016.
 */
public class FileUtil {

    public static String getCurrentPath() {

        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    public static String getPathResources() {

        String path = FileUtil.getCurrentPath();

        return path + "/src/main/resources";
    }

}
