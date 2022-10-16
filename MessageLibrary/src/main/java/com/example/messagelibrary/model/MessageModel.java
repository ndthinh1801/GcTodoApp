package com.example.messagelibrary.model;

import java.util.ArrayList;
import java.util.List;

public class MessageModel {
    private List<String> mentions;
    private List<UrlContent> links;

    public void addMention(String mention) {
        if (mentions == null) mentions = new ArrayList<>();
        mentions.add(mention);
    }

    public void addLink(UrlContent link) {
        if (links == null) links = new ArrayList<>();
        links.add(link);
    }

    public boolean hasData() {
        return links != null || mentions != null;
    }
}

