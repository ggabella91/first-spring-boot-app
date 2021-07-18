package com.giulianogabella.firstspringbootapp.dao;

import com.giulianogabella.firstspringbootapp.entity.Album;

import java.util.List;

public interface AlbumDAO {

    public List<Album> findAll();

    public Album findById(int theId);

    public void save(Album theAlbum);

    public void deleteById(int theId);
}