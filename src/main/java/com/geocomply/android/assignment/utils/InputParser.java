package com.geocomply.android.assignment.utils;

import com.geocomply.android.assignment.model.Data;
import com.geocomply.android.assignment.model.Link;

import java.util.ArrayList;

public class InputParser {

    public Data getData(String text) {
        ArrayList<String> mentionNames = new ArrayList<>();
        ArrayList<Link> links = new ArrayList<>();

        String[] input = text.split(" ");
        for (String str : input) {
            if (str.startsWith("@")) {
                mentionNames.add(str.substring(1));
            } else if (Link.isValidUrl(str)) {
                links.add(new Link(str));
            }
        }
        if (mentionNames.isEmpty()) {
            mentionNames = null;
        }
        if (links.isEmpty()) {
            links = null;
        }
        return new Data(mentionNames, links);
    }
}
