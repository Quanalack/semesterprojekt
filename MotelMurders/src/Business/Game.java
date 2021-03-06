package Business;

import java.util.ArrayList;
import com.google.common.base.Stopwatch;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Game {

    private Parser parser;
    
    
    Stopwatch stopwatch = new Stopwatch().start(); // Starts the timer
    final int MAXTIME = 60;

    public int getMAXTIME() {
        return MAXTIME;
    }
    
    
    private boolean playerHasQuit; //Boolean to determine if player quits before game ends

    public boolean playerHasQuit() { //getter
        return playerHasQuit;
    }

    public void setPlayerQuits(boolean playerQuits) { //Setter
        this.playerHasQuit = playerQuits;
    }
    
    //Declaring rooms
    Room outside, lobby, room1, room2, room3, room4, WC, kitchen, basement, hallwayN, hallwayE, hallwayW;

    //The arraylist will hold the characters for our game
    ArrayList<NPC> characters = new ArrayList<>();

    //Holds the rooms for the game
    ArrayList<Room> rooms = new ArrayList<>();

    //Creating the main character
    MainCharacter player = new MainCharacter();
    
    /**
     * Game constructor instantiate the required objects at the beginning of 
     * the game.
     * 
     */
    public Game() {
        
        player.newName();
        addMagnifyingGlass();
        parser = new Parser();
        createRooms();
        createItems();
        createCharacters();
        
        
    }

    /**
     * Creates all NPC's in game and adds them to the character list.
     * Calls the method setMurderer()
     */
    private void createCharacters() {
        
        //Create objects of characters
        NPC janitor = new NPC("Carl", "\t>Carl is the janitor here. He repairs stuff", basement);
        NPC corpse = new NPC("Corpse", "\t>Yeahhh he dead. Very dead", room4);
        NPC receptionist = new NPC("Receptionist", "\t>He waits for you at the desk", lobby);
        NPC cleaningLady = new NPC("Cleaning lady", "\t>Walks around in the motel cleaning up. She is hard working but underpaid", lobby);
        NPC guest1 = new NPC("Ron", "\t>A man living in room 1", room1);
        NPC guest2 = new NPC("Leila", "\t>A woman currently living in room number 2", room2);
        NPC guest3 = new NPC("Brian", "\t>Some old person who lives down in room 3", room3);

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

    /**
     * Iterates through the characters and checks who the murderer is if any.
     * @return the name of the murderer if any is set or the string: 
     * "No murderer found".
     */
    public String getMurderer() {
        for (NPC character : characters) {
            if (character.isIsMurderer()) {
                return character.getName();
            }
        }
        return "No murderer found";
    }
    
    /**
     * Sets a random NPC as the murderer. Neither the corpse or the 
     * receptionist can be the murderer.
     */
    public void setMurderer() {

        int murderer;

        //Set one of them as murderer
        //do {

            // Set the murderer as a random int from 3 to the amount of characters (7)
            // + 2 because 
            murderer = new Random().nextInt(characters.size() + 2);

        //}
        /*
        Murderer cannot be 0 because number 0 is the janitor.
        Murderer cannot be 1 because number 1 is the corpse.
        Murderer cannot be 2 because number 2 is the receptionist.
        Murderer cannot be 3 because number 3 is the cleaning lady.
        */ 
        //while (murderer > 3);

        //Set the murderers boolean isMurderer to true
        characters.get(murderer).setIsMurderer(true);

        //Print for testing and debugging
        System.out.println(">The murderer is: " + characters.get(murderer).getName());
    }

    /**
     * Prints out all the NPC's who are in the same room as the player .
     */
    
    public void getCharacterString() {
        //String is empty as no has been confirmed in room yet
        String inRoom = "";

        System.out.println(">Characters in room:");
        
        //Iterate through characters
        for (int i = 0; i < characters.size(); i++) {

            //If player room is identical to npc's room
            if (player.getCurrentRoom().getRoomName().equals(characters.get(i).getCurrentRoom().getRoomName())) {

                //Add that characters name to the list.
                inRoom += characters.get(i).getName() + ", ";
            }
        }

        //If no one was found change string to "None"
        if (inRoom.equalsIgnoreCase("")) {
            inRoom = "None";
        }

        //Print out the list
        System.out.println(inRoom);
    }

    /**
     * Creates all the rooms in the game. 
     * Adds them to the list of rooms.
     * Add an investigate string to each rooms.
     * Set an exit for each room in order to connect them.
     */
    private void createRooms() {

        //Room descriptions when you arrive in a room
        //Assists the illusion of multiple items in the rooms
        outside = new Room("\n>The wind is blowing, you see the motels old facade infront of you.", "outside");
        lobby = new Room("\n>You see a receptionist and even a vending machine,"
                + " you also see hallways leading to various rooms both left, right and up.", "lobby");
        room1 = new Room("\n>It is filled with most needed interior like:"
                + " a bed, chair, table, vase, lamps and a window."
                + " Guest 1 sleeps here.", "room 1");
        room2 = new Room("\n>It is filled with most needed interior like:"
                + " a bed, chair, table, vase, lamps and a window."
                + " Guest 2 sleeps here.", "room 2");
        room3 = new Room("\n>It is filled with most needed interior like:"
                + " a bed, chair, table, vase, lamps and a window."
                + " Guest 3 sleeps here.", "room 3");
        room4 = new Room("\n>It is filled with most needed interior like:"
                + " a bed, chair, table, vase, lamps and a window."
                + " The victim used to sleep here, now he sleeps forever.", "room 4");
        WC = new Room("\n\t>There is an unpleasent stence in here!", "WC");
        kitchen = new Room("\n>Nothing much, here is a pleasant smell!", "kitchen");
        basement = new Room("\n>It is a bit dark but from a little light, "
                + "you can spot a workbench to you right and a big boiler in the back.", "basement");
        hallwayN = new Room("\n>The door to your left leads to the kitchen"
                + " and the door to the right leads to a WC, there seems to be steps further ahead.", "hallwayN");
        hallwayE = new Room("\n>The door to your left leads to the room 3"
                + " and the door to the right leads to room 4", "hallwayE");
        hallwayW = new Room("\n>The door to your left leads to the room 1"
                + " and the door to the right leads to room 2", "hallwayW");

        //Set the investigate string for each room. The string showing when user uses the investigate command
        //Assists the illusion of multiple items in the rooms
        outside.setInvestigateString("Fresh air outside. Nothing too suspicious. There's some potted plants and a sign that says \"OPEN\"");
        lobby.setInvestigateString("There are some paintings on the walls and some nice decorations throughout the room.\n"
                + "There's a receptionist. Maybe she can help.");
        room1.setInvestigateString("A guest is sitting on the bed in here. "
                + "Upon further inspection you find a knife in his luggage; it seems clean.");
        room2.setInvestigateString("A guest is in here. She seems in chock. "
                + "Upon further inspection you find nothing out of the ordinary, except a hammer on the table; it seems clean.");
        room3.setInvestigateString("A guest is sitting on the bed in here. "
                + "Upon further inspection you find a gun hidden in his briefcase; it has been fired recently.");
        room4.setInvestigateString("The victim is in here. It smells. You find a key, someone must have dropped it."); 
        WC.setInvestigateString("Very clean in here. Must be a cleaning lady somewhere");
        kitchen.setInvestigateString("The tap water is broken hope they have a janitor");
        basement.setInvestigateString("The janitor works here");
        hallwayN.setInvestigateString("There's a kitchen, WC and a basement");
        hallwayE.setInvestigateString("There are two rooms for the guests");
        hallwayW.setInvestigateString("There are two rooms for the guests");

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
        
        player.goRoom(outside);
    }
    
    /**
     * Creates all the items and adds them to their specific room.
     */
    private void createItems() {
        //Items in guest room 1
        room1.setItem(new Item("backpack",true));
        room1.setItem(new Item("toiletbag",true));
        room1.setItem(new Item("gun",true)); //should only be visible to the player after an investigation of the room


        //Items in guest room 2
        room2.setItem(new Item("chair",false));
        room2.setItem(new Item("lamp",false));
        room2.setItem(new Item("knife",true)); //should only be visible to the player after an investigation of the room
        

        //Items in guest room 3
        room3.setItem(new Item("chair",false));
        room3.setItem(new Item("lamp",false));
        room3.setItem(new Item("hammer",true)); //should only be visible to the player after an investigation of the room
        

        //Items in guest room 4
        room4.setItem(new Item("chair",false));
        room4.setItem(new Item("lamp",false));
        room4.setItem(new Item("key",true)); //should only be visible to the player after an investigation of the room
       
        
        //items in lobby
        lobby.setItem(new Item("chair",false));
        lobby.setItem(new Item("chair",false));
        lobby.setItem(new Item("lamp",false));
        lobby.setItem(new Item("sodacan",true));
        
       
        //items in basement
        basement.setItem(new Item("sledgehammer",true));
        basement.setItem(new Item("nailgun",true));
        basement.setItem(new Item("chainsaw",true)); 
        

        //items in WC
        WC.setItem(new Item("toiletpaper",true));
        WC.setItem(new Item("soap",true));        
                  
        //Items outside
        outside.setItem(new Item("stone",true));
        outside.setItem(new Item("flower",true));
        
        
}
    
    private final int maxLimit = 4; //Number of items in inventory including magnifying glass. Can only be assigned once

    //Our arraylist will hold the inventory items for our game
    ArrayList<Item> inventory = new ArrayList<>();

    /**
     * Get the inventory of player
     * @return An arraylist of the inventory
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * Set the players inventory
     * @param inventory the new inventory to be set
     */
    public void setInventory(ArrayList<Item> inventory) {
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
        inventory.add(new Item("Magnifying Glass",true));
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
            Item nextItem = player.getCurrentRoom().getItem(item);

            //Check if item exist
            if (nextItem == null) {
                System.out.println(">There is no item named that.");
                
            } else if (!nextItem.pickupAble == true) {
                System.out.println(">You can't pick up stuff like that!");
                
            } else {
                //add item to inventory and remove from room.
                inventory.add((Item)nextItem);
                player.getCurrentRoom().removeItem(item);
                
                System.out.println("Picked up: " + item); 
                
            }
        }
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

        //get the item name from second word
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
                player.getCurrentRoom().setItem(new Item(itemName, true));  //Leaves the item with the description, name and property in room

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
     * The main method of the game. Where the game starts.
     * Recieves input from user until game ends.
     * If user lose/win shows the murderer
     * If user chooses to end the game (Stops the game but hasn't lost or won)
     * save the game
     */
    public void play() {
        
        //Print the welcome message
        printWelcome();

        //Boolean to check if player has finished
        boolean finished = false;
        

        
        //While loop that runs until processCommand returns true;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        if (!playerHasQuit) {
            //Instance of business class in order to call non-static methods
            BusinessFacade businessFacade = new BusinessFacade();
            //Save Highscore
            businessFacade.saveHighscore();
            
        
            System.out.println(">The murderer was: " + getMurderer());
            System.out.println(">Thank you for playing. Goodbye.");
        } else {
            
            
            
        }
    }
    
/**
 * Creates the welcomelist an adds it to an arrayList.
 * @return the arraylist containing the welcome message.
 */
public ArrayList<String> getWelcomeMessage() {
    ArrayList<String> welcomeMessage = new ArrayList<>();
    welcomeMessage.add("===================== WELCOME =========================");
    welcomeMessage.add(">Hello there " + player.getName() + ". Welcome to Motel Murders");
    welcomeMessage.add(">You're a private detective");
    welcomeMessage.add(">You've been summoned to a murder in a motel");
    welcomeMessage.add(">The Motel has been evacuated");
    welcomeMessage.add(">Your task is to solve the murder");
    welcomeMessage.add(">Type '" + CommandWord.HELP + "' if you need help.");
    welcomeMessage.add("=======================================================");
    welcomeMessage.add(player.getCurrentRoom().getLongDescription());
    
    return welcomeMessage;
    
}
/**
 * Prints the welcome message out
 */
    public void printWelcome() {
        //Create copy of message
        ArrayList<String> welcomeMessage = getWelcomeMessage();
        
        //Iterate through the message
        for (String line : welcomeMessage) {
            System.out.println(line);
        }

    }

    /**
     * Handles user commands through a switch.
     * @param command the user command created through the parser
     * @return boolean which tells whether the game should end or not.
     */
    public boolean processCommand(Command command) {
        
        boolean endGame = false;
        
        // Time before game ends in seconds. Currently set to 1000 approx. 17 min
        if (stopwatch.elapsedTime(TimeUnit.SECONDS) >= MAXTIME) { 
            endGame = true;
            System.out.println("!! TIME'S UP !! \n>Before you could finish "
            + "your work, the cops took over and you got kicked out of the crime scene.");
        }

        //Getting the commandWord from the user 
        CommandWord commandWord = command.getCommandWord();
        
        //If commandword isn't null handle it.
        if (commandWord != null) switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                return false;
            case HELP:
                getHelp();
                break;
            case GO:
                //Goto another room
                goRoom(command);
                //Print the characters in new room
                getCharacterString();
                //15 % chance of moving cleaning Lady
                if (Math.random() <= 0.15) {
                    moveCleaningLady();
                }   break;
            case QUIT:
                //Quits game
                playerHasQuit = true;
                endGame = true;
                break;
            case INVENTORY:
                //Print out the content of the inventory
                printInventory();
                break;
            case PICKUP:
                //Pick up an item from a room
                pickupItem(command);
                break;
            case ACCUSE:
                //Call accuse method to accuse a character of being the murderer
                endGame = accuse(command);
                break;
            case INVESTIGATE:
                //Call investigate to investigate an item in a room if 
                
                investigate();
                break;
            case DROP:
                //Drop an item fom inventory
                dropItem(command);
                break;
            case TALK:
                //Talk to a character in current room
                dialog(command);
                break;
            case SAVE:
                
                break;
            default:
                break;
        }
        return endGame;
    }

    /**
     * Gets the time elapsed from the beginning of the game untill called
     * @return amount of time elapsed in seconds.
     */
    public double getCurrentTime(){
        return stopwatch.elapsedTime(TimeUnit.SECONDS);
    }

    /**
     * Prints out the help text and show the commands
     */
    private void getHelp() {
        ArrayList<String> help = new ArrayList<>();
        ArrayList<String> commandWords = parser.getCommands();
        
        help.add("===================================================");
        help.add(">Hello " + player.getName() + ".You are a detective trying to solve a murder.");
        help.add("");
        help.add(">Hello " + player.getName() + 
        ". You are a detective trying to solve a murder.");
        help.add(">Hello " + player.getName() + 
        ". You are a detective trying to solve a murder.");
        help.add(">Go from room to room to investigate and talk with the suspects.");
        help.add(">Your command words are: ");
        
        //Get all commands on 1 line string
        String commands = "";
        for (String command : commandWords) {
            commands += command + " ";
        }
        
        //Add all commands to help list
        help.add(commands);
        help.add("===================================================");
        
    }

    /**
     * Changes the currentRoom of the player according to a command
     * @param command user command created through parser
     */ 
    private void goRoom(Command command) {
        
        //Checks if command has two words
        if (!command.hasSecondWord()) {
            System.out.println(">Go where?");
            return;
        }

        //Get the direction from user
        String direction = command.getSecondWord();

        //Get the next room via currentroom and direction
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        //Checks if the room has a door at the specified direction 
        if (nextRoom == null) {
            System.out.println(">There is no door!");
        }
        if (nextRoom == basement) {
            if (inventory.contains("key")) {
                //Change room
                player.goRoom(nextRoom);
                System.out.println(player.getCurrentRoom().getLongDescription());
            } else {
                System.out.println("\n>The door is locked. You remain in the hallway");
            }
        }
        else { 
            //Change room
                player.goRoom(nextRoom);
                System.out.println(player.getCurrentRoom().getLongDescription());
        }
    }

    /**
     * Handles the commands involving the dialog with the NPC's
     * @param command user command created through parser
     */
        private void dialog(Command command) {

        if (!command.hasSecondWord()) {
            System.out.println(">Talk to who?");
            return;
        }

        //Name of the character
        String name = command.getSecondWord();

        //Check if character exists
        boolean characterExists = false; //Character has not been found yet

        for (int i = 0; i < characters.size(); i++) {
            if (name.equalsIgnoreCase(characters.get(i).getName())) {
                characterExists = true;
                
            if (name.equalsIgnoreCase("cleaning")) {
                characterExists = true;
                //set the talked to character equal to the cleaning lady's name
                name = characters.get(3).getName();
            }
                
            if (characterExists){
                    Dialog dialog = new Dialog();
                    dialog.startDialog(i);
                
                } else {
                    System.out.println(">That person isn't even here!");
                }
            }
        }
    }
    
    /**
     * Method to accuse a character
     * @param command user command created through parser.
     * @return whether or not the game should end.
     */
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
            In this case it's "cleaning".
            */
            if (accusedCharacter.equalsIgnoreCase("cleaning")) {
                accusedExists = true;
                //set the accused character equal to the cleaning lady's name
                accusedCharacter = characters.get(3).getName();
            }
            
        }
        
        //Continue if accused exists
        if (accusedExists) {
            
        //Boolean to determine whether or not the correct person is accused
        boolean isMurdererFound = false; 
        
            //For loop to check if the murderer has been found
            for (NPC character : characters) {
                
                //If the accused characters name mathes and that characters IsMurderer is true
                if (accusedCharacter.equalsIgnoreCase(character.getName()) && character.isIsMurderer()) {
                    
                //Player found the murderer
                System.out.println("You found the murderer!");
        
                isMurdererFound = true;
        
                }
            }
            
            //Player guessed wrong and looses the game
            if (!isMurdererFound) {
                System.out.println(">Not the murderer! You lost!");
            }
        
            return  true; // Once you have successfully accused a person the game ends. You either win or lose
            
        } else {
            
            //The accused could not be found in the characters
            System.out.println(">The accused person does not exist");
            return false; //Returns false because no one was accused
        }
            
        } else {
            System.out.println(">Accuse who?");
            return false; //Returns false because no one was accused
        }
    }

    /**
     * Allows the player to further investigate a room.
     * Print out the investigateString of the current room
     */
    private void investigate() {

        //Print out investigation string for the current room
        System.out.println(player.getCurrentRoom().getInvestigateString());

    }

    /**
     * Moves the cleaning lady to a random room
     */
    private void moveCleaningLady() {

        //Declaring cleaningLady
        NPC cleaningLady = characters.get(3);

        //Get a random room out of all possible rooms
        Room randomRoom = rooms.get(0 + (int) (Math.random() * rooms.size()));        
       

        //Move to the random room
        cleaningLady.goRoom(randomRoom);

        //Print to player the location of her now
        System.out.println("The cleaning lady is in room: " + cleaningLady.getCurrentRoom().getRoomName());
    }
}
