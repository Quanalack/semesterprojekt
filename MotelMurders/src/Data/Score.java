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
public class Score implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String name;
    private Date date;
    private int score;
    
        Score(String name, int score) {
            this.date = new Date();
            this.score = score;
            this.name = name;
                   
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
