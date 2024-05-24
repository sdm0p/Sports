package com.accenture.App.com;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
* Hello world!
*
*/
public class App {
    private Set<String> players;
    public App() {
        players = new HashSet();
    }
    public void addPlayer(String playerName) {
        players.add(playerName);
        System.out.println(playerName + " has been added to the team.");
    }
    public void removePlayer(String playerName) {
        if (players.remove(playerName)) {
            System.out.println(playerName + " has been removed from the team.");
        } else {
            System.out.println(playerName + " is not in the team.");
        }
    }
    public boolean checkPlayer(String playerName) {
        return players.contains(playerName);
    }
    public void displayAllPlayers() {
        System.out.println("Players in the team:");
        for (String player : players) {
            System.out.println(player);
        }
    }
    public static void main(String[] args) {
        App teamManager = new App();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Check player");
            System.out.println("4. Display all players");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter player name to add: ");
                    String addPlayerName = scanner.nextLine();
                    teamManager.addPlayer(addPlayerName);
                    break;
                case 2:
                    System.out.print("Enter player name to remove: ");
                    String removePlayerName = scanner.nextLine();
                    teamManager.removePlayer(removePlayerName);
                    break;
                case 3:
                    System.out.print("Enter player name to check: ");
                    String checkPlayerName = scanner.nextLine();
                    boolean isPlayerInTeam = teamManager.checkPlayer(checkPlayerName);
                    if (isPlayerInTeam) {
                        System.out.println(checkPlayerName + " is in the team.");
                    } else {
                        System.out.println(checkPlayerName + " is not in the team.");
                    }
                    break;
                case 4:
                    teamManager.displayAllPlayers();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}