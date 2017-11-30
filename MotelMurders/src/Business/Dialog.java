package Business;

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
        
        while (true)
            switch (i) {
                case 0: //janitor dialog
                    dialog = janitorDialog();
                    break;
                    
      /*          case 1: //corpse dialog
                    dialog = corpseDialog();   
                    break;
        */        
                case 2: //receptionist dialog
                    dialog = receptionistDialog();
                    break;
                
              case 3: //cleaning lady dialog
                    dialog = cleaningladyDialog();
                    break;
                    
                case 4: //guest 1 dialog
                    dialog = ronDialog();
                    break;
                    
                case 5: //guest 2 dialog
                    dialog = leilaDialog();
                    break;
                    
                case 6: //guest 3 dialog
                    dialog = brianDialog();
                    break;  
                 
                default:
                    System.out.println("Error.");
                    break;
            }
       
        }        
            
            //This is an example of how the start dialog could work.
            //First of two examples:
    public boolean cleaningladyDialog() {
                
        question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("I am the cleaning lady at this motel. They call me Molly.\n"
                                + "I heard you're looking for clues. Can I help you?"
                                + "\n[1] Yes"
                                + "\n[2] No");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yes
                                System.out.println("How can I help you?\n"
                                        + "\t[1] Ask her about herself\n"
                                        + "\t[2] Ask about Ron\n"
                                        + "\t[3] Ask about Leila\n"
                                        + "\t[4] Ask about Brian\n"
                                        + "\t[5] Ask about Carl\n"
                                        + "\t[6] Ask about the receptionist\n"
                                        + "\t[7] Walk away\n");
                                question = "1B";
                                break;

                            case "1B":
                                switch (user = input.next()) {

                                    case "1":
                                        System.out.println("I am the only cleaning lady at this motel and have worked here for the last 10 years");
                                        break;

                                    case "2":
                                        System.out.println("He is a rich guy and spend a lot of time talking on the phone.");
                                        break;

                                    case "3":
                                        System.out.println("A young woman but seems to be pretty intelligent.");
                                        break;

                                    case "4":
                                        System.out.println("An old man who was very tired when he arrived. Probably from driving too much.");
                                        break;

                                    case "5":
                                        System.out.println("Seemed to be having quite a lot of scratches today. I wonder what happened");
                                        break;

                                    case "6":
                                        System.out.println("Not the most friendly co-worker although always friendly towards customers. She likes being in control.");
                                        break;

                                    case "7":
                                        System.out.println(">You walk away.");
                                        break;

                                    default: //if input is wrong and not an actual option
                                        System.out.println("Be serious! We don't have time to fool around!");
                                        return false;
                                }

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                }
            }
        }
    }


    public boolean ronDialog() {

         question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("Hi I am Ron a guest at this motel for the night.\n"
                                + "I heard someone was killed here last night. are you here to gather information?\n[1] Yes\n[2] No");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("Ask for some information from ron");
                                question = "1B";
                                break; //Could add a break statement to increase control of flow

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about cleaning lady");
                                question = "1C";
                                break;
                                
                            case "3": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Leila");
                                question = "1D";
                                break;
                                
                            case "4": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Brian");
                                question = "1E";
                                break;
                                
                            case "5": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Carl");
                                question = "1F";
                                break;
                                
                            case "6": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about receptioncist(Daisy)");
                                question = "1G";
                                break;
                        }

                    case "1B":
                        System.out.println("After my car crashed I was forced to stay here, since nothing else is nearby…");
                   
                    case "1C":
                        System.out.println("I have seen her pass me a couple of times. She seems to be all over the place");
                        
                    case "1D":
                        System.out.println("If you are talking about the charming lady, then I can't tell you much. Since I myself have not spoken with her");
                    
                    case "1E":
                        System.out.println("I don’t know who he is");

                    case "1F":
                        System.out.println("I have no information regarding the janitor, since I have never met him");
                       
                    case "1G":
                        System.out.println("She seemed a little stressed, but very friendly non the less.");                        
                        
                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                        
                }
            }
        }
    }
    
    //The dialog for the receptionist
    public boolean receptionistDialog() {

        question = "0"; //Determines where in the dialog is the next step
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("I am the receptionist and my name is Daisy. "
                                + "I assume that you are the detective who want to ask about my co-workers and the residents?"
                                + "\n[1] Yes"
                                + "\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yes
                                System.out.println("How can I help you?\n"
                                        + "[1] Ask if she noticed anything special last night\n"
                                        + "[2] Ask about the cleaning lady\n"
                                        + "[3] Ask about Leila\n"
                                        + "[4] Ask about Brian\n"
                                        + "[5] Ask about Carl\n"
                                        + "[6] Ask about Ron\n"
                                        + "[7] Walk away");
                                question = "3";
                                break;
                            
                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                    case "3":
                            switch (user = input.next()) 
                            {
                                    case "1":
                                        question = "3B";
                                        break;

                                    case "2":
                                        question = "3C";
                                        break;

                                    case "3":
                                        question = "3D";
                                        break;

                                    case "4":
                                        question = "3E";
                                        break;

                                    case "5":
                                        question = "3F";
                                        break;

                                    case "6":
                                        question = "3G";
                                        break;

                                    case "7":
                                        question = "3H";
                                        break;
                                    
                                    default: //if input is wrong and not an actual option
                                        System.out.println("Be serious! We don't have time to fool around!");
                                        return false;
                                }

                                
                    case "3B":
                        System.out.println("No it was a very ordinary night, the corpse was found the next day by Molly the cleaning lady");
                        break;

                    case "3C":
                        System.out.println("I’m not liked by my co-workers, so don’t know too much about her. I know she is very poor and is raising three children by herself. So she does nothing but work");
                        break;

                    case "3D":
                        System.out.println("A nice and intellectual girl with a lot of ambitions. I have talked to her a couple times, but nothing out of the ordinary");
                        break;

                    case "3E":
                        System.out.println("Seemed like he had a long trip last night. I think he went to bed immediately after he arrived");
                        break;

                    case "3F":
                        System.out.println("We don’t talk much. We mostly ignore each other. He is just a lazy janitor.");
                        break;

                    case "3G":
                        System.out.println("A cocky guy, who seemed to be in a bad mood");
                        break;

                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                }                            

                           
                        
        
                }
            }
    }    
    
    public boolean leilaDialog() {

         question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("I detective my name is Leila .\n"
                                + "I assume you want to ask me some questions regarding last nights homicide \n[1] Yes\n[2] No");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("Ask why Leila is here");
                                question = "1B";
                                break; //Could add a break statement to increase control of flow

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about cleaning lady");
                                question = "1C";
                                break;
                                
                            case "3": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Molly the receptionist");
                                question = "1D";
                                break;
                                
                            case "4": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Brian");
                                question = "1E";
                                break;
                                
                            case "5": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Carl");
                                question = "1F";
                                break;
                                
                            case "6": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Ron");
                                question = "1G";
                                break;
                        }

                    case "1B":
                        System.out.println("I’m a university student was on a trip to my parents home. It’s a long way, so stopped at the motel to sleep.");
                   
                    case "1C":
                        System.out.println("she is always around until nighttime and arrives early in the morning next day.");
                        
                    case "1D":
                        System.out.println("A very friendly woman, whom I have spoken to a few times. She would always be behind the desk though.");
                    
                    case "1E":
                        System.out.println("I walked passed him, but other than that i don’t know him");

                    case "1F":
                        System.out.println("I have not seen him");
                       
                    case "1G":
                        System.out.println("I saw him in the lobby when he arrived. He seems to be pretty well off.");                        
                        
                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                        
                }
            }
        }
    }
    
    public boolean brianDialog() {

         question = "0";
        runDialog = false;

        while (true) {
            if (user.equalsIgnoreCase("exit")) {  //if user types exit at any time, dialog will teminate
                return false;
            } else {
                switch (question) {
                    case "0":
                        System.out.println("Well hello detective this old mans name is Brian.\n"
                                + "I assume you want some information?\n[1] Yes\n[2] No");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("Ask why Brian is at the motel");
                                question = "1B";
                                break; //Could add a break statement to increase control of flow

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about cleaning lady");
                                question = "1C";
                                break;
                                
                            case "3": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Leila");
                                question = "1D";
                                break;
                                
                            case "4": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Molly (the receptionist)");
                                question = "1E";
                                break;
                                
                            case "5": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Carl");
                                question = "1F";
                                break;
                                
                            case "6": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Ron");
                                question = "1G";
                                break;
                        }

                    case "1B":
                        System.out.println("I have a appointment with my friend in a city nearby, so i spend the night in this motel.");
                   
                    case "1C":
                        System.out.println("The few times I have seen her she busy cleaning.");
                        
                    case "1D":
                        System.out.println("I walked passed her, but other than that I got no information");
                    
                    case "1E":
                        System.out.println(" A woman with just a few words, but seems to be talking a lot in the telephone.");

                    case "1F":
                        System.out.println("He fixed my table yesterday evening. I don’t know much else regarding him.");
                       
                    case "1G":
                        System.out.println("I have not seen him before.");                        
                        
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
                        System.out.println("I am the janitor of this place my name is carl. Nice to meet you detective.\n"
                                + "Want some information regarding the residents and my co-workers?\n[1] Yes\n[2] No");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1":
                                System.out.println("Ask about Carl");
                                question = "1B";
                                break; //Could add a break statement to increase control of flow

                            case "2": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about cleaning lady");
                                question = "1C";
                                break;
                                
                            case "3": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Leila");
                                question = "1D";
                                break;
                                
                            case "4": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Molly (the receptionist)");
                                question = "1E";
                                break;
                                
                            case "5": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Brian");
                                question = "1F";
                                break;
                                
                            case "6": //if "no" in Q0, terminate dialog
                                System.out.println("Ask about Ron");
                                question = "1G";
                                break;
                        }

                    case "1B":
                        System.out.println("I can be found in the basement, where i spend most my time. I was here last night aswell.");
                   
                    case "1C":
                        System.out.println("Hard working lady. Always giving her best and working long hours.");
                        
                    case "1D":
                        System.out.println("I have not met her.");
                    
                    case "1E":
                        System.out.println("I don’t really like her bossing me around, but normally hard working.");

                    case "1F":
                        System.out.println("I fixed his table other than that i have not seen him.");
                       
                    case "1G":
                        System.out.println("I have not seen him.");                        
                        
                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                        
                }
            }
        }
    }
}