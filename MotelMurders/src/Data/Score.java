/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author Malte Hesk
 */
public class Score implements Serializable, Comparable<Score>{
    
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Score score) {

        return this.getScore() - score.getScore();
        
    }
    
    
    
}
