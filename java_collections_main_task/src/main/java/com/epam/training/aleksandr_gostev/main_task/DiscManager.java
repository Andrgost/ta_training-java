package com.epam.training.aleksandr_gostev.main_task;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DiscManager {

    public CompactDisc burnTracksToDisc() {

        CompactDisc compactDisk = new CompactDisc();

        compactDisk.getTrackList().add(new MusicTrack("Abc", "Rock", 180));
        compactDisk.getTrackList().add(new MusicTrack("Bcc", "Pop", 210));
        compactDisk.getTrackList().add(new MusicTrack("Cdf", "Funk", 150));
        compactDisk.getTrackList().add(new MusicTrack("Ght", "Rock", 240));
        compactDisk.getTrackList().add(new MusicTrack("Djk", "Pop", 210));

        System.out.println("Disc has been burned!");

        return compactDisk;
    }

    public int countCommonTime(CompactDisc compactDisc) {
        AtomicInteger commonTime = new AtomicInteger(0);

        compactDisc.getTrackList().stream()
                .mapToInt(MusicTrack::getTrackTime)
                .forEach(commonTime::getAndAdd);

        return commonTime.get();
    }

    public void sortTracksByStyle(CompactDisc compactDisc) {
        List<MusicTrack> sortedByStyle = compactDisc.getTrackList().stream().
                sorted(Comparator.comparing(MusicTrack::getTrackStyle)).
                collect(Collectors.toList());
        System.out.println("Tracks sorted by style:");
        System.out.println(sortedByStyle);
    }

    public MusicTrack findTrackByTimeRange(CompactDisc compactDisc, int minLength, int maxLength) {
        MusicTrack musicTrack = compactDisc.getTrackList().stream()
                .filter(track -> track.getTrackTime() > minLength && track.getTrackTime() < maxLength)
                .findFirst().orElse(new MusicTrack());
        return musicTrack;
    }
}
