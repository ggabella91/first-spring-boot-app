package com.giulianogabella.firstspringbootapp.dao;

import com.giulianogabella.firstspringbootapp.entity.Song;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SongDAOImpl implements SongDAO {

    private EntityManager entityManager;

    @Autowired
    public SongDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Song> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Song> theQuery = currentSession.createQuery("from Song", Song.class);

        List<Song> songs = theQuery.getResultList();

        return songs;
    }

    @Override
    public Song findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Song theSong = currentSession.get(Song.class, theId);

        return theSong;
    }

    @Override
    public void save(Song theSong) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theSong);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Song> theQuery = currentSession.createQuery("delete from Song where id=:songId");
        theQuery.setParameter("songId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public List<Song> findAllByArtistId(int artistId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Song> theQuery = currentSession.createQuery("from Song where artist_id=:artistId");
        theQuery.setParameter("artistId", artistId);

        List<Song> songsByArtist = theQuery.getResultList();

        return songsByArtist;
    }
}
