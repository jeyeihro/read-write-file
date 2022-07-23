package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElementsTest {
    @Test
    void init(){
        Elements elements = new Elements(null, null, null, null, null);
        assertEquals(Elements.class, elements.getClass());
        assertNull(elements.arguments());
        assertNull(elements.sourceFile());
        assertNull(elements.contents());
        assertNull(elements.targetFile());
        assertNull(elements.targetFiles());
    }

    @Test
    void setTargetTest(){
        Contents contents = new Contents("file contents");
        TargetFile targetFile = new TargetFile();

        Elements elements = new Elements(null, null, contents, targetFile, null);
        File file = new File("file path");
        elements.setTarget(file, contents);
        assertEquals("file contents", elements.targetFile().toContents().toString());
        assertEquals("file path", elements.targetFile().toFile().getName());
    }

    @Test
    void addTargetTest(){
        Contents contents = new Contents("file contents");
        TargetFiles targetFiles = new TargetFiles();

        Elements elements = new Elements(null, null, contents, null, targetFiles);
        File file = new File("file path");
        elements.addTarget(file, contents);
        List<TargetFile> list = elements.targetFiles().toList();
        assertEquals(1, list.size());
        for(TargetFile tf: list){
            assertEquals("file contents", tf.toContents().toString());
            assertEquals("file path", tf.toFile().getName());
        }
    }

    @Test
    void flushTargetTest_1(@TempDir Path tempDir) throws ReadWriteFileException {
        Path targetPath = tempDir.resolve("target.txt");
        Contents contents = new Contents("file contents");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();

        Elements elements = new Elements(null, null, contents, targetFile, targetFiles);

        elements.setTarget(targetPath.toFile(), contents);
        elements.flushTarget();

        assertTrue(Files.exists(targetPath));
    }

    @Test
    void flushTargetTest_2_1(@TempDir Path tempDir) throws ReadWriteFileException {
        Path targetPath = tempDir.resolve("target.txt");
        Contents contents = new Contents("file contents");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();

        Elements elements = new Elements(null, null, contents, targetFile, targetFiles);

        elements.addTarget(targetPath.toFile(), contents);
        elements.flushTarget();

        assertTrue(Files.exists(targetPath));
    }

    @Test
    void flushTargetTest_2_2() throws ReadWriteFileException {
        Contents contents = new Contents("");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();

        Elements elements = new Elements(null, null, contents, targetFile, targetFiles);

        elements.addTarget(new File(""), contents);
        elements.flushTarget();
        assertTrue(true);
    }

    @Test
    void flushTargetTest_3(@TempDir Path tempDir) throws ReadWriteFileException {
        Path targetPath_1 = tempDir.resolve("target1.txt");
        Path targetPath_2 = tempDir.resolve("target2.txt");
        Contents contents_1 = new Contents("file contents1");
        Contents contents_2 = new Contents("file contents2");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();

        Elements elements = new Elements(null, null, null, targetFile, targetFiles);

        elements.setTarget(targetPath_1.toFile(), contents_1);
        elements.addTarget(targetPath_2.toFile(), contents_2);
        elements.flushTarget();

        assertTrue(Files.exists(targetPath_1));
        assertTrue(Files.exists(targetPath_2));
    }

    @Test
    void flushTargetTest_4() throws ReadWriteFileException {
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();

        Elements elements = new Elements(null, null, null, targetFile, targetFiles);
        elements.flushTarget();
        assertTrue(true);
    }
}