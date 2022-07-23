package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceFileNotFoundExceptionTest {
    @Test
    void init(){
        SourceFileNotFoundException sourceFileNotFoundException = new SourceFileNotFoundException("");
        assertEquals(SourceFileNotFoundException.class, sourceFileNotFoundException.getClass());
        assertInstanceOf(ReadWriteFileException.class, sourceFileNotFoundException);
    }

}