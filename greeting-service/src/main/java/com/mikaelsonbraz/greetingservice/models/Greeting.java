package com.mikaelsonbraz.greetingservice.models;

public class Greeting {

    private final long greetingId;
    private final String content;

    public Greeting(long greetingId, String content) {
        this.greetingId = greetingId;
        this.content = content;
    }

    public long getGreetingId() {
        return greetingId;
    }

    public String getContent() {
        return content;
    }
}
