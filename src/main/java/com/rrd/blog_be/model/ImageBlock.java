package com.rrd.blog_be.model;

public class ImageBlock extends ContentBlock {
    private String src;
    private String alt;

    public ImageBlock(String src, String alt) {
        super("image");
        this.src = src;
        this.alt = alt;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public String toString() {
        return "ImageBlock{" +
                "src='" + src + '\'' +
                ", alt='" + alt + '\'' +
                '}';
    }
}
