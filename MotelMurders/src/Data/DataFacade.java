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

    /**
     * Retrieves the highscore stored in a file
     * @return a linkedlist of the scores.
     */
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
     * Creates a score, loads the saved highscore and adds the created 
     * score in the highscore if it is high enough.
     * @param totalTime total time elapsed from beginning of game
     * @param playerName The name of the player
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
        //If it's not check next value etc. Delete last score.
        for (int i = 0; i < currentScoreScore.size(); i++) {
            if (playerScore.getScore() > currentScoreScore.get(i).getScore()) {
                //add score at index
                currentScoreScore.add(i, playerScore);
                //Remove last score
                currentScoreScore.remove(currentScoreScore.size()-1);
                break; 
            }
        }
            
        
        System.out.println("Game has been saved. You scored: " + score + " points! ");
        
        
    }

    
    /**
     * Saves the current state of the game in a file.
     * @param characters a list of the NPC's 
     * @param rooms a list of the rooms
     * @param player the player
     */
    @Override
    public void saveGame(ArrayList<Object> characters, ArrayList<Object> rooms, Object player) {
        
        //Create the savefile
        SaveFile saveFile = new SaveFile(characters, rooms, player);
        
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

    /**
     * Loads a specific state of a game previously saved in a file.
     * @return a saveFile as an object.
     */
    @Override
    public Object loadGame() {
        try {
            
		FileInputStream fileInput = new FileInputStream("saveFile.txt");
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);

		// Read object and cast to a saveFile
                SaveFile saveFile = (SaveFile) objectInput.readObject();
                
		objectInput.close();
		fileInput.close();
                       
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
    
    /**
     * Creates an arraList of empty scores.
     * An empty score is where the name is null and score is 0
     * @param score 
     */
    public static void createEmptyHighscore(){
        
        //Create array for highscore
        ArrayList<Object> scores = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            //Creates an empty score 
            scores.add(new Score());
            
        }    
            //Write it to file
            writeObject(scores); 
        
    }
    
    /**
     * Write the highscore to a file.
     * @param highscore the specified highscore to save onto the file.
     */
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
}
