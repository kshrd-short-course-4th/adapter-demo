package com.example.rathana.adapterdemo.entity;

/**
 * Created by RATHANA on 1/7/2018.
 */

public class Song {

    private int image;
    private String title;
    private String author;
    private boolean isPlaying;

    public Song(String title, String author, boolean isPlaying) {
        this.title = title;
        this.author = author;
        this.isPlaying = isPlaying;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
