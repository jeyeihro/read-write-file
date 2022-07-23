package com.github.jeyeihro.readwritefile.app;

import com.github.jeyeihro.readwritefile.args.Arguments;
import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.content.ContentsCreator;
import com.github.jeyeihro.readwritefile.content.DefaultContentsCreator;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.exception.SourceFileNotFoundException;
import com.github.jeyeihro.readwritefile.io.*;
import com.github.jeyeihro.readwritefile.rule.Rules;

public class ReadWriteFile {
    private final Arguments args;
    private final ContentsCreator contentsCreator;
    private final Rules rules;
    private final TargetFile targetFile = new TargetFile();
    private final TargetFiles targetFiles = new TargetFiles();

    public ReadWriteFile(String[] args){
        this(args, new DefaultContentsCreator(), new Rules());
    }
    public ReadWriteFile(String[] args, ContentsCreator contentsCreator){
        this(args, contentsCreator, new Rules());
    }
    public ReadWriteFile(String[] args, Rules rules){
        this(args, new DefaultContentsCreator(), rules);
    }
    public ReadWriteFile(String[] args, ContentsCreator contentsCreator, Rules rules){
        this.args = new Arguments(args);
        this.contentsCreator = contentsCreator;
        this.rules = rules;
    }

    public void execute() throws ReadWriteFileException {
        SourceFile sourceFile = new SourceFile(args.firstToPath());
        if(!sourceFile.exists()){
            throw new SourceFileNotFoundException("SourceFile not found.");
        }
        Contents contents = contentsCreator.create(sourceFile);
        Elements elements = new Elements(args, sourceFile, contents, targetFile, targetFiles);
        rules.init(elements);
        rules.apply();
        elements.flushTarget();
    }

    public Arguments arguments(){
        return this.args;
    }

    public ContentsCreator contentsCreator(){
        return this.contentsCreator;
    }

    public Rules rules(){
        return this.rules;
    }

    public TargetFile targetFile(){
        return this.targetFile;
    }

    public TargetFiles targetFiles(){
        return this.targetFiles;
    }
}
