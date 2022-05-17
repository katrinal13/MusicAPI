import java.util.Scanner;

public class MusicRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the album name: ");
        String album = s.nextLine();

        String albumURL = "";
        if (album.indexOf(" ") != -1)
        {
            for (int i = 0; i < album.length(); i++)
            {
                if (album.substring(i, i + 1).equals(" "))
                {
                    albumURL += "+";
                }
                else
                {
                    albumURL += album.substring(i, i + 1);
                }
            }
            album = albumURL;
        }

        System.out.print("Enter the artist name: ");
        String artist = s.nextLine();

        String artistURL = "";
        if (artist.indexOf(" ") != -1) {
            for (int i = 0; i < artist.length(); i++) {
                if (artist.substring(i, i + 1).equals(" ")) {
                    artistURL += "+";
                } else {
                    artistURL += artist.substring(i, i + 1);
                }
            }
            artist = artistURL;
        }

        MusicAPI api = new MusicAPI();
        api.album(album, artist);
    }
}