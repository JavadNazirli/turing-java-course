package org.example.ShipBattleGame;

import java.util.Scanner;

public class ShipBattleGame {
    public static void main(String[] args) {
        ShipBattleGameUtils shipBattleGameUtils = new ShipBattleGameUtils();
        Scanner scanner = new Scanner(System.in);
        char answer;
        do{
            shipBattleGameUtils.startGame();
            System.out.println("-----------------------\nDo you want to try again?\n if you want type -> Y // if you don't want to play again type any button except 'Y'");
            answer = scanner.nextLine().toLowerCase().charAt(0);
        }while(answer=='y');

    }
}
