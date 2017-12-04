package Business;

import java.util.ArrayList;
import com.google.common.base.Stopwatch;
import java.util.Collection;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    private Parser parser;

    Stopwatch stopwatch = new Stopwatch().start(); // Starts the timer
    final int MAXTIME = 60;

    public int getMAXTIME() {
        return MAXTIME;
    }

    private boolean playerHasQuitted; //Boolean to determine if player quits before game ends

    public boolean playerHasQuitted() { //getter
        return playerHasQuitted;
    }

    public void setPlayerQuits(boolean playerQuits) { //Setter
        this.playerHasQuitted = playerQuits;
    }

    //Existing rooms 
    Room outside, lobby, room1, room2, room3, room4, WC, kitchen, basement, hallwayN, hallwayE, hallwayW;

    //The arraylist will hold the characters for our game
    ArrayList<NPC> characters = new ArrayList<>();

    //Holds the rooms for the game
    ArrayList<Room> rooms = new ArrayList<>();

    //Creating the main character
    MainCharacter player = new MainCharacter();

    public Game() {

        player.newName();
        player.addMagnifyingGlass();
        parser = new Parser();
        createRooms();
        createCharacters();

    }

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

    public String getMurderer() {
        for (NPC character : characters) {
            if (character.isIsMurderer()) {
                return character.getName();
            }
        }
        return "Murderer not found";
    }
    
    public void setMurderer() {
        

    public void setMurderer() {

        int murderer;

        //Set one of them as murderer
        do {
             murderer = 0 + (int) (Math.random() * characters.size()); // Random int from 0 to the amount of characters
        }
        while (murderer != 1 && murderer != 3 && murderer < 0);  //Murderer cannot be 1 because number 1 is the corpse
           
            murderer = 0 + (int) (Math.random() * characters.size()); // Random int from 0 to the amount of characters
        } while (murderer != 1 && murderer < 0);  //Murderer cannot be 1 because number 1 is the corpse

        //Set the murderers boolean isMurderer to true
        characters.get(murderer).setIsMurderer(true);

        //Print for testing and debugging
        System.out.println(">The murderer is: " + characters.get(murderer).getName());
    }

    public void getCharacterString() {
        String inRoom = "";

        System.out.println(">Characters in room:");
        for (int i = 0; i < characters.size(); i++) {

            if (player.getCurrentRoom().getRoomName().equals(characters.get(i).getCurrentRoom().getRoomName())) {

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
        outside = new Room("\n>The wind is blowing, you see the motels old facade infront of you.", "outside");
        lobby = new Room("\n>You see a receptionist and even a vending machine,"
                + " you also see hallways leading to various rooms both left, right and up.", "lobby");
        room1 = new Room("\n>It is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 1 sleeps here.", "room1");
        room2 = new Room("\n>It is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 2 sleeps here.", "room2");
        room3 = new Room("\n>It is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 3 sleeps here.", "room3");
        room4 = new Room("\n>It is filled with most needed interior like:"
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " The victim used to sleep here, now he sleeps forever.", "room4");
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

        room1.setItem(new Item("chair"));
        room1.setItem(new Item("lamp"));
        room2.setItem(new Item("chair"));
        room2.setItem(new Item("lamp"));
        room3.setItem(new Item("chair"));
        room3.setItem(new Item("lamp"));
        room4.setItem(new Item("chair"));
        room4.setItem(new Item("lamp"));

        outside.setItem(new Item("stone"));

        player.goRoom(outside);
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        if (!playerHasQuitted) {

            //saveHighscore();
            System.out.println(">The murderer was: " + getMurderer());
            System.out.println(">Thank you for playing. Goodbye.");
        } else {
            //Gem spil
        }
    }
<<<<<<< HEAD
    
public ArrayList<String> getWelcomeMessage() {
    ArrayList<String> welcomeMessage = new ArrayList<>();
    welcomeMessage.add("===================== WELCOME =========================");
    welcomeMessage.add(">Hello there " + player.getName() + ". Welcome to Motel Murders");
    welcomeMessage.add(">You're a private detective");
    welcomeMessage.add(">You've been summoned to a murder in a motel");
    welcomeMessage.add(">The Motel has been evacuated");
    welcomeMessage.add(">Your task is to solve the murder");
    welcomeMessage.add(">Type '" + CommandWord.HELP + "' if you need help.");
    
    return welcomeMessage;
    
}

    public void printWelcome() {
=======

    private void printWelcome() {
>>>>>>> a5f11d82958c0aadd8be5a1ea87e87148b88d73c
        System.out.println("===================== WELCOME =========================");
        System.out.println(">Hello there " + player.getName() + ". Welcome to Motel Murders");
        System.out.println(">You're a private detective");
        System.out.println(">You've been summoned to a murder in a motel");
        System.out.println(">The Motel has been evacuated");
        System.out.println(">Your task is to solve the murder");
        System.out.println(">Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("");
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

    public boolean processCommand(Command command) {

        boolean wantToQuit = false;

        if (stopwatch.elapsedMillis() / 1000 >= MAXTIME) { // Time before game ends in seconds. Curerntly set to 10000 = approximately 2 hr and 45 min
            wantToQuit = true;
            System.out.println(">Time's up!");
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
            player.printInventory();
        } else if (commandWord == commandWord.PICKUP) {
            //Pick up an item from a room

            player.pickupItem(command);

        } else if (commandWord == commandWord.ACCUSE) {
            //Call accuse method to accuse a character of being the murderer
            wantToQuit = accuse(command);
        } else if (commandWord == commandWord.INVESTIGATE) {
            //Call investigate to investigate an item in a room
            investigate();
        } else if (commandWord == commandWord.DROP) {
            //Drop an item fom inventory
            player.dropItem(command);
        } else if (commandWord == commandWord.TALK) {
            //Talk to a character in current room
            dialog(command);
        } else if (commandWord == commandWord.SAVE) {
            //saveGame();
        }
        return wantToQuit;
    }

    public double getCurrentTime() {
        return stopwatch.elapsedMillis() / 1000;
    }

    //Method to show the help text to user
    private void printHelp() {
        System.out.println(">Hello " + player.getName() + ".You are a detective trying to solve a murder.");
        System.out.println(">Go from room to room to investigate and talk with the suspects.");
        System.out.println();
        System.out.println(">Your command words are:");

        //Shows all the possible commands
        parser.showCommands();
    }

    //Method to go to a new room
    private void goRoom(Command command) {

        if (!command.hasSecondWord()) { // Is this necessary?? Discuss later. Does goRoom interact with user input??
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
        } else {
            //Change room
            player.goRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
    }

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

                if (name.equalsIgnoreCase("cleaning")) { //Cleaning Lady contains two names but the tokenizer only seraches for one word
                    characterExists = true;
                    //set the accused character equal to the cleaning lady's name
                    name = characters.get(3).getName();
                }

                if (characterExists) {
                    Dialog dialog = new Dialog();
                    dialog.startDialog(i);

                } else {
                    System.out.println(">That person isn't even here!");
                }
            } 
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

                //Boolean to determine whether or not the corrct person is accused
                boolean isMurdererFound = false; //False as default

                //For loop to check if the murderer has been found
                for (int i = 0; i < characters.size(); i++) {

                    //If the accused characters name mathes and that characters IsMurderer is true
                    if (accusedCharacter.equalsIgnoreCase(characters.get(i).getName()) && characters.get(i).isIsMurderer()) {

                        //Player found the murderer
                        System.out.println("You found the murderer!");

                        isMurdererFound = true;

                    }
                }

                //Player guessed wrong and looses the game
                if (!isMurdererFound) {
                    System.out.println(">Not the murderer! You lost!");
                }

                return true; // Once you have successfully accused a person the game ends. You either win or lose

            } else {

                //The accused could not be found in the characters
                System.out.println(">The accused person does not exist");
                return false; //Returns false because there was an error from the players side
            }

        } else {
            System.out.println(">Accuse who?");
            return false; //Returns false because there was an error from the players side
        }
    }

    //Method to further investigate a room
    private void investigate() {

        //Print out investigation string for the current room
        System.out.println(player.getCurrentRoom().getInvestigateString());

    }

    //Method for moving the cleaning lady to a random room
    private void moveCleaningLady() {

        //Declaring cleaningLady character object 
        NPC cleaningLady = characters.get(3);

        //Get a random room out of ALL POSSIBLE rooms
        //Room randomRoom = rooms.get(0 + (int) (Math.random() * rooms.size()));        
        //Test starts here
        Room oldRoom = cleaningLady.getCurrentRoom();

        Room neighborRoom0 = player.getCurrentRoom().getExit("up");
        Room neighborRoom1 = player.getCurrentRoom().getExit("back");
        Room neighborRoom2 = player.getCurrentRoom().getExit("left");
        Room neighborRoom3 = player.getCurrentRoom().getExit("right");

        while (cleaningLady.getCurrentRoom() != oldRoom && rooms.contains(cleaningLady.getCurrentRoom())) {
            int randomNeighbor = (int) (0 + Math.random() * 3); //Random integer from 0 to 3

            System.out.println(randomNeighbor);

            switch (randomNeighbor) {
                case 0:
                    cleaningLady.goRoom(neighborRoom0);
                    break;
                case 1:
                    cleaningLady.goRoom(neighborRoom1);
                    break;
                case 2:
                    cleaningLady.goRoom(neighborRoom2);
                    break;
                case 3:
                    cleaningLady.goRoom(neighborRoom3);
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
