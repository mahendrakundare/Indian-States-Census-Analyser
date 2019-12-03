package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvBindByName;

public class StateCensusData {

    @CsvBindByName
    private String SrNo;
    @CsvBindByName
    private String StateName;
    @CsvBindByName
    private String StateCode;
    @CsvBindByName
    private String TIN;
    @CsvBindByName
    private String Population;
    @CsvBindByName
    private String AreaInSqKm;
    @CsvBindByName
    private String DensityPerSqKm;

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

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }
}
