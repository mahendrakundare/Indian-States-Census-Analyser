package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Analyser {

    public static <T> CsvToBean OpenCsvBuilder(String fileName, String className) {
        CsvToBean<T> csvToBean;
        try {
            Class localClass = Class.forName(className);
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Class.forName(className))
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int readData(String fileName,String classname) throws CensusException {
        int count = 0;
        try {
            CsvToBean<State> csvToBean=OpenCsvBuilder(fileName, classname);
            Iterator<State> myUserIterator = csvToBean.iterator();
            while (myUserIterator.hasNext()) {
                State csvStates = myUserIterator.next();
                count++;
            }
        } catch (RuntimeException e) {
            throw new CensusException("ERROR IN FILE TYPE OR IN FILE DELIMITER OR IN FILE HEADER", CensusException.ExceptionType.INVALID_TYPE);
        }
        System.out.println(count);
        return count;
    }

    public static int readStateCensusData(String fileName,String classname) throws CensusException {
        int count=0;
        try {
            CsvToBean<StateCensus> csvToBean = OpenCsvBuilder(fileName, classname);
            Iterator<StateCensus> censusIterator = csvToBean.iterator();
            while (censusIterator.hasNext()) {
                StateCensus stateCensus = censusIterator.next();
                count++;
            }
        } catch (RuntimeException e) {
            throw new CensusException("ERROR IN FILE TYPE OR IN FILE DELIMITER OR IN FILE HEADER", CensusException.ExceptionType.INVALID_TYPE);
        }
        System.out.println(count);
        return count;
    }
}