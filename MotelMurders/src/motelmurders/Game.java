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
    
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    public void createCharacters(){
        Character janitor = new Character("Carl", "Carl is the janitor here. He cleans the toilets", lobby);
        Character corpse = new Character("Dead guy", "Yeahhh he dead. Very dead", lobby);
        Character receptionist = new Character("Receptionist", "He waits for you at the desk", lobby);
        Character cleaningLady = new Character("Cleaning lady", "Walks around in the motel cleaning up. She is hard working but underpaid", lobby);
        Character guest1 = new Character("Guest 1", "A man", lobby);
        Character guest2 = new Character("Guest 2", "A woman", lobby);
        
        
    }
    
    private void createRooms()
    {
        
      
        outside = new Room("outside");
        lobby = new Room("lobby");
        room1 = new Room("in motele room 1");
        room2 = new Room("in motel room 2");
        room3 = new Room("in motel room 3");
        room4 = new Room("in motel room4");
        WC = new Room("Motel WC");
        kitchen = new Room("kitchen");
        basement = new Room("Basement");
        hallwayN = new Room("Hallway North");
        hallwayE = new Room("Hallway East");
        hallwayW = new Room("Hallway West");
        
        
        
        outside.setExit("forward", lobby);
        lobby.setExit("right", hallwayE);
        lobby.setExit("left", hallwayW);

        lobby.setExit("back", outside);
        
        lobby.setExit("forward", hallwayN);
        hallwayE.setExit("right", room4);
        hallwayE.setExit("left", room3);
        hallwayE.setExit("back", lobby);
        //Walk directly from the room to the toilet located in the north section of the motel
        hallwayW.setExit("right", room2);
        hallwayW.setExit("left", room1);
        hallwayW.setExit("back", lobby);
        
        hallwayN.setExit("right", WC);
        hallwayN.setExit("left", kitchen);
        hallwayN.setExit("forward", basement);
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
            System.out.println("Picked up:" + item);
        }
    }
    private void printInventory() {
        String output = "";
        for (int i = 0; i < inventory.size(); i++) {
            output += inventory.get(i).getDescription() + "  ";
            System.out.println("You're currently carrying:");  
            System.out.println(output);
        }
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
