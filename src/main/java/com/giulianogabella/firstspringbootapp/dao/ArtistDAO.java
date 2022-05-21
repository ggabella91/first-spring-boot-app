package com.giulianogabella.firstspringbootapp.dao;

import com.giulianogabella.firstspringbootapp.entity.Artist;

import java.util.List;

public interface ArtistDAO {

    public List<Artist> findAll();

    public Artist findById(int theId);

    public Artist findByName(String theName);

    public void save(Artist theArtist);

    public void deleteById(int theId);

    public Artist findByAlbumId(int albumId);
}
