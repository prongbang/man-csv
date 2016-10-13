package com.prongbang.mancsv.parse;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prongbang on 10/13/2016.
 */
public class ParseCSV {

    /**
     * Parse csv to bean
     *
     * @param csvPath          : path/filename.csv
     * @param csvColumnMapping : new String[] {"column", "column"}
     * @param clazz            : ClassName.class
     * @param <T>              : CLassName
     * @return : List<ClassName>
     */
    public static <T> List<T> toBean(String csvPath, String[] csvColumnMapping, Class<T> clazz) {

        List<T> dataList = new ArrayList<T>();

        CSVReader csvReader = null;

        try {
            csvReader = new CSVReader(new FileReader(csvPath), ',', '"', 1);

            ColumnPositionMappingStrategy<T> mappingStrategy = new ColumnPositionMappingStrategy<T>();
            mappingStrategy.setType(clazz);
            mappingStrategy.setColumnMapping(csvColumnMapping);

            CsvToBean<T> ctb = new CsvToBean<>();
            dataList = ctb.parse(mappingStrategy, csvReader);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert csvReader != null;
                csvReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dataList;
    }

}
