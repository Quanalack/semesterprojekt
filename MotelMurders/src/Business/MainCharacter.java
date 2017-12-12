/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author malte
 */
public class MainCharacter implements IPerson {

    private String name; //Name of the player
    private Room currentRoom; //Room of the player
    private String description;

    public String getName() {
        return name;
    }

    //Method to print players current inventory
    private final int maxLimit = 4; //Number of items in inventory including magnifying glass. Can only be assigned once

    //Our arraylist will hold the inventory items for our game
    ArrayList<Clue> inventory = new ArrayList<>();

    public ArrayList<Clue> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Clue> inventory) {
        this.inventory = inventory;
    }

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

    public void addMagnifyingGlass() {

        inventory.add(new Clue("","Magnifying Glass",true));
    }

    public void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String item = command.getSecondWord();

        if (item.equalsIgnoreCase("magnifying glass")) {
            System.out.println(">You cannot drop your magnifying glass! You need it!");
            return;
        }
        
        Clue nextItem = null;
        int index = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getItemName().equalsIgnoreCase(item)) {
                nextItem = inventory.get(i);
                index = i;
            }
        }

        //Check if item is in inventory
        if (nextItem == null) {
            System.out.println(">It's not in your inventory");
        } else {
            //Check if item exists
            if (!(inventory.contains(nextItem))) {
                System.out.println(">There is no item named \"" + nextItem.getItemName() + "\" in your inventory.");
            } else {
                //Removes reuired item from inventory
                inventory.remove(index);
                getCurrentRoom().setItem(new Clue(getDescription(), item, true));  //Leaves the item with the description, name and property in room

                //Prints to console
                System.out.println("Dropped: " + item);
            }
        }
    }

    public void pickupItem(Command command) {

        if (inventory.size() == maxLimit) {
            System.out.println(">There is no more room in your inventory.");
        } else {
            if (!command.hasSecondWord()) {
                System.out.println(">Pick up what?");
                return;
            }
            String item = command.getSecondWord();

            Item nextItem = getCurrentRoom().getItem(item);

            if (nextItem == null) {
                System.out.println(">There is no item named that!");
                
            } else if (!nextItem.isPickupAble()) {
                System.out.println(">You can't pick up stuff like that.");
                
            } else {
                inventory.add((Clue)nextItem);
                getCurrentRoom().removeItem(item);
                
                System.out.println("Picked up:" + item); 
                
            }
        }
    }

    public void newName() {
        Scanner output = new Scanner(System.in);

        System.out.println(">What is your name?");

        String newName = output.next();

        this.name = newName;

    }

    @Override
    public void goRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

}
