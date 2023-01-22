package com.example.uskt_insider;

public class SendRequestClass {
    String title;
    String request;

    public SendRequestClass(String title, String request) {
        this.title = title;
        this.request = request;
    }

    public String getTitle() {
        return title;
    }

    public String getRequest() {
        return request;
    }
}
