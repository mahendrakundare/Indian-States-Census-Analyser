package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AnalyserTest {
    private static final String STATE_CODE_DATA = "/home/admin1/IdeaProjects/Indian States Census Analyser/StateCode.csv";
    private static final String STATE_CENSUS_DATA ="/home/admin1/IdeaProjects/Indian States Census Analyser/StateCensusData.csv";

    //    @Test
//    public void toCheckNumberOfRecords() throws IOException, CensusException {
//        Analyser analyser = new Analyser();
//        Assert.assertEquals(37, analyser.readStateData());
//    }
//    @Test
//    public void toTestFilePresentOrNot() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            //  exceptionRule.expect(CensusException.class);
//            analyser.readStateData();
//        } catch (CensusException e) {
////            e.printStackTrace();
//            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE, e.type);
//        }
//    }
//
//    @Test
//    public void toTestFilePresentOrNot() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            //  exceptionRule.expect(CensusException.class);
//            analyser.readStateData();
//        } catch (CensusException e) {
////            e.printStackTrace();
//            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE, e.type);
//        }
//    }
//
//    @Test
//    public void testToCheckTheFileTypeIfNotMatchThenThrowError() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            exceptionRule.expect(CensusException.class);
//            analyser.readStateData();
//        } catch (CensusException e) {
//            e.printStackTrace();
//            Assert.assertEquals(CensusException.ExceptionType.INVALID_TYPE, e.type);
//        }
//    }
//
//    @Test
//    public void testToCheckDelimiterincorretShouldThrowException() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            Assert.assertEquals(37, analyser.readStateData());
//        } catch (CensusException e) {
//            System.out.println(e.getMessage());
//            Assert.assertEquals(CensusException.ExceptionType.INCORRECT_DELIMITER, e.type);
//        }
//    }
//
//    @Test
//    public void testToCheckIfCSVhasHeaderOrNot() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            exceptionRule.expect(CensusException.class);
//            analyser.readStateData();
//        } catch (CensusException e) {
//            e.printStackTrace();
//            Assert.assertEquals(CensusException.ExceptionType.NO_HEADER,e.type);
//        }
//    }
//
//    //===============================================================================
//    //===uc 2
//
//    @Test
//    public void toCheckNumberofCensusRecord() throws IOException, CensusException {
//        Analyser analyser = new Analyser();
//        Assert.assertEquals(29, analyser.readStateCensusData());
//    }
//
//    @Test
//    public void toCheckFileIsIncorrectShouldReturnFalse() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            exceptionRule.expect(CensusException.class);
//            analyser.readStateCensusData();
//        } catch (CensusException e) {
//            e.printStackTrace();
//            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE,e.type);
//        }
//    }
//
//    @Test
//    public void testToCheckCensusFileTypeIfNotMatchThenThrowError() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            ExpectedException exceptionRule = ExpectedException.none();
//            exceptionRule.expect(CensusException.class);
//            analyser.readStateCensusData();
//        } catch (CensusException e) {
//            e.printStackTrace();
//            Assert.assertEquals(CensusException.ExceptionType.INVALID_TYPE, e.type);
//        }
//    }
//
//    @Test
//    public void testToCensusDelimiterincorretShouldThrowException() throws IOException {
//        Analyser analyser = new Analyser();
//        try {
//            Assert.assertEquals(37, analyser.readStateData());
//        } catch (CensusException e) {
//            System.out.println(e.getMessage());
//            Assert.assertEquals(CensusException.ExceptionType.INCORRECT_DELIMITER, e.type);
//        }
//    }
//
//    @Test
//    public void testToCensusFileIfHeaderNotPresentThenThrowException() {
//
//    }

    @Test
    public void toTestFilePresentOrNot() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            //  exceptionRule.expect(CensusException.class);
            analyser.readStateCensusData(STATE_CENSUS_DATA);
        } catch (CensusException e) {
//            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
