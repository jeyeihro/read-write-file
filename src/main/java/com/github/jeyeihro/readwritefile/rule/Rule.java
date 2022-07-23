package com.github.jeyeihro.readwritefile.rule;

import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.Elements;

public interface Rule {
    void convert(Elements elements) throws ReadWriteFileException;
}
