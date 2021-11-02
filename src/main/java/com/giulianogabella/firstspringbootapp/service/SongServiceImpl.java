package com.giulianogabella.firstspringbootapp.service;

import com.giulianogabella.firstspringbootapp.dao.SongDAO;
import com.giulianogabella.firstspringbootapp.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private SongDAO songDAO;

    @Autowired
    public SongServiceImpl(SongDAO theSongDAO) {
        songDAO = theSongDAO;
    }

    @Override
    @Transactional
    public List<Song> findAll() {
        return songDAO.findAll();
    }

    @Override
    @Transactional
    public Song findById(int theId) {
        return songDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Song theSong) {
        songDAO.save(theSong);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        songDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Song> findAllByArtistId(int artistId) {
        return songDAO.findAllByArtistId(artistId);
    }

    @Override
    @Transactional
    public List<Song> findAllByAlbumId(int albumId) {
        return songDAO.findAllByAlbumId(albumId);
    }
}
