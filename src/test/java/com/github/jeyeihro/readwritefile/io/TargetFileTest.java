package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.exception.ContentsEmptyException;
import com.github.jeyeihro.readwritefile.exception.TargetFileFlushException;
import com.github.jeyeihro.readwritefile.exception.TargetFileInitializeException;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TargetFileTest {
    @Test
    void flushableTest_1(){
        TargetFile targetFile = new TargetFile();
        targetFile.setContents(new Contents("file contents"));
        assertFalse(targetFile.flushable());
    }

    @Test
    void flushableTest_2(){
        TargetFile targetFile = new TargetFile();
        assertFalse(targetFile.flushable());
    }

    @Test
    void flushableTest_3(){
        TargetFile targetFile = new TargetFile();
        targetFile.setFile(new File(""));
        assertFalse(targetFile.flushable());
    }

    @Test
    void flushTest_1(){
        TargetFile targetFile = new TargetFile();
        assertThrows(TargetFileInitializeException.class, targetFile::flush);
    }

    @Test
    void flushTest_2(){
        TargetFile targetFile = new TargetFile();
        targetFile.setFile(new File(""));
        assertThrows(TargetFileInitializeException.class, targetFile::flush);
    }

    @Test
    void flushTest_3(){
        TargetFile targetFile = new TargetFile();
        targetFile.set(new File(""), new Contents(""));
        assertThrows(ContentsEmptyException.class, targetFile::flush);
    }

    @Test
    void flushTest_4(){
        TargetFile targetFile = new TargetFile();
        targetFile.set(new File(""), new Contents("file contents"));
        assertThrows(TargetFileFlushException.class, targetFile::flush);
    }

}