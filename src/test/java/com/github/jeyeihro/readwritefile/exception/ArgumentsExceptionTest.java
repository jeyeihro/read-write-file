package com.github.jeyeihro.readwritefile.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentsExceptionTest {
    @Test
    void init(){
        ArgumentsException argumentsException = new ArgumentsException("");
        assertEquals(ArgumentsException.class, argumentsException.getClass());
        assertInstanceOf(ReadWriteFileException.class, argumentsException);
    }
}