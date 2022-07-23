package com.github.jeyeihro.readwritefile.example.singleTarget;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import com.github.jeyeihro.readwritefile.codes.ExitCode;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.fail;

class ExampleMainTest {
    @Test
    void init(){
        new ExampleMain();
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_error_1(){
        ExampleMain.main(null);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_error_2(){
        String[] args = {"", ""};
        ExampleMain.main(args);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_error_3(){
        String[] args = {""};
        ExampleMain.main(args);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_error_4(){
        ExampleMain.main(new String[0]);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_Done(@TempDir Path tempDir){
        File sourceFile = tempDir.resolve("sourceFile.txt").toFile();
        try(FileOutputStream fos = new FileOutputStream(sourceFile)){
            fos.write("aaa\nbbb\nccc\nddd".getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (IOException e) {
            fail("source-file create failed.");
        }

        String[] args = {sourceFile.getAbsolutePath()};
        ExampleMain.main(args);
    }

    @Test
    @ExpectSystemExitWithStatus(1)
    void abendTest(){
        ExampleMain.abend(new ReadWriteFileException(""), ExitCode.ErrorArguments);
    }
}