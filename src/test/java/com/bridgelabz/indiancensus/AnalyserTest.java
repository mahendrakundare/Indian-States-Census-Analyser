package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AnalyserTest {

    @Test
    public void toCheckNumberOfRecords() throws IOException, CensusException {
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
            e.printStackTrace();
            Assert.assertEquals(CensusException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void testToCheckTheFileTypeIfNotMatchThenThrowError() {
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


}
