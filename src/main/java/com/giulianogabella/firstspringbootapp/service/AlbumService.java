package com.giulianogabella.firstspringbootapp.service;

import com.giulianogabella.firstspringbootapp.entity.Album;

import java.util.List;

public interface AlbumService {

    public List<Album> findAll();

    public Album findById(int theId);

    public void save(Album theAlbum);

    public void deleteById(int theId);

    public List<Album> findAllByArtistId(int artistId);
}
