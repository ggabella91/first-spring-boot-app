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
@RequestMapping("/api")
public class MusicRestController {

    private ArtistService artistService;
    private AlbumService albumService;
    private SongService songService;

    @Autowired
    public MusicRestController(ArtistService theArtistService, AlbumService theAlbumService, SongService theSongService) {
        artistService = theArtistService;
        albumService = theAlbumService;
        songService = theSongService;
    }

    @GetMapping("/artists")
    public List<Artist> findAllArtists(Model theModel) {

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

    @GetMapping("/artists/name/{artistName}")
    public Artist getArtistByName(@PathVariable String artistName) {

        artistName = artistName.replace(" ", "+");

        Artist theArtist = artistService.findByName(artistName);

        if (theArtist == null) {
            throw new RuntimeException(("Artist name not found " + artistName));
        }

        return theArtist;
    }

    @GetMapping("/artists/album/{albumId}")
    public Artist getArtistByAlbum(@PathVariable int albumId) {

        Artist theArtist = artistService.findByAlbumId(albumId);

        if (theArtist == null) {
            throw new RuntimeException("Album id not found - " + albumId);
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

    @GetMapping("/albums/artist/{artistId}")
    public List<Album> findAllAlbumsByArtist(@PathVariable int artistId) {
        List<Album> albumsByArtist = albumService.findAllByArtistId(artistId);

        if (albumsByArtist == null) {
            throw new RuntimeException("Albums by artist with id " + artistId + " were not found");
        }

        return albumsByArtist;
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

    @GetMapping("/songs/artist/{artistId}")
    public List<Song> findAllSongsByArtist(@PathVariable int artistId) {
        List<Song> songsByArtist = songService.findAllByArtistId(artistId);

        if (songsByArtist == null) {
            throw new RuntimeException("Songs by artist with id " + artistId + " were not found");
        }

        return songsByArtist;
    }

    @GetMapping("/songs/album/{albumId}")
    public List<Song> findAllSongsByAlbum(@PathVariable int albumId) {
        List<Song> songsInAlbum = songService.findAllByAlbumId(albumId);

        if (songsInAlbum == null) {
            throw new RuntimeException("Songs in album with id " + albumId + " were not found");
        }

        return songsInAlbum;
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