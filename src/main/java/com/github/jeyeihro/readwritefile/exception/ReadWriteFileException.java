package com.github.jeyeihro.readwritefile.exception;

public class ReadWriteFileException extends Exception{
    public ReadWriteFileException(String s) {
        super(s);
    }

    public ReadWriteFileException(Exception e) {
        super(e);
    }
}
