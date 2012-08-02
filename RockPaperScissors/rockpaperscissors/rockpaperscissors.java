package rockpaperscissors;

import javax.swing.JOptionPane;

public class rockpaperscissors {

    public static void main(String[] args) {
        
        int tieCount=0;
        int playerCount=0;
        int compCount=0;

        for (int i=0; i<5; i++) {
            String playerChoice = getPlayerChoice();

            String compChoice = getCompChoice();

            String output = "You chose " + playerChoice +
                    "\nThe computer chose " + compChoice + "\n";
            
            String winner = getWinner(playerChoice,compChoice);

            if (winner.equals("tie")) {
                output += "It's a tie!";
                tieCount++;
            } else if (winner.equals("player")) {
                output += "You win!";
                playerCount++;
            } else {
                output += "The computer wins!";
                compCount++;
            }
            JOptionPane.showMessageDialog(null, output);
        }
        String result = "Results:\n" + 
                "You: " + playerCount + "\n" +
                "Computer: " + compCount + "\n" +
                "Tie: " + tieCount + "\n";
        JOptionPane.showMessageDialog(null, result);
    }

    public static String getPlayerChoice() {
        String choice;
        boolean valid;
        do {
            choice = JOptionPane.showInputDialog("Enter choice " +
                    "(Rock, Paper, or Scissors):");
            choice = choice.toLowerCase();
            if (choice.length() < 2) {
                valid = false;
                JOptionPane.showMessageDialog(null, "Invalid choice");
            } else if (choice.substring(0, 2).equals("ro")) {
                valid = true;
                choice = "rock";
            } else if (choice.substring(0, 2).equals("pa")) {
                valid = true;
                choice = "paper";
            } else if (choice.substring(0, 2).equals("sc")) {
                valid = true;
                choice = "scissors";
            } else {
                valid = false;
                JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        } while(!valid);
        return(choice);
    }
        
    public static String getCompChoice() {
        int randomNum = 1 + (int)(Math.random() * 3);
        String compChoice;
        switch(randomNum) {
            case 1:
                compChoice="rock";
                break;
            case 2:
                compChoice="paper";
                break;
            case 3:
                compChoice="scissors";
                break;
            default:
                compChoice="";
        }
        return(compChoice);
    }

    public static String getWinner(String player, String comp) {
        String winner;

        if (player.equals("rock")) {
            if (comp.equals("rock")) {
                winner = "tie";
            } else if (comp.equals("paper")) {
                winner = "computer";
            } else {
                winner = "player";
            }
        } else if (player.equals("paper")) {
            if (comp.equals("rock")) {
                winner = "player";
            } else if (comp.equals("paper")) {
                winner = "tie";
            } else {
                winner = "computer";
            }
        } else {
            if (comp.equals("rock")) {
                winner = "computer";
            } else if (comp.equals("paper")) {
                winner = "player";
            } else {
                winner = "tie";
            }
        }
        return(winner);
    }
}