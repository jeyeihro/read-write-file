package com.github.jeyeihro.readwritefile.example.multipleTarget;

import com.github.jeyeihro.readwritefile.app.ReadWriteFile;
import com.github.jeyeihro.readwritefile.codes.ExitCode;
import com.github.jeyeihro.readwritefile.example.ReadMe;
import com.github.jeyeihro.readwritefile.exception.*;
import com.github.jeyeihro.readwritefile.content.ContentsCreator;
import com.github.jeyeihro.readwritefile.rule.Rules;

import java.io.File;


public class ExampleMain {
    public static void exit(ReadWriteFileException e, ExitCode exitCode){
        e.printStackTrace();
        System.exit(exitCode.id());
    }

    public static void main(String[] args) {
        if(args == null || args.length == 0 || !new File(args[0]).exists()){
            System.out.println(ReadMe.README);
            System.exit(ExitCode.Done.id());
        }
        try {
            ContentsCreator contentsCreator = new ExampleContentsCreator();
            Rules rules = new Rules();
            rules.add(new ExampleTargetFileRule());
            ReadWriteFile readWriteFile = new ReadWriteFile(args, contentsCreator, rules);
            readWriteFile.execute();
        }catch(ArgumentsException e) {
            exit(e, ExitCode.ErrorArguments);
        }catch(SourceFileOperationException e) {
            exit(e, ExitCode.ErrorSourceFileOpe);
        }catch(SourceFileNotFoundException e) {
            exit(e, ExitCode.ErrorSourceFileNotFound);
        }catch(ContentsCreateException e){
            exit(e, ExitCode.ErrorContentsCreate);
        }catch (ContentsEmptyException e){
            exit(e, ExitCode.ErrorContentsEmpty);
        }catch (TargetFileFlushException e){
            exit(e, ExitCode.ErrorTargetFileFlush);
        }catch(TargetFileInitializeException e) {
            exit(e, ExitCode.ErrorTargetFileInitialize);
        }catch(ReadWriteFileException e){
            exit(e, ExitCode.ErrorUnexpected);
        }
        System.exit(ExitCode.Done.id());
    }
}
