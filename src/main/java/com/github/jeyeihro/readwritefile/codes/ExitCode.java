package com.github.jeyeihro.readwritefile.codes;

public enum ExitCode {
    Done(0),
    ErrorArguments(1),
    ErrorSourceFileOpe(2),
    ErrorSourceFileNotFound(3),
    ErrorContentsCreate(4),
    ErrorContentsEmpty(5),
    ErrorTargetFileFlush(6),
    ErrorTargetFileInitialize(7),
    ErrorUnexpected(99);


    private final int id;

    ExitCode(int id){
        this.id = id;
    }

    public int id(){
        return this.id;
    }
}
