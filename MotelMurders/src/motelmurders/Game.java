package motelmurders;

import java.util.ArrayList;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    Room outside, lobby, room1, room2, room3, room4, WC, kitchen, basement, hallwayN, hallwayE, hallwayW;
    ArrayList<Item> inventory = new ArrayList<Item>();
    //Our arraylist will hold the inventory items for our game
    ArrayList<Character> characters = new ArrayList<>();
    //The arraylist will hold the characters for our game
    
    public Game() 
    {
        createRooms();
        parser = new Parser();
        createCharacters();
    }

    private void createCharacters(){
        //Create objects of characters
        Character janitor = new Character("Carl", "Carl is the janitor here. He repairs stuff", lobby);
        Character corpse = new Character("Dead guy", "Yeahhh he dead. Very dead", lobby);
        Character receptionist = new Character("Receptionist", "He waits for you at the desk", lobby);
        Character cleaningLady = new Character("Cleaning lady", "Walks around in the motel cleaning up. She is hard working but underpaid", lobby);
        Character guest1 = new Character("Guest 1", "A man", lobby);
        Character guest2 = new Character("Guest 2", "A woman", lobby);
        Character guest3 = new Character("Guest 3", "Some old person", lobby);
        
        //Add to character arraylist
        characters.add(janitor);
        characters.add(corpse);
        characters.add(receptionist);
        characters.add(cleaningLady);
        characters.add(guest1);
        characters.add(guest2);
        characters.add(guest3);
        
    }
    
    public String getCharacterString() {
            
            for (Character c : characters) {
                String inRoom = null;
                if (currentRoom == c.getCurrentRoom()) {
                    inRoom += c.getName() + " ";
                }
                return inRoom;
            }
            return "None";
        }
    
    private void createRooms()
    {
        
        //Room descriptions when you arrive in a room
        outside = new Room("outside, the wind is blowing, you see the motels old facade infront of you.");
        lobby = new Room("in the lobby of the motel, you see a receptionist and even a vending machine, "
                + " you also see hallways leading to various rooms both left, right and up.");
        room1 = new Room("in Guest room 1 on this \"fine\" establishment, it is filled with most needed interior like: "
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 1 sleeps here.");
        room2 = new Room("in Guest room 2 on this \"fine\" establishment, it is filled with most needed interior like: "
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 2 sleeps here.");
        room3 = new Room("in Guest room 3 on this \"fine\" establishment, it is filled with most needed interior like: "
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " Guest 3 sleeps here.");
        room4 = new Room("in Guest room 4 on this \"fine\" establishment, it is filled with most needed interior like: "
                + " a bath, bed, chair, table, vase, lamps and a window."
                + " The victim used to sleep here, now he sleeps forever.");
        WC = new Room("in the motel WC, except there is an unpleasent stence in here!");
        kitchen = new Room("in a little kitchen, nothing much, here is a pleasant smell!");
        basement = new Room("in the basement, it is a bit dark but from a little light, you can spot a workbench to you right and a big boiler in the back.");
        hallwayN = new Room("in the north hallway, the door to your left leads to the kitchen "
                + " and the door to the right leads to a WC, there seems to be steps further ahead.");
        hallwayE = new Room("in the east hallway, the door to your left leads to the room 3 "
                + " and the door to the right leads to room 4");
        hallwayW = new Room("in the west hallway, the door to your left leads to the room 1 "
                + " and the door to the right leads to room 2");
        
        
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

        outside.setItem(new Item("chair"));
        outside.setItem(new Item("chair2"));
        outside.setItem(new Item("chair3"));

        outside.setItem(new Item("stone"));
        
        currentRoom = outside;
    }

    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    private void printWelcome()
    {
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

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == commandWord.INVENTORY) {
            printInventory();
        }
        else if (commandWord == commandWord.PICKUP) {
                    pickupItem(command);
                    
        } else if (commandWord == commandWord.ACCUSE) {
            //Call accuse method
        } else if (commandWord == commandWord.INVESTIGATE) {
            //Call investigate
        } else if (commandWord == commandWord.DROP) {
            dropItem(command);
        }
        return wantToQuit;
    }
    private void pickupItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Pick up what?");
            return;
        }

        String item = command.getSecondWord();

        Item nextItem = currentRoom.getItem(item);

        if (nextItem == null) {
            System.out.println("There is no item named that!");
            
        }
        else {
            inventory.add(nextItem);
            currentRoom.removeItem(item);

            System.out.println("Picked up :" + item);
                        

        }
    }
    
    private void dropItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String item = command.getSecondWord();

        Item nextItem = new Item(item);

        if (!(inventory.contains(nextItem))) {
        System.out.println("There is no item named: " + nextItem.getDescription());
        }
        else {
            inventory.remove(nextItem);
            currentRoom.setItem(nextItem);
            System.out.println("Dropped: " + item);
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
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the motel.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    private boolean accuse(Character c) {
        
        return c.getIsMurderer(); // check if the caracter accused is the murderer
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }

   
}
