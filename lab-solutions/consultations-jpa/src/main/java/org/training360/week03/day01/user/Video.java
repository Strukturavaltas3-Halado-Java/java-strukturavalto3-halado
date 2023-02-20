package org.training360.week03.day01.user;

import javax.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
public class Video {

    private String title;

    private LocalTime length;

    public Video() {
    }

    public Video(String title, LocalTime length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getLength() {
        return length;
    }

    public void setLength(LocalTime length) {
        this.length = length;
    }
}
