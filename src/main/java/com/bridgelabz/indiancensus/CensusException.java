package com.bridgelabz.indiancensus;

public class CensusException extends Exception {

    enum ExceptionType {
        NO_SUCH_FILE,FILE_NOT_FOUND, INVALID_TYPE, INCORRECT_DELIMITER, NO_HEADER;
    }

    ExceptionType type;

    public CensusException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
