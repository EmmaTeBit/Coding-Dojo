
package Basics.Hasmatique;
import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> song = new HashMap<String, String>();
        //Add in at least 4 songs that are stored by title
        song.put("Jumping Cow", "MK Jackson");
        song.put("Jumping Frog", "MJ Jackson");
        song.put("Jumping Dog", "MK Jonna");
        song.put("Jumping Cat", "MK CHristy");
        System.out.println(song.get("Cow"));

        for (String key : song.keySet()) {
            System.out.println(String.format("Song: %s - Artist: %s", key, song.get(key)));
            // System.out.println(String.format("Track: %s - Lyrics: %s", key, map.get(key)));

        }
    }
}
