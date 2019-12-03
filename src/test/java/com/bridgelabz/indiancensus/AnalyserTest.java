package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AnalyserTest {

    @Test
gt    public void toCheckNumberOfRecords() throws IOException, CensusException {
        Analyser analyser = new Analyser();
        Assert.assertEquals(37, analyser.readStateData());
    }

    @Test
    public void toTestFilePresentOrNot() throws IOException {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            //  exceptionRule.expect(CensusException.class);
            analyser.readStateData();
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
            analyser.readStateData();
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.INVALID_TYPE, e.type);
        }
    }

    @Test
    public void testToCheckDelimiterincorretShouldThrowException() throws IOException {
        Analyser analyser = new Analyser();
        try {
            Assert.assertEquals(37, analyser.readStateData());
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
            analyser.readStateData();
        } catch (CensusException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.NO_HEADER,e.type);
        }
    }



}
