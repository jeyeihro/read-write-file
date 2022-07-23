package com.github.jeyeihro.readwritefile.example.multipleTarget;

import com.github.jeyeihro.readwritefile.content.Contents;
import com.github.jeyeihro.readwritefile.io.Elements;
import com.github.jeyeihro.readwritefile.rule.Rule;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleTargetFileRule implements Rule {
    private static final String FILE_NAME_INSCRIBED = "_converted";

    private static final int SPLIT_ROWS = 20;

    private String rename(String fileName, String number){
        Pattern pattern = Pattern.compile("(^.*)(\\..*$)");
        Matcher matcher = pattern.matcher(fileName);
        if(matcher.find()){
            return matcher.group(1) + FILE_NAME_INSCRIBED + number + matcher.group(2);
        }else{
            return fileName + FILE_NAME_INSCRIBED + number;
        }
    }

    private String findLineSeparator(Contents contents){
        if(Objects.requireNonNull(contents).toString().contains("\r\n")){
            return "\r\n";
        }
        return "\n";
    }
    private Contents convertContents(Contents contents) {
        String contentsValue = contents.toString();
        contentsValue = contentsValue.replaceAll(findLineSeparator(contents), "','");
        for (String s : Arrays.asList("^", "$")) {
            contentsValue = contentsValue.replaceAll(s, "'");
        }
        return new Contents(contentsValue, contents.getCharset());
    }

    private List<String> splitStringWithRows(Contents contents){
        List<String> ret = new ArrayList<>();
        String lineSeparator = findLineSeparator(contents);
        Pattern pattern = Pattern.compile(lineSeparator);
        List<String> list = Arrays.asList(pattern.split(contents.toString()));

        int start = 0;
        int end = list.size() > 20?ExampleTargetFileRule.SPLIT_ROWS: list.size();

        do {
            List<String> part = list.subList(start, end);
            String str = String.join(lineSeparator, part);
            ret.add(str);
            start += ExampleTargetFileRule.SPLIT_ROWS;
            end += ExampleTargetFileRule.SPLIT_ROWS;
            if (end > list.size()) {
                end = list.size();
            }
        } while (start <= list.size());

        return ret;
    }

    @Override
    public void convert(Elements elements) {
        // create target file impl
        File source = elements.sourceFile().toFile();

        // split source file by specified number of lines
        List<String> splitString = splitStringWithRows(elements.contents());

        // generate target files for each split
        int count = 1;
        for(String s: splitString){
            Contents convertedContents = convertContents(new Contents(s));
            String targetFilePath = source.getParent() + File.separator;
            String targetFileName = rename(source.getName(), String.format("%02d", count));
            File targetFileImpl = new File(targetFilePath + targetFileName);
            elements.addTarget(targetFileImpl, convertedContents);
            count++;
        }
    }
}
