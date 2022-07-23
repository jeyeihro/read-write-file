package com.github.jeyeihro.readwritefile.example;

@SuppressWarnings("SpellCheckingInspection")
public class ReadMe {
    public static final String README = """
            ************************************************
            *** This may be tedious,                     ***
            *** but please read through the following.   ***
            *** Thank you.                               ***
            ************************************************
            
            This library contains examples.
             - outputs single file.
               -> com.github.jeyeihro.readwritefile.example.singleTarget.ExampleMain
             - outputs multiple files.
               -> com.github.jeyeihro.readwritefile.example.multipleTarget.ExampleMain
            
            For execute one, edit the `build.gradle.kts` as following:
            
            outputs single file:
                        
            application {
                mainClass.set("com.github.jeyeihro.readwritefile.example.singleTarget.ExampleMain")
            }
            
            outputs multiple files:
            
            application {
                mainClass.set("com.github.jeyeihro.readwritefile.example.multipleTarget.ExampleMain")
            }
            
            
            At least one execution argument is required to make this program work.
            The execution argument must be a file path.
                        
            e.g.
            gradle run --args="/aaa/bbb/ccc/ddd"
            gradle run --args="C:\\aaa\\bbb\\ccc\\ddd.txt"
            
            - outputs single file
            This copies the source file with a suffix `_copied`.
            
            - outputs multiple files
            This converts the contents of file as execution argument
            to a single-quotation-separated CSV strings.
            And if source files contains over 21 lines,
            target files are divided into 20 lines each.
            
            Examples as follows:
                        
            e.g.
            contents of /aaa/bbb/ccc/ddd:
            --------------------
            This[LF]
            is[LF]
            Contents[EOF]
            --------------------
                        
            `gradle run --args="/aaa/bbb/ccc/ddd"`
            creates
            /aaa/bbb/ccc/ddd_converted.
                        
            contents of /aaa/bbb/ccc/ddd_converted
            --------------------
            'This','is','Contents'[EOF]
            --------------------
            
            """;

    public static void main(String[] args) {
        System.out.println(README);
    }
}
