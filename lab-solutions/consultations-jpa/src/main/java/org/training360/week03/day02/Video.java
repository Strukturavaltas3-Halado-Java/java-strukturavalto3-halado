package org.training360.week03.day02;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int length;

    @ManyToOne
    private YoutubeUser user;

    public Video() {
    }

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Video(String title, int length, YoutubeUser user) {
        this.title = title;
        this.length = length;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YoutubeUser getUser() {
        return user;
    }

    public void setUser(YoutubeUser user) {
        this.user = user;
    }
}
