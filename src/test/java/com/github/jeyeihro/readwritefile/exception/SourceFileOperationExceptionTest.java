package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceFileOperationExceptionTest {
    @Test
    void init(){
        SourceFileOperationException sourceFileOperationException = new SourceFileOperationException(new UnsupportedOperationException());
        assertEquals(SourceFileOperationException.class, sourceFileOperationException.getClass());
        assertInstanceOf(ReadWriteFileException.class, sourceFileOperationException);
    }
}