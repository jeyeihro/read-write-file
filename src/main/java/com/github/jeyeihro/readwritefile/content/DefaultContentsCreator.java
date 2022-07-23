package com.github.jeyeihro.readwritefile.content;

import com.github.jeyeihro.readwritefile.exception.ContentsCreateException;
import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.SourceFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class DefaultContentsCreator implements ContentsCreator {

    @Override
    public Contents create(SourceFile sourceFile) throws ReadWriteFileException {
        final Contents contents;
        try{
            byte[] b = Files.readAllBytes(sourceFile.toPath());
            contents = new Contents(b, StandardCharsets.UTF_8);
        }catch(IOException e){
            throw new ContentsCreateException(e);
        }
        return contents;
    }
}
