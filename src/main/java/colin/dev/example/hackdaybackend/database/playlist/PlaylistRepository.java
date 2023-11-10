package colin.dev.example.hackdaybackend.database.playlist;

import colin.dev.example.hackdaybackend.database.music.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlaylistRepository {
    @Autowired
    private JpaPlaylistRepository repo;


    public Playlist findById(String id){
        return repo.findById(id).orElseThrow();
    }

    public void addSong(String id, Song song){
        var playlist = findById(id);

        ListedSong existingSong = getSongInPlaylist(playlist, song.getId());

        if (existingSong.getSong() != null) {
            throw new IllegalArgumentException();
        } else {
            ListedSong newSong = new ListedSong(
                    song,
                    playlist
            );
            playlist.listedSongs.add(newSong);
        }
        repo.save(playlist);
    }

    private ListedSong getSongInPlaylist(Playlist playlist, String songID) {
        return playlist.listedSongs.stream()
                .filter(song -> song.song.getId().equals(songID))
                .findAny().orElseGet(ListedSong::new);
    }

    public void deleteSong(String playlistId, String songId) {
        var playlist = findById(playlistId);
        repo.delete(playlist);

        playlist.listedSongs = playlist.listedSongs.stream()
                .filter(song -> !song.getSong().getId().equals(songId))
                .toList();

        repo.save(playlist);
    }
}
