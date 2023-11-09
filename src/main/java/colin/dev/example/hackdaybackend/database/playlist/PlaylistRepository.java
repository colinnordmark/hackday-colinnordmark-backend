package colin.dev.example.hackdaybackend.database.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlaylistRepository {
    @Autowired
    private JpaPlaylistRepository repo;


    public Playlist findById(String id){
        return repo.findById(id).orElseThrow();
    }


}
