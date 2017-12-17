/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IScore;
import java.util.Date;
import java.io.Serializable;


public class Score implements Serializable, IScore{
    
    //UID in order to read and write the object
    private static final long serialVersionUID = 1L;
    //Name of the player
    private String name;
    //Date the score was created
    private Date date;
    //The score 
    private int score;
    
    public Score() {
        this.date = new Date();
        this.name = null;
        this.score = 0;
    }
    
        public Score(String name, int score) {
            //set date to current date
            this.date = new Date();
            
            this.score = score;
            this.name = name;
                   
        }

    //Getters and setter:
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
