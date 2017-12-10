/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Data.Score;
import java.util.LinkedList;

/**
 *
 * @author malte
 */
public interface IScore {
    
    LinkedList<Score> getHighscore();
    void saveHighscore(double seconds, String playerName);
}
