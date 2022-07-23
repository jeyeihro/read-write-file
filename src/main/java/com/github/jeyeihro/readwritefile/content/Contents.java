package com.github.jeyeihro.readwritefile.content;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Contents {
    private final Charset charset;
    private final String contentsString;
    private final byte[] contentsBytes;
    public Contents(String s){
        this(s, StandardCharsets.UTF_8);
    }
    public Contents(String s, Charset c){
        charset = c;
        contentsString = Objects.requireNonNull(s);
        contentsBytes = s.getBytes(c);
    }
    public Contents(byte[] b){
        this(b, StandardCharsets.UTF_8);
    }
    public Contents(byte[] b, Charset c){
        charset = c;
        contentsBytes = Objects.requireNonNull(b);
        contentsString = new String(b, c);
    }
    public String toString(){
        return this.contentsString;
    }
    public byte[] toBytes(){
        return this.contentsBytes;
    }
    public Charset getCharset(){
        return this.charset;
    }

    public boolean isEmpty(){
        return contentsString.isEmpty();
    }
}
