package com.github.jeyeihro.readwritefile.exception;

public class SourceFileOperationException extends ReadWriteFileException{
    public SourceFileOperationException(UnsupportedOperationException e) {
        super(e);
    }
}
