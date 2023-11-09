package colin.dev.example.hackdaybackend.service;

public record SongDto(
        String id,
        String name,
        String artist,
        String url
) {
}
