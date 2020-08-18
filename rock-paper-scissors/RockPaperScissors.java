import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors
{
    public static void main(String[] args){
        System.out.println("Let's play!");
        Scanner kb = new Scanner(System.in);
        Random gen = new Random();
        String user, system="";
        int userPoint =0, systemPoint=0;
        for (int i=0; i<5; i++){ //5 total rounds
            if (!(userPoint == 3 || systemPoint == 3)){ //stops when user wins 3 rounds
                System.out.println("Rock, paper, scissors!");
                user= kb.next();
                if (user.equalsIgnoreCase("scissors") || user.equalsIgnoreCase("paper") || user.equalsIgnoreCase("rock")) switch (gen.nextInt(3)){
                        case 0: system = "rock"; System.out.println("<rock>");
                        break;
                        case 1: system = "scissors"; System.out.println("<scissors>");
                        break;
                        case 2: system = "paper"; System.out.println("<paper>");
                        break;
                    }
                switch (user){
                    case "rock":
                    switch (system){
                        case "rock": System.out.println("Tie, try again! \n Score: "+userPoint+"-"+systemPoint); i--;
                        break;
                        case "paper": systemPoint++; System.out.println("Score: "+userPoint+"-"+systemPoint);
                        break;
                        case "scissors": userPoint++; System.out.println("Score: "+userPoint+"-"+systemPoint);
                        break;
                    }
                    break;
                    case "paper":
                    switch (system){
                        case "rock": userPoint++; System.out.println("Score: "+userPoint+"-"+systemPoint);
                        break;
                        case "paper": System.out.println("Tie, try again! \n Score: "+userPoint+"-"+systemPoint); i--;
                        break;
                        case "scissors": systemPoint++; System.out.println("Score: "+userPoint+"-"+systemPoint);
                        break;
                    } 
                    break;
                    case "scissors":
                    switch (system){
                        case "rock": systemPoint++; System.out.println("Score: "+userPoint+"-"+systemPoint);
                        break;
                        case "paper": userPoint++; System.out.println("Score: "+userPoint+"-"+systemPoint);
                        break;
                        case "scissors": System.out.println("Tie, try again! \n Score: "+userPoint+"-"+systemPoint); i--;
                        break;
                    }
                    break;
                    default:System.out.println("Invalid input."); i--; //reduces 1 round for a redo
                    break;
                }

            }

        }
        displayWinner(userPoint, systemPoint);
    }

    public static void displayWinner(int userPoint, int systemPoint){
        if (userPoint==3) System.out.println("You win!");
        else if (systemPoint==3) System.out.println("You lose.");
    }
}

