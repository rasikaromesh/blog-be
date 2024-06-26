package com.rrd.blog_be.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParagraphBlock extends ContentBlock {
    @JsonProperty
    private String text;

    @JsonCreator
    public ParagraphBlock(String text) {
        super("paragraph");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ParagraphBlock{" +
                "text='" + text + '\'' +
                '}';
    }
}
