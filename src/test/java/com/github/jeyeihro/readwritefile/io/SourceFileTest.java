package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.exception.SourceFileOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SourceFileTest {
    @Mock
    private Path path;

    @Test
    void init(){
        Mockito.when(this.path.toFile()).thenThrow(new UnsupportedOperationException());
        assertThrows(SourceFileOperationException.class, () -> new SourceFile(path));
    }

    @Test
    void toFileTest() throws SourceFileOperationException {
        SourceFile sourceFile = new SourceFile(Paths.get("File Path"));
        assertEquals("File Path", sourceFile.toFile().getName());
    }

    @Test
    void existsTest() throws SourceFileOperationException {
        SourceFile sourceFile = new SourceFile(Paths.get("File Path"));
        assertFalse(sourceFile.exists());
    }
}