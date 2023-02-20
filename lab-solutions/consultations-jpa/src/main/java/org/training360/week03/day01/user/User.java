package org.training360.week03.day01.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private LocalDate registrationDate;

    @ElementCollection
//    private List<String> videos = new ArrayList<>();
    private List<Video> videos = new ArrayList<>();

    public User() {

    }

    public User(String name, LocalDate registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
    }

//    public void addVideo(String video) {
    public void addVideo(Video video) {
        videos.add(video);
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

//    public List<String> getVideos() {
//        return videos;
//    }


    public List<Video> getVideos() {
        return videos;
    }
}
