package com.github.jeyeihro.readwritefile.example.multipleTarget;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.content.ContentsCreator;
import com.github.jeyeihro.readwritefile.exception.ContentsCreateException;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.SourceFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class ExampleContentsCreator implements ContentsCreator {

    @Override
    public Contents create(SourceFile sourceFile) throws ReadWriteFileException {
        final Contents contents;
        try{
            String s = Files.readString(sourceFile.toPath());
            //noinspection CharsetObjectCanBeUsed
            contents = new Contents(s, Charset.forName("UTF-8"));
        }catch(IOException e){
            throw new ContentsCreateException(e);
        }
        return contents;
    }
}
