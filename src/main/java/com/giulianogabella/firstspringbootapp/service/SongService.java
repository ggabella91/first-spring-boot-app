package com.giulianogabella.firstspringbootapp.service;

import com.giulianogabella.firstspringbootapp.entity.Song;

import java.util.List;

public interface SongService {

    public List<Song> findAll();

    public Song findById(int theId);

    public void save(Song theSong);

    public void deleteById(int theId);

    public List<Song> findAllByArtistId(int artistId);
}
