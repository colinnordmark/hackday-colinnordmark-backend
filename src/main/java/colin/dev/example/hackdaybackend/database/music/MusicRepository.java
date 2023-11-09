package colin.dev.example.hackdaybackend.database.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    @Autowired
    private JpaMusicRepository repo;


    public Song findById(String id){
        return repo.findById(id).orElseThrow();
    }

    public List<Song> getAll(){
        List<Song> result = (List<Song>) repo.findAll();
        return result;
    }
}
