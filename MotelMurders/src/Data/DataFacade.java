package Data;

import Business.Score;
import Business.SaveFile;
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
    public ArrayList<Object> getHighscore() {
        
        try {
        //Create the input stream for the file
	FileInputStream fileInput = new FileInputStream("highscore.txt");
        
        //Create the input stream for the object through the file
	ObjectInputStream objectInput = new ObjectInputStream(fileInput);

	// Read object and cast
        ArrayList<Object> scores = (ArrayList<Object>)objectInput.readObject();
        
        //Close streams
	objectInput.close();
	fileInput.close();
                        
        return scores;
        
        
     } catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
                    System.out.println("Class not found");
                }
        
        return null;
    }

    @Override
    public void saveHighscore(double totalTime, String playerName) {
        //Random multiplier
        final int SCORE_MULTIPLIER = 1234;
        
        //Creating score from time and multiplier
        int score = (int)(totalTime * SCORE_MULTIPLIER);
        
        //get the current score
        ArrayList<Object> currentScore = getHighscore();
        
        
            //Load the 10th scores
            Score score10 = (Score)currentScore.get(10);
            
            //Check if player score is higher than the 10th score
            if (score > score10.getScore()) {
                //Int to see where the players score is placed on highscore
                int index;
                
            
            }
        
        System.out.println("Game has been saved. You scored: " + score + " points! ");
        
        
    }

    @Override
    public void saveGame(ArrayList<Object> NPC, ArrayList<Object> rooms, Object player) {
        
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
    public Object loadGame() {
        try {
            
			FileInputStream fi = new FileInputStream("saveFile.txt");
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read object and cast to a saveFile
                        SaveFile saveFile = (SaveFile) oi.readObject();
                        
			oi.close();
			fi.close();
                        
                        System.out.println("Game loaded");
                        
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
    
    public static void createEmptyHighscore(Object score){
        
        //Create array for highscore
        ArrayList<Object> scores = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            //Creates an empty score 
            scores.add(score);
            
        }    
            //Write it to file
            writeObject(scores); 
        
    }
    
    public static void writeObject(ArrayList<Object> highscore){
        
    try {
        //Create the ouputstream for the file
	FileOutputStream fileOutput = new FileOutputStream(new File("highscore.txt"));
        
        //Create the output stream for the objects through the file
	ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

	// Write the score to file
	objectOutput.writeObject(highscore);

        //Close the steams
	objectOutput.close();
	fileOutput.close();
                        
        System.out.println("Done reading");
        
        
    } catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    }
    
    public Score readNextHighscore(){
           
        return null;
    }
}
