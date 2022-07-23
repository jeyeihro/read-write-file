package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ReadWriteFileExceptionTest {
    @Test
    void init_1(){
        ReadWriteFileException readWriteFileException = new ReadWriteFileException("");
        assertEquals(ReadWriteFileException.class, readWriteFileException.getClass());
        assertInstanceOf(Exception.class, readWriteFileException);
    }

    @Test
    void init_2(){
        ReadWriteFileException readWriteFileException = new ReadWriteFileException(new Exception());
        assertEquals(ReadWriteFileException.class, readWriteFileException.getClass());
        assertInstanceOf(Exception.class, readWriteFileException);
    }
}