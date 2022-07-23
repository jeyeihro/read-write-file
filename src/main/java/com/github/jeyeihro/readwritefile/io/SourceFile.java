package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.exception.SourceFileOperationException;

import java.io.File;
import java.nio.file.Path;

public class SourceFile {
    private final Path path;
    private final File file;
    public SourceFile(Path path) throws SourceFileOperationException {
        this.path = path;
        try{
            this.file = path.toFile();
        }catch(UnsupportedOperationException e){
            throw new SourceFileOperationException(e);
        }
    }

    public Path toPath(){
        return this.path;
    }

    public File toFile(){
        return this.file;
    }
    public boolean exists(){
        return file.exists();
    }
}
