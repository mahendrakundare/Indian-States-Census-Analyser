package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AnalyserTest {
    private static final String STATE_CODE_DATA = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCode.csv";
    private static final String STATE_CENSUS_DATA ="/home/admin1/IdeaProjects/Indian States Census Analyser/StateCensusData.csv";
    private static final String STATE_CLASS="com.bridgelabz.indiancensus.State";
    private static final String STATE_CENSUS_CLASS="com.bridgelabz.indiancensus.StateCensus";
        @Test
    public void toCheckNumberOfRecords() throws IOException, CensusException {
        Analyser analyser = new Analyser();
//        Assert.assertEquals(37, analyser.readStateData(STATE_CODE_DATA,STATE_CLASS));
        Assert.assertEquals(37, analyser.readData(STATE_CODE_DATA,STATE_CLASS));
    }
    @Test
    public void toTestStateDataFilePresentOrNot() throws IOException, ClassNotFoundException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            //  exceptionRule.expect(CensusException.class);
            analyser.readData(STATE_CODE_DATA,STATE_CLASS);
        } catch (CensusException e) {
//            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void toTestFilePresentOrNot() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            //  exceptionRule.expect(CensusException.class);
            analyser.readData(STATE_CODE_DATA,STATE_CLASS);
        } catch (CensusException e) {
//            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void testToCheckTheFileTypeIfNotMatchThenThrowError() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            analyser.readData(STATE_CODE_DATA,STATE_CLASS);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.INVALID_TYPE, e.type);
        }
    }

    @Test
    public void testToCheckDelimiterincorretShouldThrowException() throws IOException {
        Analyser analyser = new Analyser();
        try {
            Assert.assertEquals(37, analyser.readData(STATE_CODE_DATA,STATE_CLASS));
        } catch (CensusException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusException.ExceptionType.INCORRECT_DELIMITER, e.type);
        }
    }

    @Test
    public void testToCheckIfCSVhasHeaderOrNot() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            analyser.readData(STATE_CODE_DATA,STATE_CLASS);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.NO_HEADER,e.type);
        }
    }

    //===============================================================================
    //===uc 2

    @Test
    public void toCheckNumberofCensusRecord() throws IOException, CensusException {
        Analyser analyser = new Analyser();
        Assert.assertEquals(29, analyser.readStateCensusData(STATE_CENSUS_DATA,STATE_CENSUS_CLASS));
    }

    @Test
    public void toCheckFileIsIncorrectShouldReturnFalse() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            analyser.readStateCensusData(STATE_CENSUS_DATA,STATE_CENSUS_CLASS);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void testToCheckCensusFileTypeIfNotMatchThenThrowError() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            analyser.readStateCensusData(STATE_CENSUS_DATA,STATE_CENSUS_CLASS);
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.INVALID_TYPE, e.type);
        }
    }

    @Test
    public void testToCensusDelimiterincorretShouldThrowException() throws IOException {
        Analyser analyser = new Analyser();
        try {
            Assert.assertEquals(37, analyser.readStateCensusData(STATE_CENSUS_DATA,STATE_CENSUS_CLASS));
        } catch (CensusException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusException.ExceptionType.INCORRECT_DELIMITER, e.type);
        }
    }

    @Test
    public void toTestStateCensusDataFilePresentOrNot() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            //  exceptionRule.expect(CensusException.class);
            analyser.readStateCensusData(STATE_CENSUS_DATA,STATE_CENSUS_CLASS);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
