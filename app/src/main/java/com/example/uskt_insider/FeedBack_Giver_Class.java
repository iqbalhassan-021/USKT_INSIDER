package com.example.uskt_insider;

public class FeedBack_Giver_Class {


    String giverName;
    String theFeedback;
    public FeedBack_Giver_Class(String giverName, String theFeedback) {
        this.giverName = giverName;
        this.theFeedback = theFeedback;
    }

    public String getGiverName() {
        return giverName;
    }

    public String getTheFeedback() {
        return theFeedback;
    }
}
