package com.github.jeyeihro.readwritefile.rule;

import com.github.jeyeihro.readwritefile.io.Elements;

import java.io.File;

public class DefaultRule implements Rule{
    private static final String COPIED = "_copied";

    @Override
    public void convert(Elements elements) {
        File source = elements.sourceFile().toFile();
        File target = new File(source.getParent() + File.separator + source.getName() + COPIED);
        elements.setTarget(target, elements.contents());
    }
}
