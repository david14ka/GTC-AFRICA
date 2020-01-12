package com.dkz.gtcafrica.model;

import java.util.Date;

public class LogEvent {

    private String key;
    private String event;
    private String jsonData;
    private String dateCreated;
    private String client;

    public LogEvent(String event, String jsonData) {
        this.key = String.valueOf(System.currentTimeMillis());
        this.event = event;
        this.jsonData = jsonData;
        this.dateCreated = new Date().toString();
        this.client = "Android";

    }
}
