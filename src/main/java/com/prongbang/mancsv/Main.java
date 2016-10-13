package com.prongbang.mancsv;

import com.prongbang.mancsv.model.User;
import com.prongbang.mancsv.parse.ParseCSV;
import com.prongbang.mancsv.utils.FileUtil;
import com.prongbang.mancsv.utils.GsonUtil;

import java.io.File;
import java.util.List;

/**
 * Created by prongbang on 10/13/2016.
 */
public class Main {

    public static void main(String[] args) {

        String csvPath = FileUtil.getPathResources() + File.separator + "Template.csv";
        String[] csvColumnMapping = new String[] { "ID","NAME","SURNAME","NICKNAME","PHONE","ADDRESS" };
        List<User> users = ParseCSV.toBean(csvPath, csvColumnMapping, User.class);
        System.out.println(GsonUtil.getPretty(users));

    }

}
