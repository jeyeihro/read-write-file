package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetFileInitializeExceptionTest {
    @Test
    void init(){
        TargetFileInitializeException targetFileInitializeException = new TargetFileInitializeException("");
        assertEquals(TargetFileInitializeException.class, targetFileInitializeException.getClass());
        assertInstanceOf(ReadWriteFileException.class, targetFileInitializeException);
    }
}