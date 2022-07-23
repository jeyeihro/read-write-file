package com.github.jeyeihro.readwritefile.content;

import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.SourceFile;

public interface ContentsCreator {
    Contents create(SourceFile sourceFile) throws ReadWriteFileException;
}
