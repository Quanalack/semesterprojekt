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

    private final int maxLimit = 4; //Number of items in inventory including magnifying glass. Can only be assigned once

    //Our arraylist will hold the inventory items for our game
    ArrayList<Clue> inventory = new ArrayList<>();

    /**
     * Get the inventory of player
     * @return An arraylist of the inventory
     */
    public ArrayList<Clue> getInventory() {
        return inventory;
    }

    /**
     * Set the players inventory
     * @param inventory the new inventory to be set
     */
    public void setInventory(ArrayList<Clue> inventory) {
        this.inventory = inventory;
    }

    /**
     * Print current inventory to console
     */
    public void printInventory() {
        String output = ""; //Empty string to output
        System.out.println(">You're currently carrying:");

        //Iterate through the inventory and add to string
        for (int i = 0; i < this.inventory.size(); i++) {
            output += this.inventory.get(i).getItemName() + ",  ";
        }
        //Print the generated string
        System.out.println(output);
    }

    /**
     * Adds the magnifying glass to players inventory
     */
    public void addMagnifyingGlass() {

        inventory.add(new Clue("","Magnifying Glass",true));
    }

    /**
     * Drops a specific item from inventory
     * @param command The command input from player
     */
    public void dropItem(Command command) {
        
        //Check if there is more than one word
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        //get the item name
        String itemName = command.getSecondWord();

        //Check if player is trying to drop magnifying glass
        if (itemName.equalsIgnoreCase("magnifying")) {
            System.out.println(">You cannot drop your magnifying glass! You need it!");
            return;
        }
        
        //if item is found = true
        boolean itemFound = false;
        
        //Iterate through inventory to find item name
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
                
                itemFound = true;
                
                //Removes reuired item from inventory
                inventory.remove(i);
                getCurrentRoom().setItem(new Clue(getDescription(), itemName, true));  //Leaves the item with the description, name and property in room

                //Prints to console
                System.out.println("Dropped: " + itemName);
            }
        }

        //Check if item was found
        if (!itemFound) {
            System.out.println(">It's not in your inventory");
        } 
    }

    /**
     * Pick up a specific item from current room
     * @param command the command from user input
     */
    public void pickupItem(Command command) {

        //Check if player has space in inventory
        if (inventory.size() == maxLimit) {
            System.out.println(">There is no more room in your inventory.");
        } else {
            
            //Check if user command has a second word
            if (!command.hasSecondWord()) {
                System.out.println(">Pick up what?");
                return;
            }
            
            //Get second word from user command
            String item = command.getSecondWord();

            //Get item by the name from command
            Item nextItem = getCurrentRoom().getItem(item);

            //Check if item exist
            if (nextItem == null) {
                System.out.println(">There is no item named that!");
                
            } else if (!nextItem.isPickupAble()) {
                System.out.println(">You can't pick up stuff like that.");
                
            } else {
                //add item to inventory and remove from room.
                inventory.add((Clue)nextItem);
                getCurrentRoom().removeItem(item);
                
                System.out.println("Picked up:" + item); 
                
            }
        }
    }

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
