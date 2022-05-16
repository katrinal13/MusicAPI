import java.util.Scanner;

public class MusicRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the album name: ");
        String album = s.nextLine();
        System.out.print("Enter the artist name: ");
        String artist = s.nextLine();

        MusicAPI api = new MusicAPI();
        api.album(album, artist);
    }
}