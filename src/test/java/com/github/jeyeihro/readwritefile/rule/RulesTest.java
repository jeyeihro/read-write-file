package com.github.jeyeihro.readwritefile.rule;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.Elements;
import com.github.jeyeihro.readwritefile.io.SourceFile;
import com.github.jeyeihro.readwritefile.io.TargetFile;
import com.github.jeyeihro.readwritefile.io.TargetFiles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RulesTest {
    @Test
    void initTest_1(){
        Contents contents = new Contents("file contents");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();
        Elements elements = new Elements(null, null, contents, targetFile, targetFiles);

        Rules rules = new Rules();
        rules.init(elements);
    }

    @Test
    void initTest_2(){
        Contents contents = new Contents("file contents");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();
        Elements elements = new Elements(null, null, contents, targetFile, targetFiles);

        Rules rules = new Rules();
        rules.add(new DefaultRule());
        rules.init(elements);
    }

    @Test
    void applyTest(@TempDir Path tempDir) throws ReadWriteFileException {
        Path path = tempDir.resolve("sourceFile.txt");
        SourceFile sourceFile = new SourceFile(path);
        Contents contents = new Contents("file contents");
        TargetFile targetFile = new TargetFile();
        TargetFiles targetFiles = new TargetFiles();
        Elements elements = new Elements(null, sourceFile, contents, targetFile, targetFiles);

        Rules rules = new Rules();
        rules.init(elements);
        rules.apply();

        assertEquals("sourceFile.txt_copied", elements.targetFile().toFile().getName());
    }
}