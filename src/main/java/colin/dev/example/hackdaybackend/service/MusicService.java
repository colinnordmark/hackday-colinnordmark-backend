package colin.dev.example.hackdaybackend.service;

import colin.dev.example.hackdaybackend.database.music.MusicRepository;
import colin.dev.example.hackdaybackend.database.music.Song;
import colin.dev.example.hackdaybackend.database.playlist.ListedSong;
import colin.dev.example.hackdaybackend.database.playlist.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    MusicRepository musicRepository;

    public List<SongDto> getAllSongs() {
        return musicRepository.getAll().stream()
                .map(song -> {
                    return new SongDto(
                            song.getId(),
                            song.getName(),
                            song.getArtist(),
                            song.getUrl()
                    );
                }).toList();


    }

    public List<SongDto> getPlaylist(String id) {
        var songs = playlistRepository.findById(id).getListedSongs().stream()
                .map(ListedSong::getSong)
                .toList();


        return mapToDto(songs);
    }


    public List<SongDto> postToPlaylist(String id, String songId) {
        var song = musicRepository.findById(songId);

        playlistRepository.addSong(id, song);
        return getPlaylist(id);
    }

    private List<SongDto> mapToDto(List<Song> songs) {
        return songs.stream()
                .map(song -> {
                    return new SongDto(
                            song.getId(),
                            song.getName(),
                            song.getArtist(),
                            song.getUrl()
                    );
                }).toList();
    }

    public void deleteSongFromPlaylist(String playlistId, String songId) {
        playlistRepository.deleteSong(playlistId, songId);
    }
}
