package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContentsCreateExceptionTest {
    @Test
    void init(){
        ContentsCreateException contentsCreateException = new ContentsCreateException(new IOException(""));
        assertEquals(ContentsCreateException.class, contentsCreateException.getClass());
        assertInstanceOf(ReadWriteFileException.class, contentsCreateException);
    }
}