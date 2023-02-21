package org.training360.week03.day02;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class YoutubeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private LocalDate registrationDate;

    @OneToMany(mappedBy = "user")
    private List<Video> videos = new ArrayList<>();


    public YoutubeUser() {

    }

    public YoutubeUser(String name, LocalDate registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public void addVideo(Video video) {
        videos.add(video);
        video.setUser(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }



    public List<Video> getVideos() {
        return videos;
    }
}
