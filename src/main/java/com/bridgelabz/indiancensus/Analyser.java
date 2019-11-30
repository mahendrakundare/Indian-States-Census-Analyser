package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Analyser {

    private static final String STATE_CODE_DATA = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCode.csv";
//    private static final String STATE_CENSUS_DATA ="/home/admin1/IdeaProjects/Indian States Census Analyser/StateCensusData.csv";
    public int readStateData() throws CensusException, IOException {
        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_DATA))) {
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


    public int readStateCensusData(String STATE_CENSUS_DATA) throws IOException, CensusException {

        int count = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_DATA))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<StateCensus> censusIterator = csvToBean.iterator();

            while (censusIterator.hasNext()) {
                StateCensus stateCensus = censusIterator.next();
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