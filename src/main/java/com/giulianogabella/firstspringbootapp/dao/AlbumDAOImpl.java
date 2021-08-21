package com.giulianogabella.firstspringbootapp.dao;

import com.giulianogabella.firstspringbootapp.entity.Album;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AlbumDAOImpl implements AlbumDAO {

    private EntityManager entityManager;

    @Autowired
    public AlbumDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Album> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Album> theQuery = currentSession.createQuery("from Album", Album.class);

        List<Album> albums = theQuery.getResultList();

        return albums;
    }

    @Override
    public Album findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Album theAlbum = currentSession.get(Album.class, theId);

        return theAlbum;
    }

    @Override
    public void save(Album theAlbum) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theAlbum);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Album> theQuery = currentSession.createQuery("delete from Album where id=:albumId");
        theQuery.setParameter("albumId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public List<Album> findAllByArtistId(int artistId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Album> theQuery = currentSession.createQuery("from Album where artist_id=:artistId");
        theQuery.setParameter("artistId", artistId);

        List<Album> albumsByArtist = theQuery.getResultList();

        return albumsByArtist;
    }

}
