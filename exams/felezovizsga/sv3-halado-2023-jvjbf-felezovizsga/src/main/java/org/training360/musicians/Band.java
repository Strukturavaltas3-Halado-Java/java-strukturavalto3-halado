package org.training360.musicians;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bands")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "band_name")
    private String bandName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ElementCollection
    @JoinTable(name = "discographies")
    private List<Album> discography = new ArrayList<>();

    @OneToMany(mappedBy = "band", cascade = CascadeType.PERSIST)
    private Set<Musician> musicians = new HashSet<>();

    public Band() {
    }

    public Band(String bandName, Genre genre) {
        this.bandName = bandName;
        this.genre = genre;
    }

    public void addMusician(Musician musician) {
        musicians.add(musician);
        musician.setBand(this);
    }

    public void addAlbum(Album album) {
        discography.add(album);
    }

    public Long getId() {
        return id;
    }

    public String getBandName() {
        return bandName;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Album> getDiscography() {
        return discography;
    }

    public Set<Musician> getMusicians() {
        return musicians;
    }
}
