package com.epam.training.aleksandr_gostev.main_task;

import java.util.ArrayList;

public class CompactDisc {

    private ArrayList<MusicTrack> trackList = new ArrayList<>();

    public ArrayList<MusicTrack> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<MusicTrack> trackList) {
        this.trackList = trackList;
    }
}
