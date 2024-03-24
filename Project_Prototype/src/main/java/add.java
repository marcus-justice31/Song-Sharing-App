/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import songs.Song;
import user.User;
import persistence.user_CRUD;
import persistence.playlist_CRUD;

/**
 *
 * @author student
 */
@WebServlet(urlPatterns = {"/add"})
public class add extends HttpServlet {
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String songIDString = request.getParameter("songID");
        int songID = Integer.parseInt(songIDString); 
        
        User user = (User) request.getSession().getAttribute("user"); // when successful log in, i set the current session user as an attribute
        String username = user.getUsername();
        
        String playlistName = username + "Playlist";
        
        int userID = user_CRUD.getUserID(username);
        
        playlist_CRUD.addSongToPlaylist(playlistName, userID, songID);
        
        
        
//        int userID = user_CRUD.getUserID(username);
//        ArrayList<Song> playlist = playlist_CRUD.getPlaylist(userID);
        
//        String songArtist = (String) request.getParameter("songArtist");
        
//        
//        helper.userInfo dbt = user_CRUD.read(username, password);
//        
//        userInfo uinfo = getUserInfo(username, password);
//        request.setAttribute("uinfo", uinfo);

      //  String title = request.getParameter("title");
      //  String artist = request.getParameter("artist");
        
        // Create a new Song object with the submitted data
      //  Song newSong = new Song(title, artist);
        
        // Retrieve uinfo from request attribute
      //  userInfo uinfo = (userInfo) request.getAttribute("uinfo");
        
        // Add the new song to uinfo
      //  uinfo.addSong(newSong);
        
        // Redirect back to the userSongs.jsp or any other page
       // userInfo uinfo = (userInfo) request.getAttribute("uinfo");
      //  request.setAttribute("uinfo", uinfo);
       RequestDispatcher rd = request.getRequestDispatcher("songAdded.jsp");
      //  response.sendRedirect("userSongs.jsp");
       rd.forward(request, response);
        
   //    RequestDispatcher rd = request.getRequestDispatcher("songAdded.jsp");
   //    rd.forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
