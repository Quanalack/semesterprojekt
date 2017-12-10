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
import java.util.LinkedList;



public class DataFacade implements IData
{

    @Override
    public LinkedList<Object> getHighscore() {
        
        try {
        //Create the input stream for the file
	FileInputStream fileInput = new FileInputStream("highscore.txt");
        
        //Create the input stream for the object through the file
	ObjectInputStream objectInput = new ObjectInputStream(fileInput);

	// Read object and cast
        LinkedList<Object> scores = (LinkedList<Object>)objectInput.readObject();
        
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

    /**
     * This method saves 
     * @param totalTime 
     * @param playerName 
     */
    
    @Override
    public void saveHighscore(double totalTime, String playerName) {
        //Random multiplier
        final int SCORE_MULTIPLIER = 1234;
        
        //Creating score from time and multiplier
        int score = (int)(totalTime * SCORE_MULTIPLIER);
        
        //Creating a new score as an object
        Score playerScore = new Score(playerName, score);
        
        //get the current score as objects
        LinkedList<Object> currentScoreObject = getHighscore();
        
        //Lost to hold the scores as Scores
        LinkedList<Score> currentScoreScore = new LinkedList<>();
        
        //Taking every element from object list, cast as score and add to Score list
        for (int i = 0; i < currentScoreObject.size(); i++) {
            currentScoreScore.add((Score)currentScoreObject.get(i));
        }
        
        //Check if players score is higher than #1 if it is add it there. 
        //If it's not check next value etc. Delete
        for (int i = 0; i < currentScoreScore.size(); i++) {
            if (playerScore.getScore() > currentScoreScore.get(i).getScore()) {
                //add score at index
                currentScoreScore.add(i, playerScore);
                //Remove last score
                currentScoreScore.remove(currentScoreScore.size());
                break; 
            }
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
