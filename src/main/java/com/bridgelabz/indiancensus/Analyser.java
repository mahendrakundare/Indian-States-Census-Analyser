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

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCod.csv";

    public int readStateData() throws CensusException{
        int count = 0;
        if (SAMPLE_CSV_FILE_PATH.contains(".csv"))
            throw new CensusException("invalid file type extension", CensusException.ExceptionType.INVALID_FILE_TYPE);
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<State> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(State.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<State> stateIterator = csvToBean.iterator();

            while (stateIterator.hasNext()) {
                State state = stateIterator.next();
                count++;
            }
        } catch (NoSuchFileException e) {
            throw new CensusException("invalid csv file name", CensusException.ExceptionType.FILE_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void checkFileType() {
        File file = new File(SAMPLE_CSV_FILE_PATH);
        String ext = getFileExtension(file);

        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}