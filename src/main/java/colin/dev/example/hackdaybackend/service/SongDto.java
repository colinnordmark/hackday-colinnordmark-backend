package colin.dev.example.hackdaybackend.service;

public record SongDto(
        int id,
        String name,
        String artist,
        String url
) {
}
