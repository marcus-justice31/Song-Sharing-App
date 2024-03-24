<%@ page import="songs.Song" %>
<%@ page import="helper.userInfo" %>
<%@ page import="persistence.song_CRUD" %>
<%@ page import="persistence.user_CRUD" %>
<%@ page import="persistence.playlist_CRUD" %>
<%@page import="java.util.ArrayList" %>

<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Explore Page</title>
    </head>


    
    <body style="background-color: black;">
        
        
   
        
        <FONT style="font-family: Montserrat;"><center><h1><span style="color: white;">more tracks,</span><span style="color: rgb(100, 178, 241);"> just for you</span></h1></center></FONT>

        <form action = "add" method="post"> 
            
        <table style="color: white;" align="center" cellpadding = "5" cellspacing = "5" style = "font-family: Montserrat; background-color: white; border-radius: 10px; border: 2px; text-align: center;">
            <tr style = "font-family: Montserrat;">
<!--                <th>Song Name</th>
                <th>Artist</th>
                <th>Add</th>-->
            </tr>
            
        <%
            ArrayList<Song> songs = song_CRUD.getSongs();
        %>
            
            <!--<form action="Extend" method="post" style="background-color: black">-->
            <table align="center" cellpadding = "5" cellspacing = "5" style = "background-color: white; border-radius: 10px; border: 2px; text-align: center;">
                <tr>
                    <th style = "font-family: Montserrat;">Song Name</th>
                    <th style = "font-family: Montserrat;">Artist</th>
                    <th style = "font-family: Montserrat;">Add</th>
                </tr>
                
                <% 
                for(Song songVar : songs){
                %>
                    <tr>
                        <td style="font-family: Montserrat"> <%=songVar.getName()%> </td> 
                        <td style="font-family: Montserrat"> <%=songVar.getArtist()%></td>
                        <td>
                            <form action="add" method="post" style="background-color: black">
                                <input type="hidden" name="songID" value="<%= songVar.getID() %>">
<!--                                <input type="hidden" name="songName" value="<%= songVar.getName() %>">
                                <input type="hidden" name="songArtist" value="<%= songVar.getArtist() %>">-->
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                <% } %>
        </form>
               
    </body>
</html>
