package com.github.jeyeihro.readwritefile.rule;

import com.github.jeyeihro.readwritefile.exception.ReadWriteFileException;
import com.github.jeyeihro.readwritefile.io.Elements;

import java.util.ArrayList;
import java.util.List;

public class Rules {
    private final List<Rule> rules;
    private Elements elements;
    public Rules(){
        rules = new ArrayList<>();
    }

    public void add(Rule rule){
        rules.add(rule);
    }

    public int count(){
        return this.rules.size();
    }

    public void init(Elements elements){
        if(count() == 0){
            Rule defaultRule = new DefaultRule();
            add(defaultRule);
        }
        this.elements = elements;
    }

    public void apply() throws ReadWriteFileException {
        for(Rule r: rules){
            r.convert(elements);
        }
    }
}
