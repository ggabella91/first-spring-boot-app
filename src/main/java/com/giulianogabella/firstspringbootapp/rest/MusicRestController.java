package com.giulianogabella.firstspringbootapp.rest;

import com.giulianogabella.firstspringbootapp.entity.Album;
import com.giulianogabella.firstspringbootapp.entity.Artist;
import com.giulianogabella.firstspringbootapp.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MusicRestController {

    private ArtistService artistService;

    @Autowired
    public MusicRestController(ArtistService theArtistService) {
        artistService = theArtistService;
    }

    @GetMapping("/artists")
    public List<Artist> findAllArtists() {
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

    @GetMapping("/albums")
    public List<Album> findAllAlbums() {
//        return albumService.findAll();
        return null;
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist theArtist) {

        // In case user passes an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theArtist.setId(0);

        artistService.save(theArtist);

        return theArtist;
    }
}