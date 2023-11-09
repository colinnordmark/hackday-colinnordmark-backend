package colin.dev.example.hackdaybackend.database.music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Song {
    @Id
    int id;
    @Column
    String name;
    @Column
    String artist;
    @Column
    String source;
    @Column
    String url;
}
