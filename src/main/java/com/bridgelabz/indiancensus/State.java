package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvBindByName;

public class State {
    @CsvBindByName(column = "SrNo", required = true)
    private String SrNo;

    @CsvBindByName(column = "StateName", required = true)
    private String StateName;

    @CsvBindByName(column = "StateCode", required = true)
    private String StateCode;

    @CsvBindByName(column = "TIN", required = true)
    private String TIN;

//    @CsvBindByName
//    private String abc;

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
