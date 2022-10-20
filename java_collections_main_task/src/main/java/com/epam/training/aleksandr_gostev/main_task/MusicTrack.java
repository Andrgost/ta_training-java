package com.epam.training.aleksandr_gostev.main_task;

public class MusicTrack {

    private String trackTitle;
    private String trackStyle;
    private int trackTime;

    public MusicTrack() {
    }

    public MusicTrack(String trackTitle, String trackStyle, int trackTime) {
        this.trackTitle = trackTitle;
        this.trackStyle = trackStyle;
        this.trackTime = trackTime;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getTrackStyle() {
        return trackStyle;
    }

    public void setTrackStyle(String trackStyle) {
        this.trackStyle = trackStyle;
    }

    public int getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(int trackTime) {
        this.trackTime = trackTime;
    }

    public String toString() {
        return "\nTitle = " + trackTitle +
                ", Style = " + trackStyle +
                ", Time = " + trackTime;
    }
}
