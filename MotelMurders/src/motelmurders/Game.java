package motelmurders;

import java.util.ArrayList;
import com.google.common.base.Stopwatch;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game {

    private Parser parser;
    private Room currentRoom;
    private final int maxLimit = 4; //Number of items in inventory including magnifying glass. Can only be assigned once
    
    Stopwatch stopwatch = new Stopwatch().start(); // Starts the timer

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    Room outside, lobby, room1, room2, room3, room4, WC, kitchen, basement, hallwayN, hallwayE, hallwayW;

    //Our arraylist will hold the inventory items for our game
    ArrayList<Item> inventory = new ArrayList<>();

    //The arraylist will hold the characters for our game
    ArrayList<Character> characters = new ArrayList<>();

    //Holds the rooms for the game
    ArrayList<Room> rooms = new ArrayList<>();

    public Game() {
        createRooms();
        parser = new Parser();
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

        //Set one of them as murderer
        int murderer = -1;

        while (murderer != 1 && murderer < 0) {
            murderer = 0 + (int) (Math.random() * characters.size()); // Random int from 0 to the amount of characters
        }

        //Set the murderes boolean isMurderer to true
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
        long seconds = stopwatch.elapsedMillis()/1000;
        System.out.println("You finished the game in " + seconds + " seconds.");
        System.out.println("Thank you for playing. Goodbye.");
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
        
        if (stopwatch.elapsedMillis()/1000 >= 10) {
            wantToQuit = true;
            System.out.println("Times up! Noob.");
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
            if (Math.random() <= 0.25) {
                moveCleaningLady();
            }
        } else if (commandWord == CommandWord.QUIT) {
            //Method to quit game
            wantToQuit = quit(command);
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
//        } else if (commandWord == commandWord.TALK) {
//            dialog(command);
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

        if (nextItem == null) {
            System.out.println("It's not in your inventory");
        } else {
            if (!(inventory.contains(nextItem))) {
                System.out.println("There is no item named: " + nextItem.getDescription());
            } else {
                inventory.remove(index);
                currentRoom.setItem(new Item(item));
                System.out.println("Dropped: " + item);
            }
        }
    }

    private void printInventory() {
        String output = "";
        System.out.println("You're currently carrying:");
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getDescription() + ",  ";

        }
        System.out.println(output);
    }

    private void printHelp() {
        System.out.println("You are a detective trying to solve a murder.");
        System.out.println("Go from room to room to investigate and talk with the suspects.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

//    private void dialog(Command command) {    
//        if (!command.hasSecondWord()) {
//            System.out.println("Talk to who?");
//            return;
//        }
//
//        String name = command.getSecondWord();
//
//        Character nextCharacter = currentRoom.getCharacter(name);
//
//        if (nextCharacter == null) {
//            System.out.println("There is no here one named that!");
//            return;
//
//        } else if (name.equalsIgnoreCase("receptionist")) {
//            Dialog receptionist = new receptionistDialog();
//            
//            
//        } else if (name.equalsIgnoreCase("janitor")) {
//            Dialog janitor = new janitorDialog();
//            
//        }
//            
//    }
    private boolean accuse(Command command) {
        
        String accusedCharacter = command.getSecondWord();
        
        //Checks if the accused character exists
        
        boolean accusedExists = false; //Accused has not been found yet
        
        for (int i = 0; i < characters.size(); i++) {
            if (accusedCharacter.equalsIgnoreCase(characters.get(i).getName())) {
                //Name has been found in characters
                accusedExists = true;
            } 
        }
        
        if (accusedExists) {
            //Boolean to determine wheter or not the corrct person is accused
        boolean isMurdererFound = false;

        for (int i = 0; i < characters.size(); i++) {
            if (accusedCharacter.equalsIgnoreCase(characters.get(i).getName()) && characters.get(i).getIsMurderer()) {
                System.out.println("You found the murderer!");

                isMurdererFound = true;

            }
        }
        if (!isMurdererFound) {
            System.out.println("Not the murderer! You lost!");
        }
        
        return  true; // Once you have accused the game ends. You either win or loose
        } else {
            System.out.println("The accused person does not exist");
            return false;
        }
    }

    private void investigate() {

        System.out.println(currentRoom.getInvestigateString());

    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void moveCleaningLady() {

        //Declaring cleaningLady character object 
        Character CleaningLady = characters.get(3);

        //Get a random room out of all possible rooms
        Room randomRoom = rooms.get(0 + (int) (Math.random() * rooms.size()));

        //Move to the random room
        CleaningLady.setCurrentRoom(randomRoom);

        //Print to player the location of her now
        System.out.println("The cleaning lady is in room: " + randomRoom.getRoomName());
    }

}
