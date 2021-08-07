package com.geocomply.android.assignment.utils;

import com.geocomply.android.assignment.model.Data;

import org.junit.Test;

public class InputParserTest {

    @Test
    public void verifyFunctionGetDataWithFullData() {
        final Data data = new InputParser().getData("@billgates do you know where is @elonmusk and Olympics 2020 is happening; https://olympics" +
                ".com/tokyo-2020/en/ , https://google.com");

        org.junit.Assert.assertEquals("elonmusk", data.getMentions().get(1));
        org.junit.Assert.assertEquals("Google", data.getLinks().get(1).getTitle());
        org.junit.Assert.assertEquals("{\n" +
                "  \"mentions\": [\n" +
                "    \"billgates\",\n" +
                "    \"elonmusk\"\n" +
                "  ],\n" +
                "  \"links\": [\n" +
                "    {\n" +
                "      \"url\": \"https://olympics.com/tokyo-2020/en/\",\n" +
                "      \"title\": \"Tokyo 2020 Olympic Games\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"url\": \"https://google.com\",\n" +
                "      \"title\": \"Google\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", data.toString());
    }

    @Test
    public void verifyFunctionGetDataWithoutLink() {
        final Data data = new InputParser().getData("@Billgates do you know where is @elonmusk");

        org.junit.Assert.assertNull(data.getLinks());
        org.junit.Assert.assertEquals("elonmusk", data.getMentions().get(1));
        org.junit.Assert.assertEquals("{\n" +
                "  \"mentions\": [\n" +
                "    \"Billgates\",\n" +
                "    \"elonmusk\"\n" +
                "  ]\n" +
                "}", data.toString());
    }

    @Test
    public void verifyFunctionGetDataWithoutMention() {
        final Data data = new InputParser().getData("Olympics 2020 is happening; https://olympics" +
                ".com/tokyo-2020/en/ , https://google.com");

        org.junit.Assert.assertNull(data.getMentions());
        org.junit.Assert.assertEquals("https://olympics.com/tokyo-2020/en/", data.getLinks().get(0).getUrl());
        org.junit.Assert.assertEquals("Google", data.getLinks().get(1).getTitle());
        org.junit.Assert.assertEquals("{\n" +
                "  \"links\": [\n" +
                "    {\n" +
                "      \"url\": \"https://olympics.com/tokyo-2020/en/\",\n" +
                "      \"title\": \"Tokyo 2020 Olympic Games\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"url\": \"https://google.com\",\n" +
                "      \"title\": \"Google\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", data.toString());
    }

    @Test
    public void verifyFunctionGetDataWithoutData() {
        final Data data = new InputParser().getData("Do you know about Olympic Tokyo");

        org.junit.Assert.assertNull(data.getMentions());
        org.junit.Assert.assertNull(data.getLinks());
        org.junit.Assert.assertEquals("{}", data.toString());
    }

    @Test
    public void verifyFunctionGetDataWithoutInvalidData() {
        final Data data = new InputParser().getData("Do you know about Olympic Tokyo, mentioned in http://www.huan.geocomply.com");

        org.junit.Assert.assertNull(data.getMentions());
        org.junit.Assert.assertEquals("http://www.huan.geocomply.com", data.getLinks().get(0).getUrl());
        org.junit.Assert.assertEquals("{\n" +
                "  \"links\": [\n" +
                "    {\n" +
                "      \"url\": \"http://www.huan.geocomply.com\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", data.toString());
    }
}