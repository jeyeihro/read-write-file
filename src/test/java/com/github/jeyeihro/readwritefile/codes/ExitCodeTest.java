package com.github.jeyeihro.readwritefile.codes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExitCodeTest {
    @Test
    void done(){
        assertEquals(0, ExitCode.Done.id());
    }
}