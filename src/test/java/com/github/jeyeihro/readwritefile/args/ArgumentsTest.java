package com.github.jeyeihro.readwritefile.args;

import com.github.jeyeihro.readwritefile.exception.ArgumentsException;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentsTest {
    @Test
    void constructor_1(){
        Arguments arguments = new Arguments(null);
        assertEquals(0, arguments.length());
    }

    @Test
    void constructor_2() throws ArgumentsException {
        String[] args = {"aaa", "bbb", "ccc"};
        Arguments arguments = new Arguments(args);
        assertEquals(3, arguments.length());
        Path p = Paths.get("aaa");
        assertEquals(p.toString(), arguments.firstToPath().toString());
    }

    @Test
    void firstToPathRaise(){
        Arguments arguments = new Arguments(null);
        assertThrows(ArgumentsException.class, arguments::firstToPath);
    }

}