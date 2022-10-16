package com.example.messagelibrary;

import com.example.messagelibrary.util.StringUtil;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testSplitMessage_includeMention_success() {
        String message = "@billgates do you know where is @elonmusk?";
        String expectedResult = "{\n" +
                "  \"mentions\": [\n" +
                "    \"billgates\",\n" +
                "    \"elonmusk\"\n" +
                "  ]\n" +
                "}";
        String actualResult = StringUtil.splitMessageToJson(message);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSplitMessage_noMention() {
        String message = "billgates do you know where is elonmusk?";
        String actualResult = StringUtil.splitMessageToJson(message);
        Assert.assertEquals("", actualResult);
    }

    @Test
    public void testSplitMessage_includeLink_success() {
        String message = "Olympics 2020 is happening; https://olympics.com/tokyo-2020/en/";
        String expectedResult = "{\n" +
                "  \"links\": [\n" +
                "    {\n" +
                "      \"url\": \"https://olympics.com/tokyo-2020/en/\",\n" +
                "      \"title\": \"Tokyo 2020 Summer Olympics - Athletes, Medals \\u0026 Results\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String actualResult = StringUtil.splitMessageToJson(message);
        Assert.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testSplitMessage_includeInvalidURL() {
        String message = "Olympics 2020 is happening; https://olympics";
        String actualResult = StringUtil.splitMessageToJson(message);
        Assert.assertEquals("", actualResult);
    }

    @Test
    public void testSplitMessage_includeMentionAndLink_success() {
        String message = "@billgates do you know where is @elonmusk? " +
                "He is at Tokyo 2020 Summer Olympics, https://olympics.com/tokyo-2020/en/";
        String expectedResult = "{\n" +
                "  \"mentions\": [\n" +
                "    \"billgates\",\n" +
                "    \"elonmusk\"\n" +
                "  ],\n" +
                "  \"links\": [\n" +
                "    {\n" +
                "      \"url\": \"https://olympics.com/tokyo-2020/en/\",\n" +
                "      \"title\": \"Tokyo 2020 Summer Olympics - Athletes, Medals \\u0026 Results\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String actualResult = StringUtil.splitMessageToJson(message);
        Assert.assertEquals(expectedResult, actualResult);
    }
}


