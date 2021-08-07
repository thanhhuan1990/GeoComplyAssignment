package com.geocomply.android.assignment.model;

import com.google.gson.GsonBuilder;

import java.util.List;

public class Data {
    private List<String> mentions;
    public List<String> getMentions() {
        return mentions;
    }
    private List<Link> links;
    public List<Link> getLinks() {
        return links;
    }

    public Data(List<String> mentions, List<Link> links) {
        this.mentions = mentions;
        this.links = links;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
