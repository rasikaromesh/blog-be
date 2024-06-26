package com.rrd.blog_be.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

public class Post {
    @Id
    private UUID id;
    private String title;
    private List<ContentBlock> content;

    public Post() {
        this.id = UUID.randomUUID();
    }

    public Post(UUID id, String title, List<ContentBlock> content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}
