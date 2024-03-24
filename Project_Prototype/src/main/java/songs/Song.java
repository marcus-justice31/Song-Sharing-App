/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songs;

/**
 *
 * @author student
 */
public class Song {
    
    private int id;
    private String name, artist;
    
    public Song(int id, String name, String artist){
        this.id = id;
        this.name = name;
        this.artist = artist;
        
    }
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getArtist(){
        return this.artist;
    }
    
    public void setArtist(String artist){
        this.artist = artist;
    }
}
