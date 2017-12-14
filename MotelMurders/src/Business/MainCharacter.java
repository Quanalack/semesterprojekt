/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Scanner;

public class MainCharacter implements IPerson {

    private String name; //Name of the player
    private Room currentRoom; //Room of the player
    private String description; //Players description

    

    /**
     * Get the name of the player
     * @return the name of the player.
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the player from user input.
     */
    public void newName() {
        Scanner output = new Scanner(System.in);

        System.out.println(">What is your name?");

        String newName = output.next();

        this.name = newName;

    }

    /**
     * Change current room.
     * @param newRoom the room to go to.
     */
    @Override
    public void goRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    /**
     * Get the current room
     * @return the current room the player is in.
     */
    @Override
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Get the description of the player
     * @return the description of the player
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Set player description
     * @param description Description of player
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

}
