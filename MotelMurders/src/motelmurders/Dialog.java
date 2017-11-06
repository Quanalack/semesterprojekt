package motelmurders;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jeppe
 */
public class Dialog {

    
    private Scanner input = new Scanner(System.in);
    private String question;
    private String user = "";
    private boolean runDialog = false;
    
    
    
    //The startDialog-method is to determine which of the dialog-methods is to be called
    public void startDialog(int i) {
        boolean dialog;
        
        System.out.println("This is currently the dialog in the game.\n "
                + "if the character is in the room when TALK command is activated, \n"
                + "the dialog will start now: \n");
        
        while (true)
            switch (i) {
                case 0: //janitor dialog
                    dialog = janitorDialog();
                    break;
                    
                case 1: //corpse dialog
                    dialog = corpseDialog();   
                    break;
                
                case 2: //receptionist dialog
                    dialog = receptionistDialog();
                    break;
                
/*              case 3: //cleaning lady dialog
                    dialog = cleaningladyDialog();
                    break;
                    
                case 4: //guest 1 dialog
                    dialog = guest1Dialog();
                    break;
                    
                case 5: //guest 2 dialog
                    dialog = guest2Dialog();
                    break;
                    
                case 6: //guest 3 dialog
                    dialog = guest3Dialog();
                    break;  
*/                    
                default:
                    System.out.println("Error.");
                    break;
            }
       
        }        
            
            //This is an example of how the start dialog could work.
            //First of two examples:
    public boolean testDialog() {
                
        question = "0";
        runDialog = false;

        //Dialog loop
        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will terminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        System.out.println("Short story..blablabla. What is your name?");
                        question = "1";
                        break;

                    case "1":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now   
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        user = input.next();
                        question = "1A";
                        break;

                    case "1A":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        System.out.println("Are your sure that is your name?\n[1] Yes\n[2] No");
                        question = "2";
                        break;

                    case "2":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        switch (user = input.next()) //Switch to go back to change name if it is desired
                        {
                            case "1":
                                System.out.println("\"question\" is " + question); //Shows what the question value is now
                                //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                                System.out.println("Great! Your are an investigator who are about to stumble unto a murder. GO!\n"
                                        + "Perhaps you should ask around for clues as to what happened.");
                                question = "3";
                                return false;

                            case "2": //if "no" in Q1A
                                System.out.println("\"question\" is " + question); //Shows what the question value is now
                                //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                                question = "0A";
                                break;
                        }
                        break;

                    case "0A": //if answer in Q1A is "No"
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        System.out.println("Then what IS your name?");
                        question = "1";
                        break;

                    default:
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        System.out.println("ERROR!");
                        System.exit(0);
                        break;
                }
            }
        }
    }
    
    public boolean corpseDialog() {

        question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("This man is not very talkative...\n"
                                + "[1] Yell \"HEEEY!\" at him.\n"
                                + "[2] Leave the corpse be.");
                        switch (user = input.next())
                        {
                            case "1":
                                System.out.println("No response.");
                                return false;
                                
                            case "2": 
                                return false;
                        }
                    default:
                        return false;
                }
            }
        }
    }
    
    //Another method can be made here, e.i. for the receptionist.
    public boolean receptionistDialog() {

        question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("I am the receptionist at this motel. My name is \"????\".\n"
                                + "I heard you're looking for clues. Can I help you?\n[1] Yes\n[2] No");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("I'm happy to help!");
                                question = "1B";
                                break; //Could add a break statement to increase control of flow

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("Okay, bye! Come see me if I can help.");
                                return false;
                        }

                    case "1B":
                        System.out.println("How can I help you?\n[1] ?\n[2] ?\n[3] ?");

                        switch (user = input.next()) {
                            //Unfinished cases (Options for dialog)
                            case "1":
                                System.out.println("Good.");
                                return false;

                            case "2":
                                System.out.println("Not good.");
                                return false;

                            case "3":
                                System.out.println("Very bad.");
                                return false;
                        }

                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                        
                }
            }
        }
    }
    
    //Janitor dialog
     public boolean janitorDialog() {

        question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("I am CARL, the JANITOR at this motel.\n"
                                + "I heard you're looking for clues. Need help? *belch!*\n[1] Yes\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("I'm too drunk to help!");
                                question = "1B";
                                break;

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("Okay, bye! *belch!*");
                                return false;
                        }

                    case "1B":
                        System.out.println("How can I NOT help you...?\n[1] ?\n[2] ?\n[3] ?");

                        switch (user = input.next()) {
                            //Unfinished cases (Options for dialog)
                            case "1":
                                System.out.println("Good.");
                                return false;

                            case "2":
                                System.out.println("Not good.");
                                return false;

                            case "3":
                                System.out.println("Very bad.");
                                return false;
                        }

                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to not be drinking! Cheers!");
                        return false;
                        
                }
            }
        }

    }
}
