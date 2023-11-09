package colin.dev.example.hackdaybackend.database.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MusicRepository {
    @Autowired
    private JpaMusicRepository repo;


    public Song findById(String id){
        return repo.findById(id).orElseThrow();
    }


}
