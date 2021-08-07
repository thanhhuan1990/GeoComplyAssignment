package com.geocomply.android.assignment.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLHandshakeException;

public class Link {
    private String url;
    public String getUrl() {
        return url;
    }
    private String title;
    public String getTitle() {
        return title;
    }

    public Link(String url) {
        this.url = url;
        this.title = getUrlTitle(url);
    }

    public static boolean isValidUrl(String url) {

        final String URL_REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static String getUrlTitle(String url) {
        try {
            InputStream response = new URL(url).openStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            return responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));
        } catch (StringIndexOutOfBoundsException oobException) {
            oobException.printStackTrace();
            return null;
        } catch (SSLHandshakeException sslException) {
            sslException.printStackTrace();
            return null;
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
            return null;
        } catch (IllegalArgumentException exIO) {
            exIO.printStackTrace();
            return null;
        } catch (IOException exIO) {
            exIO.printStackTrace();
            return null;
        }
    }
}
