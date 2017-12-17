
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
    
    /**
     * The no-arg constructor for the score
     */
    public Score() {
        this.date = new Date();
        this.name = null;
        this.score = 0;
    }
    
    /**
     * The two parameter constructor for the score
     * @param name the player name
     * @param score the score of the player
     */
        public Score(String name, int score) {
            //set date to current date
            this.date = new Date();
            
            this.score = score;
            this.name = name;
                   
        }

    
    /**
     * Get the player name
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Change player name
     * @param name the new player name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the date the score was created
     * @return the date the score was created
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     * Get the score of the player
     * @return 
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Set a new score
     * @param score the new score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
