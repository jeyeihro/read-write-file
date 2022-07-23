package com.github.jeyeihro.readwritefile.exception;

import java.io.IOException;

public class ContentsCreateException extends ReadWriteFileException {
    public ContentsCreateException(IOException e) {
        super(e);
    }
}
