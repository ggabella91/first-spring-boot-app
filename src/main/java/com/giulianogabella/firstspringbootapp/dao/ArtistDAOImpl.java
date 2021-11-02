package com.giulianogabella.firstspringbootapp.dao;

import com.giulianogabella.firstspringbootapp.entity.Artist;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ArtistDAOImpl implements ArtistDAO {

    private EntityManager entityManager;

    @Autowired
    public ArtistDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Artist> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Artist> theQuery = currentSession.createQuery("from Artist", Artist.class);

        List<Artist> artists = theQuery.getResultList();

        return artists;
    }

    @Override
    public Artist findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Artist theArtist = currentSession.get(Artist.class, theId);

        return theArtist;
    }

    @Override
    public void save(Artist theArtist) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theArtist);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Artist> theQuery = currentSession.createQuery("delete from Artist where id=:artistId");
        theQuery.setParameter("artistId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public Artist findByAlbumId(int albumId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Artist> theQuery = currentSession.createQuery("select ar.* " +
                                                                        "from Album al " +
                                                                        "join Artist ar on ar.id =:albumId");
        theQuery.setParameter("albumId", albumId);

        return theQuery.getSingleResult();
    }
}
