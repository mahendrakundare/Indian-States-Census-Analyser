package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;

public class AnalyserTest {
    @Test
    public void toCheckNumberOfRecords() {
        StateData stateData = new StateData();
        Assert.assertEquals(38,stateData.readData());
    }
}
