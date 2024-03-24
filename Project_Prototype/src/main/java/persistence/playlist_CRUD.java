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
    
    public static void addSongToPlaylist(String playlistName, int userID, int songID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
//        
//        // need to fix
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?autoReconnect=true&useSSL=false", "root", "student123");
            String q = "INSERT INTO PLAYLIST (playlistName, userID, songID) VALUES (?, ?, ?)";
            ps = con.prepareStatement(q);
            ps.setString(1, playlistName);
            ps.setInt(2, userID);
            ps.setInt(3, songID);
            rowsAffected = ps.executeUpdate();
            System.out.println("SONG ADDED");
//
//            while (rs.next()) {
//                int sID = rs.getInt("songID");
//                String sName = rs.getString("songName");
//                String sArtist = rs.getString("artist");
//                Song song = new Song(sID, sName, sArtist);
//                songs.add(song);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
                        int sID = rs.getInt("id");
                        String sName = rs.getString("songName");
                        String sArtist = rs.getString("artist");
                        Song song = new Song(sID, sName, sArtist);
                        playlist.add(song);
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        return playlist;

    }
}
