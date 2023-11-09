package colin.dev.example.hackdaybackend.database.music;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMusicRepository extends CrudRepository<Song, String> {

}
