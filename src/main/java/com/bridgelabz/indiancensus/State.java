package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvBindByName;

public class State {
    @CsvBindByName
    private String SrNo;

    @CsvBindByName
    private String StateName;

    @CsvBindByName
    private String StateCode;

    @CsvBindByName
    private String TIN;

    public String getSrNo() {
        return SrNo;
    }

    public void setSrNo(String srNo) {
        SrNo = srNo;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }
}
