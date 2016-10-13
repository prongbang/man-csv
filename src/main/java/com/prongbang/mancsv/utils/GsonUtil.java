package com.prongbang.mancsv.utils;

import com.google.gson.GsonBuilder;

/**
 * Created by prongbang on 10/13/2016.
 */
public class GsonUtil {

    public static String getPretty(Object object){

        return new GsonBuilder().setPrettyPrinting().create().toJson(object);
    }

}
