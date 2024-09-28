package org.example.ShipBattleGame;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleGameUtils {
    public char[][] gameFieldCreater() {
        Random random = new Random();
        char[][] gameField = new char[7][7];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                gameField[i][j] = '0';
            }
        }
        int shipCount = 0;

        while (shipCount < 7) {
            int i = random.nextInt(7);
            int j = random.nextInt(7);

            if (gameField[i][j] == '0') {
                gameField[i][j] = '1';
                shipCount++;
            }
        }
        return gameField;
    }

    public void printGameField(char[][] gameField) {
        for (int k = 0; k < gameField.length; k++) {
            for (int m = 0; m < gameField[0].length; m++) {
                System.out.print(gameField[k][m] + "  ");
            }
            System.out.println();
        }
    }

    public void printInfo() {
        System.out.println("------------------------- Game info -------------------------");
        System.out.println("Welcome to the ship battle game!\n" +
                "The game conditions are as follows:\n" +
                "1. You will play the game in 7 vertical and 7 horizontal fields.\n" +
                "2. First you need to enter the horizontal coordinate (x) and then the vertical coordinate (y).\n" +
                "3. You will have 7 chances to shoot ships.\n" +
                "4. If you enter numbers between 1 and 7 as coordinates, the game will ask you to select the correct coordinates.\n" +
                "5. At the end, your final score will be shown and the maximum score is 7.\n" +
                "6. '2' are ships that you sunk\n\n" +
                "Good luck!!");
        System.out.println("--------------------------------------------------");
    }

    public void menu() {
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Welcome " + userName + " :)");
        System.out.println("-----");
        char[][] gameField = gameFieldCreater();
        int iterator = 7;
        int coordinateY = 0;
        int coordinateX = 0;
        int score = 0;
        while (iterator > 0) {
            System.out.println("You have " + iterator + " chance");
            iterator--;
            System.out.print("Enter coordinate x (horizontal) :");
            coordinateX = scanner.nextInt();
            System.out.print("Enter coordinate y (vertical) :");
            coordinateY = scanner.nextInt();
            if (isInputValid(coordinateX, coordinateY)) {
                if (gameField[coordinateX - 1][coordinateY - 1] == '1') {
                    score++;
                    System.out.println("YOU SUNK THE SHIP!\n------------------");
                    gameField[coordinateX - 1][coordinateY - 1] = 'X';
                } else {
                    System.out.println("MISS!\n------------------");
                }
            } else {
                System.out.println("PLEASE ENTER AVAILABLE COORDINATE!!!");
                iterator++;
            }
        }
        System.out.println("\n---------------------------\nCongratulation " + userName + "!!. Your score: " + score + "\n---------------------");
        printGameField(gameField);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        char answer;
        printInfo();
        do {

            menu();
            System.out.println("-----------------------\nDo you want to try again?\n if you want type -> Y // if you don't want to play again type any button except 'Y'");
            answer = scanner.nextLine().toLowerCase().charAt(0);
        } while (answer == 'y');
    }

    public boolean isInputValid(int coordinateX, int coordinateY) {
        if ((coordinateX > 0 && coordinateX < 8) && (coordinateY > 0 && coordinateY < 8)) {
            return true;
        }
        return false;
    }
}
