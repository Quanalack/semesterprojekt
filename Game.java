package worldofzuul;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Game 
{
    //Initializing parser and room objects
    private Parser parser;
    private Room currentRoom;
        
    public Game() //Constructor to start the game.
    {
        createRooms();
        parser = new Parser();
    }

    //Method to generate all the rooms necessary and connect them to eachother
    private void createRooms()
    {
        //Defining room names
        Room outside, lobby, toilet, kitchen, basement, room1;
        
        //Setting description of rooms
        outside = new Room("outside the hotel");
        lobby = new Room("inside the the lobby");
        hallwayNorth = new Room("the northern hallway to the kitchen and toilet");
        hallwayWest = new Room("the western hallway to room 1 and 2")
        hallwayEast = new Room("the eastern hallway to room 3 and 4");
        room1 = new Room("in room #1");
        room2 = new Room("in room #2");
        room3 = new Room("in room #3");
        room4 = new Room("in room #4");
        toilet = new Room("in the room with toilets");
        kitchen = new Roomm("in the kitchen. It smells good in here");
        basement = new Room("in the basement. It's a little dark");
        
        
        //Defining which rooms are connected to eachother
        
        //Exits from outside
        outside.setExit("north", lobby); 
        
        //Exits from the lobby
        lobby.setExit("west", hallwayWest);
        lobby.setExit("east", hallwayEast);
        lobby.setExit("north", hallwayNorth);
        lobby.setExit("south", outside);
        
        //Exits from the western hallway     
        hallwayWest.setExit("south", room1);
        hallwayWest.setExit("north", room2);
        hallwayWest.setExit("east", lobby);
        
        //Exit from room 1
        room1.setExit("south", hallwayWest);
        
        //Exit from room 2
        room2.setExit("north", hallwayWest);
        
        //Exits from the eastern hallway     
        hallwayEast.setExit("south", room3);
        hallwayEast.setExit("north", room4);
        hallwayEast.setExit("west", lobby);
        
        //Exit from room 3
        room3.setExit("south", hallwayEast);
        
        //Exit from room 4
        room4.setExit("north", hallwayEast);
        
        //Exits from the northern hallway
        hallwayNorth.setExit("west", kitchen);
        hallwayNorth.setExit("east", toilet);
        hallwayNorth.setExit("north", basement);
        hallwaynorth.setExit("south", lobby);
        
        //Exit from kitchen
        kitchen.setExit("east", hallwayNorth);
        
        //Exit from toilet
        toilet.setExit("west", hallwayNorth);
        
        //exit from basement
        basement.setExit("south", hallwatNorth);
        
        //Which room to start at
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
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
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
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are a private detective hired to find a murderer");
        System.out.println("Go around the motel and investigate. Use the commands");
        System.out.println("Use the commands 'north', 'south', 'east' and 'west' to navigate from room to room);
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
