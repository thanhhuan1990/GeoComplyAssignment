package com.geocomply.android.assignment.model;

import org.junit.Test;

import java.util.ArrayList;

public class DataTest {

    @Test
    public void verifyDataDefaultConstructor() {
        ArrayList<String> mentions = new ArrayList<String>() {
            {
                add("Billgates");
                add("elonmusk");
            }
        };
        ArrayList<Link> links = new ArrayList<Link>() {
            {
                add(new Link("https://olympics.com/tokyo-2020/en/"));
                add(new Link("https://google.com"));
            }
        };
        final Data data = new Data(mentions, links);

        org.junit.Assert.assertEquals(2, data.getMentions().size());
        org.junit.Assert.assertEquals("Billgates", data.getMentions().get(0));

        org.junit.Assert.assertEquals(2, data.getLinks().size());
        org.junit.Assert.assertEquals("Google", data.getLinks().get(1).getTitle());
    }
}
