package com.bridgelabz.indiancensus;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Analyser {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCode.csv";

    public int readStateData() {
        int count = 0;
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
//                System.out.println("Name : " + state.getSrNo());
//                System.out.println("Email : " + state.getStateName());
//                System.out.println("PhoneNo : " + state.getStateCode());
//                System.out.println("Country : " + state.getTIN());
//                System.out.println("==========================");
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}