package com.github.jeyeihro.readwritefile.example.multipleTarget;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

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
    void mainTest_Done_1(@TempDir Path tempDir){
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
    @ExpectSystemExitWithStatus(0)
    void mainTest_Done_2(@TempDir Path tempDir){
        File sourceFile = tempDir.resolve("sourceFile.txt").toFile();
        try(FileOutputStream fos = new FileOutputStream(sourceFile)){
            fos.write("aaa\nbbb\nccc\nddd\nddd\nddd\nddd\nddd\nddd\nddd\naaa\nbbb\nccc\nddd\nddd\nddd\nddd\nddd\nddd\nddd".getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (IOException e) {
            fail("source-file create failed.");
        }

        String[] args = {sourceFile.getAbsolutePath()};
        ExampleMain.main(args);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_Done_3(@TempDir Path tempDir){
        File sourceFile = tempDir.resolve("sourceFile.txt").toFile();
        try(FileOutputStream fos = new FileOutputStream(sourceFile)){
            fos.write("aaa\nbbb\nccc\nddd\nddd\nddd\nddd\nddd\nddd\nddd\naaa\nbbb\nccc\nddd\nddd\nddd\nddd\nddd\nddd\nddd\naaa\nbbb\nccc\nddd\nddd\nddd\nddd\nddd\nddd\nddd\naaa\nbbb\nccc\nddd\nddd\nddd\nddd\nddd\nddd\nddd".getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (IOException e) {
            fail("source-file create failed.");
        }

        String[] args = {sourceFile.getAbsolutePath()};
        ExampleMain.main(args);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_Done_4(@TempDir Path tempDir){
        File sourceFile = tempDir.resolve("sourceFile.txt").toFile();
        try(FileOutputStream fos = new FileOutputStream(sourceFile)){
            fos.write("aaa\r\nbbb\r\nccc\r\nddd".getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (IOException e) {
            fail("source-file create failed.");
        }

        String[] args = {sourceFile.getAbsolutePath()};
        ExampleMain.main(args);
    }

    @Test
    @ExpectSystemExitWithStatus(0)
    void mainTest_Done_5(@TempDir Path tempDir){
        File sourceFile = tempDir.resolve("sourceFile").toFile();
        try(FileOutputStream fos = new FileOutputStream(sourceFile)){
            fos.write("".getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (IOException e) {
            fail("source-file create failed.");
        }

        String[] args = {sourceFile.getAbsolutePath()};
        ExampleMain.main(args);
    }

}