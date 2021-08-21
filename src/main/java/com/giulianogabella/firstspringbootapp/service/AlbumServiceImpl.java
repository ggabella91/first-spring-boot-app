package com.giulianogabella.firstspringbootapp.service;

import com.giulianogabella.firstspringbootapp.dao.AlbumDAO;
import com.giulianogabella.firstspringbootapp.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumDAO albumDAO;

    @Autowired
    public AlbumServiceImpl(AlbumDAO theAlbumDAO) {
        albumDAO = theAlbumDAO;
    }

    @Override
    @Transactional
    public List<Album> findAll() {
        return albumDAO.findAll();
    }

    @Override
    @Transactional
    public Album findById(int theId) {
        return albumDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Album theAlbum) {
        albumDAO.save(theAlbum);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        albumDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Album> findAllByArtistId(int artistId) {
       return albumDAO.findAllByArtistId(artistId);
    }
}
