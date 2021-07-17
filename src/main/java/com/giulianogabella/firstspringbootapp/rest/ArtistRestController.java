package com.giulianogabella.firstspringbootapp.rest;

import com.giulianogabella.firstspringbootapp.entity.Artist;
import com.giulianogabella.firstspringbootapp.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArtistRestController {

    private ArtistService artistService;

    @Autowired
    public ArtistRestController(ArtistService theArtistService) {
        artistService = theArtistService;
    }

    @GetMapping("/artists")
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @GetMapping("/artists/{artistId}")
    public Artist getArtist(@PathVariable int artistId) {

        Artist theArtist = artistService.findById(artistId);

        if (theArtist == null) {
            throw new RuntimeException("Artist id not found - " + artistId);
        }

        return theArtist;
    }
}












