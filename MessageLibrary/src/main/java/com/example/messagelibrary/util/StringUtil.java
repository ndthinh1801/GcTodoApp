package com.example.messagelibrary.util;

import androidx.annotation.WorkerThread;
import androidx.core.util.PatternsCompat;

import com.example.messagelibrary.model.MessageModel;
import com.example.messagelibrary.model.UrlContent;
import com.google.gson.GsonBuilder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class StringUtil {

    public static boolean isValidUrl(String url) {
        return PatternsCompat.WEB_URL.matcher(url).matches();
    }

    public static boolean isMentionedUser(String text) {
        return text.matches("^@.+");
    }

    public static String getMentionedUser(String text) {
        return text.replaceAll("\\W", "");
    }

    //This method must be run in background because we are network request to get title of page
    @WorkerThread
    public static String getUrlTitle(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return document.title();
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * This method must be run in background because we are network request to get title of page
     * <p>
     * Getting the mentioned user or link in the given message
     *
     * @param message
     * @return pretty json
     */
    @WorkerThread
    public static String splitMessageToJson(String message) {
        MessageModel model = new MessageModel();
        String[] arrays = message.split("[\\n\\s]");
        if (arrays.length == 0) {
            return "";
        }
        for (String text : arrays) {
            if (isMentionedUser(text)) {
                model.addMention(getMentionedUser(text));
            } else if (isValidUrl(text)) {
                UrlContent urlContent = new UrlContent();
                urlContent.setTitle(getUrlTitle(text));
                urlContent.setUrl(text);
                model.addLink(urlContent);
            }
        }
        if (model.hasData()) {
            return new GsonBuilder().setPrettyPrinting().create().toJson(model);
        } else {
            return "";
        }
    }
}
