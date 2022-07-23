package com.github.jeyeihro.readwritefile.exception;

public class ContentsEmptyException extends ReadWriteFileException {
    public ContentsEmptyException(String contents_is_empty) {
        super(contents_is_empty);
    }
}
