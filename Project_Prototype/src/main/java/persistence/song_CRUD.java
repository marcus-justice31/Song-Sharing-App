package persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import songs.Song;
//import persistence.user_CRUD;

public class song_CRUD {
   public static void addSongs(){
       
   } 
    
   public static ArrayList<Song> getSongs(){ //int userID
        
   ArrayList<Song> songs = new ArrayList<>();     
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LMS?autoReconnect=true&useSSL=false", "root", "student123");
            String q = "SELECT * FROM SONG";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int sID = rs.getInt("id");
                String sName = rs.getString("songName");
                String sArtist = rs.getString("artist");
                Song song = new Song(sID, sName, sArtist);
                songs.add(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return songs;

    }
    
}
    


