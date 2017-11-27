package Data;

import Acq.IData;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;


public class DataFacade implements IData
{

    @Override
    public Object LoadHighscore() {
        HighScore highscore1 = new HighScore(1, "");
        return highscore1.getHighScores();
         
    }

    @Override
    public void SaveHighscore(int elapsedSeconds, String playerName, int MAXTIME) {
        
        final int SCORE_MULTIPLIER = 1234;
        
        long seconds = MAXTIME - elapsedSeconds;
        
        int score = (int)(seconds * SCORE_MULTIPLIER);
        
        HighScore playerHighscore = new HighScore(score, playerName);
        
        playerHighscore.addHighScore(playerHighscore);
        
        System.out.println("You scored: " + score + " points! ");
        
        
    }

    @Override
    public void SaveGame(Object[] game) {
        try 
		{       
			System.out.println("Game saved");
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("HighScores.txt"));
			o.writeObject(game);
			o.close();
		} catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
		catch (IOException e) {
                    e.printStackTrace();
                }
    }

    @Override
    public Collection<Object> LoadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
