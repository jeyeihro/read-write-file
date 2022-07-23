package com.github.jeyeihro.readwritefile.content;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContentsTest {
    @Test
    void constructor_1(){
        Contents contents = new Contents("CONTENTS");
        String expected = "CONTENTS";
        assertEquals(expected, contents.toString());
        assert(Arrays.equals(expected.getBytes(StandardCharsets.UTF_8), contents.toBytes()));
        assertEquals(StandardCharsets.UTF_8, contents.getCharset());
    }

    @Test
    void constructor_2(){
        Contents contents = new Contents("CONTENTS2", Charset.forName("Shift-JIS"));
        String expected = "CONTENTS2";
        assertEquals(expected, contents.toString());
        assert(Arrays.equals(expected.getBytes(Charset.forName("Shift-JIS")), contents.toBytes()));
        assertEquals(Charset.forName("Shift-JIS"), contents.getCharset());
    }

    @Test
    void constructor_3(){
        String init = "CONTENTS3";
        byte[] b = init.getBytes(StandardCharsets.UTF_8);
        Contents contents = new Contents(b);
        String expected = "CONTENTS3";
        assertEquals(expected, contents.toString());
        assert(Arrays.equals(expected.getBytes(StandardCharsets.UTF_8), contents.toBytes()));
        assertEquals(StandardCharsets.UTF_8, contents.getCharset());
    }

    @Test
    void constructor_4(){
        String init = "CONTENTS4";
        byte[] b = init.getBytes(Charset.forName("Shift-JIS"));
        Contents contents = new Contents(b, Charset.forName("Shift-JIS"));
        String expected = "CONTENTS4";
        assertEquals(expected, contents.toString());
        assert(Arrays.equals(expected.getBytes(Charset.forName("Shift-JIS")), contents.toBytes()));
        assertEquals(Charset.forName("Shift-JIS"), contents.getCharset());
    }

    @Test
    void isEmptyTest(){
        Contents contents = new Contents("".getBytes(StandardCharsets.UTF_8));
        assertTrue(contents.isEmpty());
    }

}