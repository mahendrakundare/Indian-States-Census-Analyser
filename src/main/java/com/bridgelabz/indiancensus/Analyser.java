package com.bridgelabz.indiancensus;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRuntimeException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Analyser {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCode.csv";

    public int readStateData() throws CensusException, IOException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(State.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<State> stateIterator = csvToBean.iterator();

            while (stateIterator.hasNext()) {
                    State state = stateIterator.next();
                    state.getSrNo();
                    state.getStateName();
                    state.getTIN();
                    state.getStateCode();
                    count++;
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
            throw new CensusException("no such csv file ",CensusException.ExceptionType.NO_SUCH_FILE);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new CensusException("Error in header",CensusException.ExceptionType.NO_HEADER);
        }
        return count;
    }
}