package colin.dev.example.hackdaybackend.database.playlist;

import colin.dev.example.hackdaybackend.database.music.Song;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Playlist {
    @Id
    int id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "playlist", cascade = {CascadeType.ALL})
    @Column
    List<ListedSong> listedSongs;

    public int getId() {
        return id;
    }

    public List<ListedSong> getListedSongs() {
        return listedSongs;
    }
}
