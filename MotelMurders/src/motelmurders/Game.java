package motelmurders;

import java.util.ArrayList;
import com.google.common.base.Stopwatch;
//import java.awt.Dialog; <---- Unused library 
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.BufferedWriter; <---- Unused library 
import java.io.FileWriter;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    private Parser parser;
    private Room currentRoom;
    private final int maxLimit = 4; //Number of items in inventory including magnifying glass. Can only be assigned once
    
    Stopwatch stopwatch = new Stopwatch().start(); // Starts the timer
    
    final long SCORE_MULTIPLIER = 1234; //Random multiplier to "encrypt" score
    
    private boolean playerHasQuitted; //Boolean to determine if player quits before game ends

    public boolean playerHasQuitted() { //getter
        return playerHasQuitted;
    }

    public void setPlayerQuits(boolean playerQuits) { //Setter
        this.playerHasQuitted = playerQuits;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    //Existing rooms 
    Room outside, lobby, room1, room2, room3, room4, WC, kitchen, basement, hallwayN, hallwayE, hallwayW;

    //Our arraylist will hold the inventory items for our game
    ArrayList<Item> inventory = new ArrayList<>();

    //The arraylist will hold the characters for our game
    ArrayList<Character> characters = new ArrayList<>();

    //Holds the rooms for the game
    ArrayList<Room> rooms = new ArrayList<>();

    public Game() {
        parser = new Parser();
        createRooms();
        createCharacters();
    }

    private void createCharacters() {
        //Create objects of characters
        Character janitor = new Character("Carl", "Carl is the janitor here. He repairs stuff", basement);
        Character corpse = new Character("Corpse", "Yeahhh he dead. Very dead", room4);
        Character receptionist = new Character("Receptionist", "He waits for you at the desk", lobby);
        Character cleaningLady = new Character("Cleaning lady", "Walks around in the motel cleaning up. She is hard working but underpaid", lobby);
        Character guest1 = new Character("Ron", "A man", room1);
        Character guest2 = new Character("Leila", "A woman", room2);
        Character guest3 = new Character("Brian", "Some old person", room3);

        //Add to character arraylist
        characters.add(janitor);
        characters.add(corpse);
        characters.add(receptionist);
        characters.add(cleaningLady);
        characters.add(guest1);
        characters.add(guest2);
        characters.add(guest3);
        
        //Set a murderer
        setMurderer();

    }
    
    public String getMurderer() {
        for (Character character : characters) {
            if (character.getIsMurderer() == true) {
                return character.getName();
            }
        }
        return "Murderer not found";
    }
    
    public void setMurderer () {
        
        int murderer;
        
        //Set one of them as murderer
        do {
             murderer = 0 + (int) (Math.random() * characters.size()); // Random int from 0 to the amount of characters
        }
        while (murderer != 1 && murderer < 0);  //Murderer cannot be 1 because number 1 is the corpse
           
        //Set the murderers boolean isMurderer to true
        characters.get(murderer).setIsMurderer(true);
        
        //Print for testing and debugging
        System.out.println("The murderer is: " + characters.get(murderer).getName());
    }

    public void getCharacterString() {
        String inRoom = "";

        System.out.println("Characters in room:");
        for (int i = 0; i < characters.size(); i++) {

            if (currentRoom.getRoomName().equals(characters.get(i).getCurrentRoom().getRoomName())) {

                inRoom += characters.get(i).getName() + ", ";
            }
        }

        if (inRoom.equalsIgnoreCase("")) {
            inRoom = "None";
        }

        System.out.println(inRoom);
    }

    private void createRooms() {

        //Room descriptions when you arrive in a room
        outside = new Room("\nThe wind is blowing, you see the motels old facade infront of you.", "outside");
        lobby = new Room("\nYou see a receptionist and even a vending machine,"
                + " you also see hallways leading to various rooms both left, right and up.", "lobby");
        room1 = new Room("\nIt is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 1 sleeps here.", "room1");
        room2 = new Room("\nIt is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 2 sleeps here.", "room2");
        room3 = new Room("\nIt is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 3 sleeps here.", "room3");
        room4 = new Room("\nIt is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " The victim used to sleep here, now he sleeps forever.", "room4");
        WC = new Room("\nThere is an unpleasent stence in here!", "WC");
        kitchen = new Room("\nNothing much, here is a pleasant smell!", "kitchen");
        basement = new Room("\nIt is a bit dark but from a little light, "
                + "you can spot a workbench to you right and a big boiler in the back.", "basement");
        hallwayN = new Room("\nThe door to your left leads to the kitchen"
                + " and the door to the right leads to a WC, there seems to be steps further ahead.", "hallwayN");
        hallwayE = new Room("\nThe door to your left leads to the room 3"
                + " and the door to the right leads to room 4", "hallwayE");
        hallwayW = new Room("\nThe door to your left leads to the room 1"
                + " and the door to the right leads to room 2", "hallwayW");

        //Set the investigate string for each room. The string showing when user uses the investigate command
        outside.setInvestigateString("Nothing here. Btw I'm blind");
        lobby.setInvestigateString("Nothing here. Btw I'm blind");
        room1.setInvestigateString("Nothing here. Btw I'm blind");
        room2.setInvestigateString("Nothing here. Btw I'm blind");
        room3.setInvestigateString("Nothing here. Btw I'm blind");
        room4.setInvestigateString("Nothing here. Btw I'm blind");
        WC.setInvestigateString("Nothing here. Btw I'm blind");
        kitchen.setInvestigateString("Nothing here. Btw I'm blind");
        basement.setInvestigateString("Nothing here. Btw I'm blind");
        hallwayN.setInvestigateString("Nothing here. Btw I'm blind");
        hallwayE.setInvestigateString("Nothing here. Btw I'm blind");
        hallwayW.setInvestigateString("Nothing here. Btw I'm blind");

        //Add rooms to list
        rooms.add(outside);
        rooms.add(lobby);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(WC);
        rooms.add(kitchen);
        rooms.add(basement);
        rooms.add(hallwayN);
        rooms.add(hallwayE);
        rooms.add(hallwayW);

        //Move set in all rooms
        outside.setExit("up", lobby);

        lobby.setExit("right", hallwayE);
        lobby.setExit("left", hallwayW);
        lobby.setExit("back", outside);
        lobby.setExit("up", hallwayN);

        hallwayE.setExit("right", room4);
        hallwayE.setExit("left", room3);
        hallwayE.setExit("back", lobby);

        //Walk directly from the room to the toilet located in the north section of the motel
        hallwayW.setExit("right", room2);
        hallwayW.setExit("left", room1);
        hallwayW.setExit("back", lobby);

        hallwayN.setExit("right", WC);
        hallwayN.setExit("left", kitchen);
        hallwayN.setExit("up", basement);
        hallwayN.setExit("back", lobby);

        basement.setExit("back", hallwayN);

        kitchen.setExit("back", hallwayN);

        WC.setExit("back", hallwayN);

        room1.setExit("back", hallwayW);

        room2.setExit("back", hallwayW);

        room3.setExit("back", hallwayE);

        room4.setExit("back", hallwayE);

        //east and west should maybe be right + left
        inventory.add(new Item("Magnifying Glass"));

        room1.setItem(new Item("chair"));
        room1.setItem(new Item("lamp"));
        room2.setItem(new Item("chair"));
        room2.setItem(new Item("lamp"));
        room3.setItem(new Item("chair"));
        room3.setItem(new Item("lamp"));
        room4.setItem(new Item("chair"));
        room4.setItem(new Item("lamp"));

        outside.setItem(new Item("stone"));

        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        if (!playerHasQuitted) {
            
            //Saves the score and prints it to console
            String path = "score.xml";
            saveGame(path);
        
            System.out.println("The murderer was: " + getMurderer());
            System.out.println("Thank you for playing. Goodbye.");
        }
    }
    
    private void writeScore(int score, String path){
        String filename = path; //Name of the file
        
        try(FileWriter fw = new FileWriter(filename, true); //True means to append/add to existing. Not overwrite
                PrintWriter out = new PrintWriter(fw)) //
        {
                out.println(score);
                
        } catch (IOException e) {
            }
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Motel Murder");
        System.out.println("You're private detective Jack Crawford");
        System.out.println("You've been summoned to a murder in a motel");
        System.out.println("The Motel has been evacuated");
        System.out.println("Your task is to solve the murder");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        
        boolean wantToQuit = false;
        
        if (stopwatch.elapsedMillis()/1000 >= 10000) { // Time before game ends in seconds. Curerntly set to 10000 = approximately 2 hr and 45 min
            wantToQuit = true;
            System.out.println("Time's up!");
        }

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
            getCharacterString();

            //15 % chance of moving cleaning Lady
            if (Math.random() <= 1) {
            moveCleaningLady();
            }
            
        } else if (commandWord == CommandWord.QUIT) {
            //Quits game
            playerHasQuitted = true;
            wantToQuit = true;
            
        } else if (commandWord == commandWord.INVENTORY) {
            //Print out the content of the inventory
            printInventory();
        } else if (commandWord == commandWord.PICKUP) {
            //Pick up an item from a room
            pickupItem(command);

        } else if (commandWord == commandWord.ACCUSE) {
            //Call accuse method to accuse a character of being the murderer
            wantToQuit = accuse(command);
        } else if (commandWord == commandWord.INVESTIGATE) {
            //Call investigate to investigate an item in a room
            investigate();
        } else if (commandWord == commandWord.DROP) {
            //Drop an item fom inventory
            dropItem(command);
        } else if (commandWord == commandWord.TALK) {
            dialog(command);
        } else if (commandWord == commandWord.SAVE) {
            String path = "save.xml";
            saveGame(path);
        }
        return wantToQuit;
    }

    private void pickupItem(Command command) {

        if (inventory.size() == maxLimit) {
            System.out.println("There is no more room in your inventory.");
        } else {
            if (!command.hasSecondWord()) {
                System.out.println("Pick up what?");
                return;
            }

            String item = command.getSecondWord();

            Item nextItem = currentRoom.getItem(item);

            if (nextItem == null) {
                System.out.println("There is no item named that!");

            } else {
                inventory.add(nextItem);
                currentRoom.removeItem(item);

                System.out.println("Picked up:" + item);

            }
        }
    }
    
    private void saveGame(String path){
        long seconds = stopwatch.elapsedMillis()/1000;

        int score = (int)(seconds * SCORE_MULTIPLIER);
        
        writeScore(score, path);
        
        System.out.println("You finished the game in " + seconds + " seconds.");
        System.out.println("You scored " + score + " points!");
        
        }
    
    private void dropItem(Command command) {
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
                currentRoom.setItem(new Item(item));
                
                //Prints to console
                System.out.println("Dropped: " + item);
            }
        }
    }

    //Method to print players current inventory
    private void printInventory() {
        String output = ""; //Empty string to output
        System.out.println("You're currently carrying:");
        
        //Iterate through the inventory and add to string
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getDescription() + ",  ";
        }
        //Print the generated string
        System.out.println(output);
    }

    //Method to show the help text to user
    private void printHelp() {
        System.out.println("You are a detective trying to solve a murder.");
        System.out.println("Go from room to room to investigate and talk with the suspects.");
        System.out.println();
        System.out.println("Your command words are:");
        
        //Shows all the possible commands
        parser.showCommands();
    }

    //Method to go to a new room
    private void goRoom(Command command) {
        
        if (!command.hasSecondWord()) { // Is this necessary?? Discuss later. Does goRoom interact with user input??
            System.out.println("Go where?");
            return;
        }

        //Get the direction from user
        String direction = command.getSecondWord();

        //Get the next room via currentroom and direction
        Room nextRoom = currentRoom.getExit(direction);

        //Checks if the room has a door at the specified direction 
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            //Change room
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    
    private void dialog(Command command) {    
    
        if (!command.hasSecondWord()) {
            System.out.println("Talk to who?");
            return;
        }

        //Name of the character
        String nextCharacter = command.getSecondWord();
        
        //Check if character exists
        boolean characterExists = false; //Character has not been found yet
        
        for (int i = 0; i < characters.size(); i++) {
            if (nextCharacter.equalsIgnoreCase(characters.get(i).getName())) {
            //Name has been found in characters
            characterExists = true;
            }
        /*
        
        //Check if character exists
        if (nextCharacter == null) {
            System.out.println("There is no here one named that!");
            return;

        } else if (name.equalsIgnoreCase("receptionist")) {
            int dialog = startDialog(1);
            
        } else if (name.equalsIgnoreCase("janitor")) {
            int dialog = startDialog(2);
         */   
        }
    }  
    
    private boolean accuse(Command command) {
        
        //Check if user input has a word after "accuse"
        if (command.hasSecondWord()) {
            
            String accusedCharacter = command.getSecondWord();
        
        //Checks if the accused character exists through a loop
        
        boolean accusedExists = false; //Accused has not been found yet
        
        for (int i = 0; i < characters.size(); i++) {
            if (accusedCharacter.equalsIgnoreCase(characters.get(i).getName())) {
            //Name has been found in characters
            accusedExists = true;
            }
            
            /*
            The character Cleaning lady contains two words meaning that if a user types in
            "accuse cleaning lady". The parser will only look for the word after accuse.
            In this case it's cleaning.
            */
            if (accusedCharacter.equalsIgnoreCase("cleaning")) {
                accusedExists = true;
                //set the accused character equal to the cleaning lady's name
                accusedCharacter = characters.get(3).getName();
            }
            
        }
        
        if (accusedExists) {
            
        //Boolean to determine wheter or not the corrct person is accused
        boolean isMurdererFound = false; //False as default
        
            //For loop to check if the murderer has been found
            for (int i = 0; i < characters.size(); i++) {
                
                //If the accused characters name mathes and that characters IsMurderer is true
                if (accusedCharacter.equalsIgnoreCase(characters.get(i).getName()) && characters.get(i).getIsMurderer()) {
                    
                //Player found the murderer
                System.out.println("You found the murderer!");
        
                isMurdererFound = true;
        
                }
            }
            
            //Player guessed wrong and looses the game
            if (!isMurdererFound) {
                System.out.println("Not the murderer! You lost!");
            }
        
            return  true; // Once you have successfully accused a person the game ends. You either win or lose
            
        } else {
            
            //The accused could not be found in the characters
            System.out.println("The accused person does not exist");
            return false; //Returns false because there was an error from the players side
        }
            
        } else {
            System.out.println("Accuse who?");
            return false; //Returns false because there was an error from the players side
        }
    }

    //Method to further investigate a room
    private void investigate() {

        //Print out investigation string for the current room
        System.out.println(currentRoom.getInvestigateString());

    }

    //Method for moving the cleaning lady to a random room
    private void moveCleaningLady() {

        //Declaring cleaningLady character object 
        Character cleaningLady = characters.get(3);

        //Get a random room out of ALL POSSIBLE rooms
        //Room randomRoom = rooms.get(0 + (int) (Math.random() * rooms.size()));        
        
        //Test starts here
        Room oldRoom = cleaningLady.getCurrentRoom();
        
        Room neighborRoom0 = currentRoom.getExit("up");
        Room neighborRoom1 = currentRoom.getExit("back");
        Room neighborRoom2 = currentRoom.getExit("left");
        Room neighborRoom3 = currentRoom.getExit("right");
        
        while(cleaningLady.getCurrentRoom() != oldRoom && rooms.contains(cleaningLady.getCurrentRoom())) {
            int randomNeighbor = (int)(0 + Math.random() * 3); //Random integer from 0 to 3
        
            System.out.println(randomNeighbor);
            
            switch (randomNeighbor) {
                case 0:
                cleaningLady.setCurrentRoom(neighborRoom0);
                    break;
                case 1:
                    cleaningLady.setCurrentRoom(neighborRoom1);
                    break;
                case 2:
                    cleaningLady.setCurrentRoom(neighborRoom2);
                    break;
                case 3:
                    cleaningLady.setCurrentRoom(neighborRoom3);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        //Test ends here

        //Move to the random room
        //CleaningLady.setCurrentRoom(randomRoom);

        //Print to player the location of her now
        System.out.println("The cleaning lady is in room: " + cleaningLady.getCurrentRoom().getRoomName());
    }

}
