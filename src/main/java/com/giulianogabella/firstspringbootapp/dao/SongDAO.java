package com.giulianogabella.firstspringbootapp.dao;


import com.giulianogabella.firstspringbootapp.entity.Song;

import java.util.List;

public interface SongDAO {

    public List<Song> findAll();

    public Song findById(int theId);

    public void save(Song theSong);

    public void deleteById(int theId);

    List<Song> findAllByArtistId(int artistId);

    List<Song> findAllByAlbumId(int albumId);
}
