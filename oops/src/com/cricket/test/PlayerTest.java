package com.cricket.test;

import com.account.entity.Account;
import com.cricket.entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Player> playerList = new ArrayList<Player>();

        int operation;
        while(true) {
            System.out.println("\n\nEnter the operation you want to perform");
            System.out.println("1. Create Player");
            System.out.println("2. Print States Table");
            System.out.println("6. Exit");

            while (true) {
                if (scanner.hasNextInt()) {
                    operation = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Please enter valid number");
                    scanner.next();
                }
                System.out.println("Please select the operation : ");
            }

            switch (operation) {
                // craete player
                case 1:
                    Player newPlayer = createPlayer(scanner);
                    playerList.add(newPlayer);
                    System.out.println("Account created successfully");

                    newPlayer.displayPlayer();

                    break;

                // display state table
                case 2:
                    for(Player p : playerList){
                        p.displayPlayer();
                        if(p.getMatches() == 0){
                            System.out.println("Average is : " + 0);
                        }else{
                            p.calculateAverage();
                        }
                        System.out.println();
                    }
                    break;


                default:
                    System.out.println("Program Exited");
                    return;
            }


        }

    }

    public static int takeInput(Scanner scanner){
        int value;
        while(true){
            if(scanner.hasNextInt()){
                value = scanner.nextInt();
                if(value < 0) {
                    System.out.println("Please enter positive value ");
                }else{
                    break;
                }
            }else{
                System.out.println("Please enter valid input (num).");
            }
        }
        return value;
    }

    public static Player createPlayer(Scanner scanner){
        String name;
        int id, runs, wickets, matches;

       scanner.nextLine();
       name = scanner.nextLine();

       System.out.print("Enter runs of the player : ");
       runs = takeInput(scanner);



        System.out.print("Enter wickets of the player : ");
        wickets = takeInput(scanner);

        System.out.print("Enter matches of the player : ");
        matches = takeInput(scanner);

        return new Player(name, matches, runs, wickets);
    }
}
