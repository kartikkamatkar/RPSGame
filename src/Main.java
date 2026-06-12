import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();
        int playerScore = 0;
        int computerScore = 0;
        int roundsPlayed = 0;
        System.out.println("Enter Your Name :");
        String name = s.nextLine();
        System.out.println("=====================================");
        System.out.println("   Welcome to Rock Paper Scissors!   ");
        System.out.println("=====================================");
        System.out.println("Rules: Rock beats Scissors");
        System.out.println("       Scissors beats Paper");
        System.out.println("       Paper beats Rock");
        System.out.println("=====================================\n");
        while (true) {
            System.out.println("\n--- Round " + (roundsPlayed + 1) + " ---");
            System.out.println("Current Score - You: " + playerScore + " | Computer: " + computerScore);
            System.out.println("\nChoose your move:");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("0. Exit Game");
            System.out.print("Enter your choice (0-3): ");
            int playerchoice = s.nextInt();
            if (playerchoice == 0) {
                System.out.println("\n=====================================");
                System.out.println("           Game Summary            ");
                System.out.println("=====================================");
                System.out.println("Total Rounds Played: " + roundsPlayed);
                System.out.println("Final Score - You: " + playerScore + " | Computer: " + computerScore);
                if (playerScore > computerScore) {
                    System.out.println("Congratulation ! You WON...");
                } else if (computerScore > playerchoice) {
                    System.out.println("Computer Win ! Better Luck next Time ...");
                } else {
                    System.out.println("It's a tie ! Well Played..");
                }
                System.out.println("================================");
                System.out.println("Thanks For Playing ! " + name);
                break;
            }
            if (playerchoice < 1 || playerchoice > 3) {
                System.out.println("Invalid Choice ! Please Enter the Valid Input ...");
                continue;
            }
            int computerChoice = random.nextInt(3) + 1;
            System.out.println("\n You chose " + getChoiceName(playerchoice));
            System.out.println("Computer Choice :" + getChoiceName(computerChoice));
            int result = determineWinner(playerchoice, computerChoice);
            if (result == 1) {
                System.out.println("You win the Round!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer wins the Round!");
                computerScore++;
            } else {
                System.out.println("It's a Tie!");
            }
            roundsPlayed++;
        }
        s.close();
    }

    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissor";
            default:
                return "Invalid";
        }
    }

    public static int determineWinner(int player, int computer) {
        if (player == computer) {
            return 0;
        }
        if ((player == 1 && computer == 3) || (player == 2 && computer == 1) || (player == 3 && computer == 2)) {
            return 1;
        }
        return -1;
    }
}