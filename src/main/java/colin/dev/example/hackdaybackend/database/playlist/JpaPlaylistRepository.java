package colin.dev.example.hackdaybackend.database.playlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPlaylistRepository extends CrudRepository<Playlist, String> {

}
