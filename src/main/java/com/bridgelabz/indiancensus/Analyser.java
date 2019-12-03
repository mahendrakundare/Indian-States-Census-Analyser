package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class Analyser {

    private static final String COMBINE_DATA_CLASS="com.bridgelabz.indiancensus.CombineStateCensus";
    private static final String COMBINE_DATA_FILE="/home/admin1/IdeaProjects/Indian States Census Analyser/CommanStateData.csv";
    private static final String STATE_CENSUS_DATA ="/home/admin1/IdeaProjects/Indian States Census Analyser/StateCensusData.csv";
    private static final String STATE_CENSUS_CLASS="com.bridgelabz.indiancensus.StateCensus";

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


    public static void readCombineData() {
        int count=0;
        try {

            //combine csv
            CsvToBean<StateCensusData> csvToBean = OpenCsvBuilder(COMBINE_DATA_FILE,COMBINE_DATA_CLASS);
            Iterator<StateCensusData> combineStateCensusIterator = csvToBean.iterator();

            //state census csv
            CsvToBean<StateCensus> csvToStateCensusBean = OpenCsvBuilder(STATE_CENSUS_DATA, STATE_CENSUS_CLASS);
            Iterator<StateCensus> stateCensusIterator = csvToStateCensusBean.iterator();

            List<StateCensusData> stateCensusDataList = csvToBean.parse();
            while (combineStateCensusIterator.hasNext()) {
                StateCensusData stateCensusData = combineStateCensusIterator.next();
                while (stateCensusIterator.hasNext()) {
                    StateCensus stateCensus = stateCensusIterator.next();
                    if (stateCensusData.getStateName().equals(stateCensus.getState())) {
                        stateCensusData.setPopulation(stateCensus.getPopulation());
                        stateCensusData.setAreaInSqKm(stateCensus.getAreaInSqKm());
                        stateCensusData.setDensityPerSqKm(stateCensus.getDensityPerSqKm());
                        stateCensusDataList.add(stateCensusData);
                        System.out.println(stateCensusData.getSrNo()+" "+ stateCensusData.getStateName()+""+ stateCensusData.getStateCode()
                                +" "+ stateCensusData.getTIN()+" "+ stateCensusData.getDensityPerSqKm()+" "+ stateCensusData.getAreaInSqKm()
                                +" "+ stateCensusData.getPopulation());
                        break;
                    }
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}