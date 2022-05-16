public class MusicAPI {

    private Music music;

    public MusicAPI() {
        this.music = new Music();
    }

    public void album(String album, String artist)
    {
        String response = music.makeAPICallForAlbum(album, artist);
        music.parseAlbum(response);
    }
}