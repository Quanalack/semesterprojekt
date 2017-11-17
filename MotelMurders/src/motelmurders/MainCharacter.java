/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motelmurders;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author malte
 */
public class MainCharacter implements Person{
    
    private final int maxLimit = 4; //Number of items in inventory including magnifying glass. Can only be assigned once
    
    //Our arraylist will hold the inventory items for our game
    ArrayList<Item> inventory = new ArrayList<>();
    
    private String name; //Name of the player
    private Room currentRoom;
    private String description;

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }
    
        //Method to print players current inventory
    public void printInventory() {
        String output = ""; //Empty string to output
        System.out.println("You're currently carrying:");
        
        //Iterate through the inventory and add to string
        for (int i = 0; i < this.inventory.size(); i++) {
            output += this.inventory.get(i).getDescription() + ",  ";
        }
        //Print the generated string
        System.out.println(output);
    }
    
    private void addMagnifyingGlass() {
        
    inventory.add(new Item("Magnifying Glass"));
}
    
        public void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String item = command.getSecondWord();

        if (item.equalsIgnoreCase("magnifying glass")) {
            System.out.println("You cannot drop your magnifying glass! You need it!");
            return;
        }

        Item nextItem = null;
        int index = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getDescription().equalsIgnoreCase(item)) {
                nextItem = inventory.get(i);
                index = i;
            }

        }

        //Check if item is in inventory
        if (nextItem == null) {
            System.out.println("It's not in your inventory");
        } else {
            //Check if item exists
            if (!(inventory.contains(nextItem))) {
                System.out.println("There is no item named: " + nextItem.getDescription());
            } else { 
                //Removes reuired irem from inventory
                inventory.remove(index);
                getCurrentRoom().setItem(new Item(item));
                
                //Prints to console
                System.out.println("Dropped: " + item);
            }
        }
    }
        
        public void pickupItem(Command command) {

        if (inventory.size() == maxLimit) {
            System.out.println("There is no more room in your inventory.");
        } else {
            if (!command.hasSecondWord()) {
                System.out.println("Pick up what?");
                return;
            }

            String item = command.getSecondWord();

            Item nextItem = getCurrentRoom().getItem(item);

            if (nextItem == null) {
                System.out.println("There is no item named that!");

            } else {
                inventory.add(nextItem);
                getCurrentRoom().removeItem(item);

                System.out.println("Picked up:" + item);

            }
        }
    }
        
        public String getNameFromInput() {
        Scanner output = new Scanner(System.in);
        
        System.out.println("What is your name?");
        
        return output.toString();

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
    public void setName(String newName) {
        this.name = newName;
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
