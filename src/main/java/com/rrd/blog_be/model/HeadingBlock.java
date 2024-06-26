package com.rrd.blog_be.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeadingBlock extends ContentBlock {
    @JsonProperty
    private int level;
    @JsonProperty
    private String text;

    public HeadingBlock(int level, String text) {
        super("heading");
        this.level = level;
        this.text = text;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "HeadingBlock{" +
                "level=" + level +
                ", text='" + text + '\'' +
                '}';
    }
}
