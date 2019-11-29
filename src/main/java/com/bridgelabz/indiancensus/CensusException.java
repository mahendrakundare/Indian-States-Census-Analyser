package com.bridgelabz.indiancensus;

public class CensusException extends Exception {

    enum ExceptionType {
        FILE_NOT_FOUND
    }

    ExceptionType type;

    public CensusException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
