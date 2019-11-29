package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;

public class AnalyserTest {

    @Test
    public void toCheckNumberOfRecords() {
        Analyser analyser = new Analyser();
        Assert.assertEquals(37, analyser.readStateData());
    }
}
