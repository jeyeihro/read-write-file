package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.args.Arguments;
import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;

import java.io.File;

public record Elements(Arguments arguments, SourceFile sourceFile, Contents contents, TargetFile targetFile,
                       TargetFiles targetFiles) {

    public void setTarget(File file, Contents contents) {
        targetFile.set(file, contents);
    }

    public void addTarget(File file, Contents contents) {
        targetFiles.add(file, contents);
    }

    public void flushTarget() throws ReadWriteFileException {
        if (targetFile.flushable()) {
            targetFile.flush();
        }
        if (targetFiles.flushable()) {
            targetFiles.flush();
        }
    }
}
