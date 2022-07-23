package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetFileFlushExceptionTest {
    @Test
    void init(){
        TargetFileFlushException targetFileFlushException = new TargetFileFlushException(new Exception());
        assertEquals(TargetFileFlushException.class, targetFileFlushException.getClass());
        assertInstanceOf(ReadWriteFileException.class, targetFileFlushException);
    }
}