package com.languageservice.itis6177.models;

public class Match {

    String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public double getConfidentScore() {
        return confidentScore;
    }
    public void setConfidentScore(double confidentScore) {
        this.confidentScore = confidentScore;
    }
    double confidentScore;
    public Match(String text, double confidentScore) {
        this.text = text;
        this.confidentScore = confidentScore;
    }

    
    
}
