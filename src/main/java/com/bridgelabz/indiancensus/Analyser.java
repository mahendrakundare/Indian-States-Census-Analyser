package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Analyser {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCode.csv";

    public int readStateData() throws CensusException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(State.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<State> stateIterator = csvToBean.iterator();

            while (stateIterator.hasNext()) {
                State state = stateIterator.next();
                count++;
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            throw new CensusException("no such csv file ",CensusException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new CensusException("no such type",CensusException.ExceptionType.INVALID_TYPE);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CensusException("invalid csv file name", CensusException.ExceptionType.FILE_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}