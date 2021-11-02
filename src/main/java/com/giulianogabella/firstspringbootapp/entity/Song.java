package com.giulianogabella.firstspringbootapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int artistId;

    @Column
    private int albumId;

    @Column
    private String name;

    public Song() {

    }

    public Song(int albumId, String name) {
        this.albumId = albumId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", albumId=" + albumId +
                ", name='" + name + '\'' +
                '}';
    }
}
