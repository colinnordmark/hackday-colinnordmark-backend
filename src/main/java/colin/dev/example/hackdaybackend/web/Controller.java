package colin.dev.example.hackdaybackend.web;

import colin.dev.example.hackdaybackend.database.music.Song;
import colin.dev.example.hackdaybackend.service.AddSongDto;
import colin.dev.example.hackdaybackend.service.MusicService;
import colin.dev.example.hackdaybackend.service.SongDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {

    @Autowired
    MusicService musicService;

    @GetMapping
    ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello world: ");
    }

    @GetMapping("/songs")
    ResponseEntity<List<SongDto>> getAllSongs() {
        return ResponseEntity.ok(musicService.getAllSongs());
    }

    @GetMapping("/playlists/{id}")
    ResponseEntity<List<SongDto>> getPlaylist(@PathVariable String id) {
        return ResponseEntity.ok(musicService.getPlaylist(id));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/playlists/{playlistId}")
    ResponseEntity<List<SongDto>> postToPlaylist(
            @PathVariable String playlistId,
            @RequestBody AddSongDto request

    ) {
        return ResponseEntity.ok(musicService.postToPlaylist(playlistId, request.songId()));
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/playlists/{playlistId}")
    ResponseEntity<?> deleteFromPlaylist(
            @PathVariable String playlistId,
            @RequestBody AddSongDto request
    ){
        musicService.deleteSongFromPlaylist(playlistId, request.songId());
        return ResponseEntity.noContent().build();
    }

}
