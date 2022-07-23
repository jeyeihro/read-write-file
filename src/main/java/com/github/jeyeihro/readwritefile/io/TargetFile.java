package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.exception.ContentsEmptyException;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.exception.TargetFileFlushException;
import com.github.jeyeihro.readwritefile.exception.TargetFileInitializeException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TargetFile {
    private File file = null;
    private Contents contents = null;

    public boolean flushable(){
        if (file == null || contents == null) {
            return false;
        }
        return !contents.isEmpty();
    }
    public void flush() throws ReadWriteFileException {
        if(file == null){
            throw new TargetFileInitializeException("File not found. The set method(Elements.setTarget/Elements.addTarget) have not been called yet.Review your Rule settings.");
        }
        if(contents == null){
            throw new TargetFileInitializeException("Contents not found. The set method(Elements.setTarget/Elements.addTarget) have not been called yet.Review your Rule settings.");
        }
        if(contents.isEmpty()){
            throw new ContentsEmptyException("Contents is empty");
        }
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write(contents.toBytes());
            fos.flush();
        } catch (IOException e) {
            throw new TargetFileFlushException(e);
        }
    }

    public void setFile(File target) {
        this.file = target;
    }

    public void setContents(Contents contents){
        this.contents = contents;
    }

    public void set(File target, Contents contents){
        this.file = target;
        this.contents = contents;
    }

    public File toFile(){
        return this.file;
    }

    public Contents toContents(){
        return this.contents;
    }
}
