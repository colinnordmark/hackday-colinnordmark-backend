package colin.dev.example.hackdaybackend.database.playlist;

import colin.dev.example.hackdaybackend.database.music.Song;
import jakarta.persistence.*;

@Entity
@Table(name = "listed_songs")
public class ListedSong {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    Song song;
    @ManyToOne
    Playlist playlist;


    public ListedSong(Song song, Playlist playlist) {
        this.song = song;
        this.playlist = playlist;
    }

    public ListedSong() {

    }
}
