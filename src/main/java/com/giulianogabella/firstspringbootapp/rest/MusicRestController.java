package com.giulianogabella.firstspringbootapp.rest;

import com.giulianogabella.firstspringbootapp.entity.Album;
import com.giulianogabella.firstspringbootapp.entity.Artist;
import com.giulianogabella.firstspringbootapp.entity.Song;
import com.giulianogabella.firstspringbootapp.service.AlbumService;
import com.giulianogabella.firstspringbootapp.service.ArtistService;
import com.giulianogabella.firstspringbootapp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicRestController {

    private ArtistService artistService;
    private AlbumService albumService;
    private SongService songService;

    @Autowired
    public MusicRestController(ArtistService theArtistService) {
        artistService = theArtistService;
    }

    @GetMapping("/artists")
    public String findAllArtists(Model theModel) {
        List<Artist> theArtists = artistService.findAll();

        theModel.addAttribute("artists", theArtists);

        return "music/artists";
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
        return albumService.findAll();
    }

    @GetMapping("/albums/{albumId}")
    public Album getAlbum(@PathVariable int albumId) {

        Album theAlbum = albumService.findById(albumId);

        if (theAlbum == null) {
            throw new RuntimeException("Album id is not found - " + albumId);
        }

        return theAlbum;
    }

    @GetMapping("/songs")
    public List<Song> findAllSongs() {
        return songService.findAll();
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable int songId) {

        Song theSong = songService.findById(songId);

        if (theSong == null) {
            throw new RuntimeException("Song id is not found - " + songId);
        }

        return theSong;
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist theArtist) {

        // In case user passes an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theArtist.setId(0);

        artistService.save(theArtist);

        return theArtist;
    }

    @PostMapping("/albums")
    public Album addAlbum(@RequestBody Album theAlbum) {

        // In case user passes an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theAlbum.setId(0);

        albumService.save(theAlbum);

        return theAlbum;
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song theSong) {

        // In case user passes an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theSong.setId(0);

        songService.save(theSong);

        return theSong;
    }
}