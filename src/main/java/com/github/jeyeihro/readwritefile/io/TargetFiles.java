package com.github.jeyeihro.readwritefile.io;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TargetFiles {
    private final List<TargetFile> targetFileList;
    public TargetFiles(){
        targetFileList = new ArrayList<>();
    }

    public boolean flushable() {
        if(targetFileList.size() == 0){
            return false;
        }
        return targetFileList.stream().allMatch(TargetFile::flushable);
    }

    public void flush() throws ReadWriteFileException{
        for(TargetFile t : targetFileList){
            t.flush();
        }
    }

    public void add(File file, Contents contents){
        TargetFile t = new TargetFile();
        t.set(file, contents);
        targetFileList.add(t);
    }

    public List<TargetFile> toList(){
        return this.targetFileList;
    }

}
