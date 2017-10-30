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
    
    
    
//    //The startDialog-method is to determine which of the dialog-methods is to be called
//    public int startDialog(int initiator) {
//        boolean dialog;
//
//        System.out.println("This is currently the dialog in the game.\n "
//                + "if the initiator is 1 = initial dialog, or 2 = receptionist.");
//       
//        if (initiator <= 0) {
//            System.out.println("ERROR! TRY AGAIN. Initiator does not exist");
//        } else if (initiator == 1){
//                dialog = initialDialog();
//            } else if (initiator == 2){
//                    dialog = receptionistDialog();
//                } else if (initiator > 2){
//                        System.out.println("ERROR! Enter a positive number. TRY AGAIN");
//                    }
//                } 
//            }
//        } return startDialog(initiator);
//    }        
            
            //This is an example of how the start dialog could work.
            //First of two examples:
    public boolean initialDialog() {
                
        question = "0";
        runDialog = false;

        //Dialog loop
        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
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

    //Another method can be made here, e.i. for the receptionist.
    //Second of two examples:
    public boolean receptionistDialog() {

        question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        System.out.println("I am the receptionist at this motel. My name is \"????\".\n"
                                + "I heard you're looking for clues. Can I help you?\n[1] Yes\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("\"question\" is " + question); //Shows what the question value is now
                                //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                                System.out.println("I'm happy to help!");
                                question = "1B";
                                break;

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("\"question\" is " + question); //Shows what the question value is now
                                //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                                System.out.println("Okay, bye! Come see me if I can help.");
                                return false;
                        }

                    case "1B":
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
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
                        System.out.println("\"question\" is " + question); //Shows what the question value is now
                        //Line above is a control. MUST BE DELETED BEFORE FINAL GAME
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                        
                }
            }
        }

    }
}
