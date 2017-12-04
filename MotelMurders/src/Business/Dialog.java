package Business;

import java.util.Scanner;


public class Dialog {

    private Scanner input = new Scanner(System.in);
    private String question;
    private String user = "";
    private boolean runDialog = false;

    //The startDialog-method is to determine which of the dialog-methods is to be called
    public void startDialog(int i) {
        boolean dialog;

        while (true) {
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
                        System.out.println("This corpse doens't look very active what should i do?"
                                + "\n[1] Yell"
                                + "\n[2] Walk away");
                        question = "1A";
                        break; //Could add a break statement to increase control of flow
                        
                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yell
                                    System.out.println("No response... Mhhh weird!");
                                    break;
                                    
                            case "2": // when you walk away
                                    System.out.println("You walk away");
                                    break;
                }
        }
            }
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
                                        + "[1] Ask her about herself\n"
                                        + "[2] Ask about Ron\n"
                                        + "[3] Ask about Leila\n"
                                        + "[4] Ask about Brian\n"
                                        + "[5] Ask about Carl\n"
                                        + "[6] Ask about the receptionist\n"
                                        + "[7] Walk away\n");
                                question = "1B";
                                break;

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }
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
                                System.out.println("You walk away.");
                                break;

                            default: //if input is wrong and not an actual option
                                System.out.println("Be serious! We don't have time to fool around!");
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
                    case "0": //First dialog output
                        System.out.println("Hello, my name is Ron. "
                                + "I assume you want some information?"
                                + "\n[1] Yes"
                                + "\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yes
                                System.out.println("How can I help you?"
                                        + "\n[1] Ask for some information from Ron"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Brain"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Daisy (the receptionist"
                                        + "\n[7] Walk away");
                                question = "3";
                                break;

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                    case "3":
                        switch (user = input.next()) {
                            case "1":
                                System.out.println("After my car crashed I was forced to stay here, since nothing else is nearby…");
                                question = "4";
                                break;

                            case "2":
                                System.out.println("I have seen her pass me a couple of times. She seems to be all over the place.");
                                question = "4";
                                break;

                            case "3":
                                System.out.println("If you are talking about the charming lady, then I can't tell you much. Since I myself have not spoken with her");
                                question = "4";
                                break;

                            case "4":
                                System.out.println("I don’t know who he is.");
                                question = "4";
                                break;

                            case "5":
                                System.out.println("I have no information regarding the janitor, since I have never met him.");
                                question = "4";
                                break;

                            case "6":
                                System.out.println("She seemed a little stressed, but very friendly non the less.");
                                question = "4";
                                break;

                            case "7":
                                System.out.println("You walk away from Ron.");
                                return false;

                            default: //if input is wrong and not an actual option
                                System.out.println("This is not an option. Try again.");
                                question = "4";
                                break;
                        }

                    case "4":
                        System.out.println("Anything else I can help with?"
                                        + "\n[1] Ask for some information from ron"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Brain"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Daisy (the receptionist"
                                        + "\n[7] Walk away");
                        question = "3";
                        break;

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
                    case "0": //First dialog output
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
                                System.out.println("How can I help you?"
                                        + "\n[1] Ask if she noticed anything special last night"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Brian"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                                question = "3";
                                break;

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                    case "3":
                        switch (user = input.next()) {
                            case "1":
                                System.out.println("No it was a very ordinary night, the corpse was found the next day by Molly the cleaning lady");
                                question = "4";
                                break;

                            case "2":
                                System.out.println("I’m not liked by my co-workers, so don’t know too much about her. I know she is very poor and is raising three children by herself. So she does nothing but work");
                                question = "4";
                                break;

                            case "3":
                                System.out.println("A nice and intellectual girl with a lot of ambitions. I have talked to her a couple times, but nothing out of the ordinary");
                                question = "4";
                                break;

                            case "4":
                                System.out.println("Seemed like he had a long trip last night. I think he went to bed immediately after he arrived");
                                question = "4";
                                break;

                            case "5":
                                System.out.println("We don’t talk much. We mostly ignore each other. He is just a lazy janitor.");
                                question = "4";
                                break;

                            case "6":
                                System.out.println("A cocky guy, who seemed to be in a bad mood");
                                question = "4";
                                break;

                            case "7":
                                System.out.println("You walk away from the receptionist.");
                                return false;

                            default: //if input is wrong and not an actual option
                                System.out.println("This is not an option. Try again.");
                                question = "4";
                                break;
                        }

                    case "4":
                        System.out.println("Anything else I can help with?"
                                + "\n[1] Ask if she noticed anything special last night"
                                + "\n[2] Ask about the cleaning lady"
                                + "\n[3] Ask about Leila"
                                + "\n[4] Ask about Brian"
                                + "\n[5] Ask about Carl"
                                + "\n[6] Ask about Ron"
                                + "\n[7] Walk away");
                        question = "3";
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
                     case "0": //First dialog output
                        System.out.println("hi detective my name is Leila. "
                                + "I assume you want to ask me some questions regarding last nights homicide?"
                                + "\n[1] Yes"
                                + "\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yes
                                System.out.println("How can I help you?"
                                        + "\n[1] Ask why Leila is here"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Daisy (the receptionist)"
                                        + "\n[4] Ask about Brian"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                                question = "3";
                                break;

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                    case "3":
                        switch (user = input.next()) {
                            case "1":
                                System.out.println("I’m a university student was on a trip to my parents home. It’s a long way, so stopped at the motel to sleep.");
                                question = "4";
                                break;

                            case "2":
                                System.out.println("she is always around until nighttime and arrives early in the morning next day.");
                                question = "4";
                                break;

                            case "3":
                                System.out.println("A very friendly woman, whom I have spoken to a few times. She would always be behind the desk though.");
                                question = "4";
                                break;

                            case "4":
                                System.out.println("I walked passed him, but other than that i don’t know him");
                                question = "4";
                                break;

                            case "5":
                                System.out.println("I have not seen him.");
                                question = "4";
                                break;

                            case "6":
                                System.out.println("I saw him in the lobby when he arrived. He seems to be pretty well off.");
                                question = "4";
                                break;

                            case "7":
                                System.out.println("You walk away from Leila.");
                                return false;

                            default: //if input is wrong and not an actual option
                                System.out.println("This is not an option. Try again.");
                                question = "4";
                                break;
                        }

                    case "4":
                        System.out.println("Anything else I can help with?"
                                        + "\n[1] Ask why Leila is here"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Molly (the receptionist)"
                                        + "\n[4] Ask about Brian"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                        question = "3";
                        break;

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
                     case "0": //First dialog output
                        System.out.println("Well hello detective this old mans name is Brian. "
                                + "I assume you want some information?"
                                + "\n[1] Yes"
                                + "\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yes
                                System.out.println("How can I help you?"
                                        + "\n[1] Ask why Brian is at the motel"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Daisy (the receptionist)"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                                question = "3";
                                break;

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                    case "3":
                        switch (user = input.next()) {
                            case "1":
                                System.out.println("I have a appointment with my friend in a city nearby, so i spend the night in this motel");
                                question = "4";
                                break;

                            case "2":
                                System.out.println("The few times I have seen her she busy cleaning.");
                                question = "4";
                                break;

                            case "3":
                                System.out.println("I walked passed her, but other than that I got no information.");
                                question = "4";
                                break;

                            case "4":
                                System.out.println("A woman with just a few words, but seems to be talking a lot in the telephone.");
                                question = "4";
                                break;

                            case "5":
                                System.out.println("He fixed my table yesterday evening. I don’t know much else regarding him.");
                                question = "4";
                                break;

                            case "6":
                                System.out.println("I have not seen him before.");
                                question = "4";
                                break;

                            case "7":
                                System.out.println("You walk away from Brian.");
                                return false;

                            default: //if input is wrong and not an actual option
                                System.out.println("This is not an option. Try again.");
                                question = "4";
                                break;
                        }

                    case "4":
                        System.out.println("Anything else I can help with?"
                                        + "\n[1] Ask why Brian is at the motel"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Daisy (the receptionist)"
                                        + "\n[5] Ask about Carl"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                        question = "3";
                        break;

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
                    case "0": //First dialog output
                        System.out.println("I am the janitor of this place my name is carl. Nice to meet you detective. "
                                + "Want some information regarding the residents and my co-workers?"
                                + "\n[1] Yes"
                                + "\n[2] No");
                        question = "1A";
                        break;

                    case "1A":
                        switch (user = input.next()) //Switch to either continue conversation or terminate
                        {
                            case "1": //Player answers yes
                                System.out.println("How can I help you?"
                                        + "\n[1] Ask about Carl"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Daisy (the receptionist)"
                                        + "\n[5] Ask about Brian"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                                question = "3";
                                break;

                            case "2": //Player answers no
                                System.out.println("Come find me if I can help another time.");
                                return false;
                        }

                    case "3":
                        switch (user = input.next()) {
                            case "1":
                                System.out.println("I can be found in the basement, where i spend most my time. I was here last night aswell.");
                                question = "4";
                                break;

                            case "2":
                                System.out.println("Hard working lady. Always giving her best and working long hours.");
                                question = "4";
                                break;

                            case "3":
                                System.out.println("I have not met her.");
                                question = "4";
                                break;

                            case "4":
                                System.out.println("I don’t really like her bossing me around, but normally hard working.");
                                question = "4";
                                break;

                            case "5":
                                System.out.println("I fixed his table other than that i have not seen him.");
                                question = "4";
                                break;

                            case "6":
                                System.out.println("I have not seen him.");
                                question = "4";
                                break;

                            case "7":
                                System.out.println("You walk away from Carl.");
                                return false;

                            default: //if input is wrong and not an actual option
                                System.out.println("This is not an option. Try again.");
                                question = "4";
                                break;
                        }

                    case "4":
                        System.out.println("Anything else I can help with?"
                                        + "\n[1] Ask about Carl"
                                        + "\n[2] Ask about the cleaning lady"
                                        + "\n[3] Ask about Leila"
                                        + "\n[4] Ask about Daisy (the receptionist)"
                                        + "\n[5] Ask about Brian"
                                        + "\n[6] Ask about Ron"
                                        + "\n[7] Walk away");
                        question = "3";
                        break;

                    default: //if input is wrong and not an actual option
                        System.out.println("Be serious! We don't have time to fool around!");
                        return false;
                        
                }
            }
        }
    }
}
