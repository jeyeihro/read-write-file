package com.github.jeyeihro.readwritefile.args;

import com.github.jeyeihro.readwritefile.exception.ArgumentsException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Arguments {
    private final String[] args;
    public Arguments(String[] args){
        if(args == null){
            args = new String[0];
        }
        this.args = args;
    }

    public int length(){
        return args.length;
    }

    public Path firstToPath() throws ArgumentsException {
        if(length() == 0){
            throw new ArgumentsException("Path is not allowed from zero-length args.");
        }

        return Paths.get(args[0]);
    }

    public String[] toValue(){
        return this.args;
    }
}
