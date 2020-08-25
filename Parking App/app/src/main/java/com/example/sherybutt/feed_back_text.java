package com.example.sherybutt;

public class feed_back_text {
    String id_feed;
    String userfeed;

    public feed_back_text() {
    }

    public feed_back_text(String id_feed, String ufeed) {
        this.id_feed = id_feed;
        this.userfeed = ufeed;
    }

    public String getId_feed() {
        return id_feed;
    }

    public String getUfeed() {
        return userfeed;
    }
}
