package com.rrd.blog_be.dto;

import com.rrd.blog_be.model.ContentBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PostDto {
    private static final Logger logger = LoggerFactory.getLogger(PostDto.class);
    private String title;
    private List<ContentBlock> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ContentBlock> getContent() {
        return content;
    }

    public void setContent(List<ContentBlock> content) {
        logger.info("Setting content: {}", content);
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
