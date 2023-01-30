package com.company.chatterbook.models;

import com.company.chatterbook.ChatterbookApplication;

public class ChatterPost {

    private String text;



    public ChatterPost(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
