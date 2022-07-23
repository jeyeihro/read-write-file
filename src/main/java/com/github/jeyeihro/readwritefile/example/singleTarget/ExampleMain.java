package com.github.jeyeihro.readwritefile.example.singleTarget;

import com.github.jeyeihro.readwritefile.app.ReadWriteFile;
import com.github.jeyeihro.readwritefile.codes.ExitCode;
import com.github.jeyeihro.readwritefile.example.ReadMe;
import com.github.jeyeihro.readwritefile.exception.*;

import java.io.File;


public class ExampleMain {
    public static void done(){
        System.exit(ExitCode.Done.id());
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void abend(ReadWriteFileException e, ExitCode exitCode){
        e.printStackTrace();
        System.exit(exitCode.id());
    }

    public static void main(String[] args) {
        if(args == null || args.length == 0 || !new File(args[0]).exists()){
            System.out.println(ReadMe.README);
            done();
        }
        try {
            ReadWriteFile readWriteFile = new ReadWriteFile(args);
            readWriteFile.execute();
        }catch(ReadWriteFileException e){
            abend(e, ExitCode.ErrorUnexpected);
        }
        done();
    }
}
