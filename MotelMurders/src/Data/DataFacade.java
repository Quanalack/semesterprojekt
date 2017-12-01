package Data;

import Acquaintance.IData;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;



public class DataFacade implements IData
{

    @Override
    public Object getHighscore() {
        HighscoreManager highscore = new HighscoreManager(1, "");
        return highscore.getHighscores();
         
    }

    @Override
    public void SaveHighscore(double elapsedSeconds, String playerName, int MAXTIME) {
        
        final int SCORE_MULTIPLIER = 1234;
        
        double seconds = (MAXTIME - elapsedSeconds);
        
        int score = (int)(seconds * SCORE_MULTIPLIER);
        
        HighscoreManager playerHighscore = new HighscoreManager(score, playerName);
        
        playerHighscore.addHighscore(playerHighscore);
        
        System.out.println("Game has been saved. You scored: " + score + " points! ");
        
        
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
