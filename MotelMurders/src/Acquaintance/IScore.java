/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Date;

/**
 * IScore interface for handling the scores of players.
 * Implemented on Score
 */
public interface IScore {
    /**
     * Get the name on a score object
     * @return the name of the player
     */
    String getName();
    
    /**
     * Get the score on a score object
     * @return the score
     */
    int getScore();
    
    /**
     * Get the date the score was created
     * @return the date
     */
    Date getDate();
    
}
