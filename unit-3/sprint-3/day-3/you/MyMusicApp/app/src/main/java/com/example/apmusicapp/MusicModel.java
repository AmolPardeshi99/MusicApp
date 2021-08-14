package com.example.apmusicapp;

public class MusicModel {

    private int Image;
    private String SongName;

    public MusicModel(int image, String songName) {
        Image = image;
        SongName = songName;
    }

    public int getImage() {
        return Image;
    }

    public String getSongName() {
        return SongName;
    }
}
