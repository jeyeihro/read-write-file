package com.github.jeyeihro.readwritefile.content;

import com.github.jeyeihro.readwritefile.exception.ContentsCreateException;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.SourceFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultContentsCreatorTest {
    @Test
    void createTest() throws ReadWriteFileException, IOException {
        URL url = DefaultContentsCreatorTest.class.getClassLoader().getResource(DefaultContentsCreatorTest.class.getSimpleName());
        File file = new File(Objects.requireNonNull(url).getPath());
        String expected = Files.readString(file.toPath());
        SourceFile sourceFile = new SourceFile(file.toPath());
        ContentsCreator contentsCreator = new DefaultContentsCreator();
        Contents contents = contentsCreator.create(sourceFile);
        assertEquals(expected, contents.toString());
    }

    @Test
    void raiseException() throws ReadWriteFileException {
        SourceFile sourceFile = new SourceFile(Paths.get(""));
        ContentsCreator contentsCreator = new DefaultContentsCreator();
        assertThrows(ContentsCreateException.class, () -> contentsCreator.create(sourceFile));
    }
}