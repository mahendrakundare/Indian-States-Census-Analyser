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
    public void toTestFilePresentOrNot() {
        Analyser analyser = new Analyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            analyser.readStateData();
        } catch (CensusException |IOException  e) {
            Assert.assertEquals("File not found",e.getMessage());
        }
    }
}
