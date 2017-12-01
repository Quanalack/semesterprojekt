/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.*;

public class HighscoreManager implements Serializable
{
	private static final long serialVersionUID = 1L; 
	private int score;
	private String name;
	
	//The constructor
	public HighscoreManager(int s, String n)
	{
		score=s;
		setName(n);
	}
	
	//The setters and getters
	public void setScore(int score)
	{
		this.score=score;
	}
        
        public int getScore()
	{
		return score;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}

        //Compares two score
	public int compareTo(HighscoreManager h)
	{
            //Compare 
		return new Integer(this.score).compareTo(h.score);
	}
	
	//This is called when there is an empty file in order prevent exceptions
	private static void initializeFile()
	{
		HighscoreManager[] h = {new HighscoreManager(0," "),new HighscoreManager(0," "),new HighscoreManager(0," "),
				new HighscoreManager(0," "),new HighscoreManager(0," "),new HighscoreManager(0," "),
				new HighscoreManager(0," "),new HighscoreManager(0," "),new HighscoreManager(0," "),
				new HighscoreManager(0," ")};
		try 
		{       
			System.out.println("Higscore saved");
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("HighscoreManagers.txt"));
			o.writeObject(h);
			o.close();
		} catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
		catch (IOException e) {
                    e.printStackTrace();
                }
	}
	
	//Reads the .txt file and returns the constants
	public HighscoreManager[] getHighscores()
	{
		if (!new File("HighscoreManagers.txt").exists())
			initializeFile();
		try 
		{
			ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("HighscoreManagers.txt"));
                        
			HighscoreManager[] h=(HighscoreManager[]) objectStream.readObject();
			return h;
		} catch (IOException e) {e.printStackTrace();} 
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}
	
        
	//Adds a new HighscoreManager to the .txt file and maintains the proper order
	public void addHighscore(HighscoreManager h){
		HighscoreManager[] highScores = getHighscores();
		highScores[highScores.length-1]=h;
		for (int i=highScores.length-2; i>=0; i--)
		{
			if (highScores[i+1].compareTo(highScores[i])>0)
			{
				HighscoreManager temp=highScores[i];
				highScores[i]=highScores[i+1];
				highScores[i+1]=temp;
			}
		}
		try 
		{
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("HighscoreManagers.txt"));
			o.writeObject(highScores);
			o.close();
		} catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	
}