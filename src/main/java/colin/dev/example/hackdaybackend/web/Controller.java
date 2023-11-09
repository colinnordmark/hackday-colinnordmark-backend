package colin.dev.example.hackdaybackend.web;

import colin.dev.example.hackdaybackend.database.music.Song;
import colin.dev.example.hackdaybackend.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    MusicService musicService;

    @GetMapping
    ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello world: ");
    }

    @GetMapping("/api/songs")
    ResponseEntity<List<Song>> getAllSongs(){
        return ResponseEntity.ok(musicService.getAllSongs());
    }

}
