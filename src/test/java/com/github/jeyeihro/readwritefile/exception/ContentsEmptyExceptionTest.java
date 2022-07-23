package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentsEmptyExceptionTest {
    @Test
    void init(){
        ContentsEmptyException contentsEmptyException = new ContentsEmptyException("");
        assertEquals(ContentsEmptyException.class, contentsEmptyException.getClass());
        assertInstanceOf(ReadWriteFileException.class, contentsEmptyException);
    }
}