package Data;

import Acquaintance.IData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;



public class DataFacade implements IData
{

    @Override
    public Collection<?> getHighscore() {
        
        
        ArrayList<Score> scores = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
                scores.add(readNextScore());
        }

         return scores;
    }

    @Override
    public void SaveHighscore(double totalTime, String playerName) {
        //Random multiplier
        final int SCORE_MULTIPLIER = 1234;
        
        //Creating score from time and multiplier
        int score = (int)(totalTime * SCORE_MULTIPLIER);
        
        //get the current score
        ArrayList<Score> currentScore = (ArrayList<Score>)getHighscore();
        
        
            //Load the 10th scores
            Score score10 = currentScore.get(10);
            
            if (score > score10.getScore()) {
                
            
            
        }
        
        HighscoreManager playerHighscore = new HighscoreManager(score, playerName);
        
        playerHighscore.addHighscore(playerHighscore);
        
        System.out.println("Game has been saved. You scored: " + score + " points! ");
        
        
    }

    @Override
    public void SaveGame(ArrayList<Object> NPC, ArrayList<Object> rooms, Object player) {
        
        //Create the savefile
        SaveFile saveFile = new SaveFile(NPC, rooms, player);
        
        try 
		{       
			System.out.println("Game saved");
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("saveFile.txt"));
			o.writeObject(saveFile);
			o.close();
		} catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
		catch (IOException e) {
                    e.printStackTrace();
                }
    }

    @Override
    public Object LoadGame() {
        try {
			FileInputStream fi = new FileInputStream("saveFile.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read object and cast to a saveFile
                        SaveFile saveFile = (SaveFile) oi.readObject();
                        
			oi.close();
			fi.close();
                        
                        return saveFile;
        
        
     } catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
                    System.out.println("Class not found");
                }
        return null;
    }
    
    public static void createEmptyHighscore(){
        for (int i = 0; i < 10; i++) {
            //Creates an empty score
            Score score = new Score(null, 0);
            
            //Write it to file
            writeScore(score); 
        }
    }
    
    private int compareScores(Score a, Score b) {
        if (a.getScore() < b.getScore())
            return -1;
        if (a.getScore() > b.getScore())
            return 1;
        return 0;
    }
    
    public static void writeScore(Score score){
        try {
			FileOutputStream f = new FileOutputStream(new File("highscore.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(score);


			o.close();
			f.close();
                        
                        System.out.println("Done reading");
        
        
     } catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    }
    
    public Score readNextScore(){
        
        try {
			FileInputStream fi = new FileInputStream("highscore.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read object and cast to score 
                        Score scoreRead = (Score) oi.readObject();
                        
			oi.close();
			fi.close();
                        
                        return scoreRead;
        
        
     } catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
                    System.out.println("Class not found");
                }
        return null;
    }
}
