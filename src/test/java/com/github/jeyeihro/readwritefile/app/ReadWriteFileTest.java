package com.github.jeyeihro.readwritefile.app;

import com.github.jeyeihro.readwritefile.args.Arguments;
import com.github.jeyeihro.readwritefile.content.ContentsCreator;
import com.github.jeyeihro.readwritefile.content.DefaultContentsCreator;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.exception.SourceFileNotFoundException;
import com.github.jeyeihro.readwritefile.rule.DefaultRule;
import com.github.jeyeihro.readwritefile.rule.Rules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteFileTest {
    @Test
    void constructor_1(){
        String[] args = {"expected"};
        Arguments arguments = new Arguments(args);
        ReadWriteFile r = new ReadWriteFile(args);
        assertEquals(arguments.toValue(), r.arguments().toValue());
    }

    @Test
    void constructor_2(){
        String[] args = {"expected"};
        Arguments arguments = new Arguments(args);
        ContentsCreator contentsCreator = new DefaultContentsCreator();
        ReadWriteFile r = new ReadWriteFile(args, contentsCreator);
        assertEquals(arguments.toValue(), r.arguments().toValue());
        assertEquals(DefaultContentsCreator.class, r.contentsCreator().getClass());
    }

    @Test
    void constructor_3(){
        String[] args = {"expected"};
        Arguments arguments = new Arguments(args);
        Rules rules = new Rules();
        ReadWriteFile r = new ReadWriteFile(args, rules);
        assertEquals(arguments.toValue(), r.arguments().toValue());
        assertEquals(0, r.rules().count());
    }

    @Test
    void constructor_4(){
        String[] args = {"expected"};
        Arguments arguments = new Arguments(args);
        Rules rules = new Rules();
        rules.add(new DefaultRule());
        ContentsCreator contentsCreator = new DefaultContentsCreator();
        ReadWriteFile r = new ReadWriteFile(args, contentsCreator, rules);
        assertEquals(arguments.toValue(), r.arguments().toValue());
        assertEquals(DefaultContentsCreator.class, r.contentsCreator().getClass());
        assertEquals(1, r.rules().count());
    }

    @Test
    void targetFileTest(){
        String[] args = {"expected"};
        ReadWriteFile r = new ReadWriteFile(args);
        assertFalse(r.targetFile().flushable());
    }

    @Test
    void targetFilesTest(){
        String[] args = {"expected"};
        ReadWriteFile r = new ReadWriteFile(args);
        assertFalse(r.targetFiles().flushable());
    }

    @Test
    void executeTest_1(@TempDir Path tempDir) throws ReadWriteFileException {
        File sourceFile = tempDir.resolve("sourceFile.txt").toFile();
        try(FileOutputStream fos = new FileOutputStream(sourceFile)){
            fos.write("aaa\nbbb\nccc\nddd".getBytes(StandardCharsets.UTF_8));
            fos.flush();
        } catch (IOException e) {
            fail("source-file create failed.");
        }

        String[] args = {sourceFile.getAbsolutePath()};
        ReadWriteFile r = new ReadWriteFile(args);
        r.execute();
        Path targetFile = tempDir.resolve("sourceFile.txt_copied");
        assertTrue(targetFile.toFile().exists());
        try{
            String targetFileContents = Files.readString(targetFile);
            assertEquals("aaa\nbbb\nccc\nddd", targetFileContents);
        }catch(IOException e){
            fail("target-file read failed");
        }
    }

    @Test
    void executeTest_2(){
        String[] args = {""};
        ReadWriteFile r = new ReadWriteFile(args);
        assertThrows(SourceFileNotFoundException.class, r::execute);
    }
}