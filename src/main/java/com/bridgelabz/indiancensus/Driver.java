package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvToBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.bridgelabz.indiancensus.Analyser.OpenCsvBuilder;


public class Driver {

    public static void main(String[] args) {

        Analyser.readCombineData();
    }

}
