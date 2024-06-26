package com.rrd.blog_be.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListBlock extends ContentBlock {

    @JsonProperty
    private List<String> items;

    @JsonCreator
    public ListBlock(List<String> items) {
        super("list");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ListBlock{" +
                "items=" + items +
                '}';
    }
}
