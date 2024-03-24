package persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import songs.Song;
//import persistence.user_CRUD;

/**
 *
 * @author marcusuy
 */
public class playlist_CRUD {
    public static ArrayList<Song> getPlaylist(int userID){ 
        
        ArrayList<Song> playlist = new ArrayList<>();     
        ArrayList<Integer> songIDs = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?autoReconnect=true&useSSL=false", "root", "student123");
                String q = "SELECT * FROM PLAYLIST WHERE userID = ?";
                ps = con.prepareStatement(q);
                ps.setInt(1, userID);
                rs = ps.executeQuery(); // result is all songs that belong to current user

                while (rs.next()){
                    int sID = rs.getInt("songID");
                    songIDs.add(sID);
                    System.out.println("added " + sID);
                }
                
                
                for(int i = 0; i < songIDs.size(); i++){
                    q = "SELECT * FROM SONG WHERE id = ?";
                    ps = con.prepareStatement(q);
                    ps.setInt(1, songIDs.get(i));
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        String sName = rs.getString("songName");
                        String sArtist = rs.getString("artist");
                        Song song = new Song(sName, sArtist);
                        playlist.add(song);
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        return playlist;

    }
}
