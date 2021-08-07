package com.geocomply.android.assignment.model;

import org.junit.Test;

public class LinkTest {

    @Test
    public void verifyValidUrl() {
        // Verify Valid url with page title
        final Link link = new Link("https://olympics.com/tokyo-2020/en/");
        org.junit.Assert.assertEquals("https://olympics.com/tokyo-2020/en/", link.getUrl());
        org.junit.Assert.assertEquals("Tokyo 2020 Olympic Games", link.getTitle());

        // Verify Valid url without page title
        final Link validUrl = new Link("http://www.huan.geocomply.com");
        org.junit.Assert.assertEquals("http://www.huan.geocomply.com", validUrl.getUrl());
        org.junit.Assert.assertNull(validUrl.getTitle());
    }

    @Test
    public void verifyInvalidUrl() {
        // Verify invalid url
        final Link invalidUrl = new Link("abc");
        org.junit.Assert.assertEquals("abc", invalidUrl.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());

        // Verify invalid url
        final Link invalidUrl2 = new Link("http://");
        org.junit.Assert.assertEquals("http://", invalidUrl2.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());

        // Verify invalid url
        final Link invalidUrl3 = new Link("http://.com");
        org.junit.Assert.assertEquals("http://.com", invalidUrl3.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());

        // Verify invalid url
        final Link invalidUrl4 = new Link("http:");
        org.junit.Assert.assertEquals("http:", invalidUrl4.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());

        // Verify invalid url
        final Link invalidUrl5 = new Link("http://vnexpress.net");
        org.junit.Assert.assertEquals("http://vnexpress.net", invalidUrl5.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());

        // Verify invalid url
        final Link invalidUrl6 = new Link("http://googl.com");
        org.junit.Assert.assertEquals("http://googl.com", invalidUrl6.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());

        // Verify invalid url
        final Link invalidUrl7 = new Link("https://googl.com");
        org.junit.Assert.assertEquals("https://googl.com", invalidUrl7.getUrl());
        org.junit.Assert.assertNull(invalidUrl.getTitle());
    }
}
