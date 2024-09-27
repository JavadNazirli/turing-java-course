package org.example.NumberGuessGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGameUtil {
    public int determinateChance(int interval){
        if(interval<10) return 2;
        if (interval<50) return 3;
        if (interval<200) return 4;
        if (interval<500&&interval>200) return  5;
        if(interval <1000) return 7;
        if (interval>1000) return 10;
        return 4;
    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number interval that you will guess (from 0) : ");
        Integer intervalNumber = scanner.nextInt();
        System.out.println("--------------");
        Random random = new Random();
        Integer computerNumber = random.nextInt(intervalNumber);
        System.out.println("Number which need to guest located (0-"+intervalNumber+") interval\n Good luck!\n-----------------------");
        Integer chance = determinateChance(intervalNumber);
        Integer [] guessedNumbersArray = new Integer[chance];
        Integer it = 0;
        do {
            System.out.println("You have "+chance+" chance left");
            System.out.print("Enter number :");
            guessedNumbersArray[it] = scanner.nextInt();
            if (guessedNumbersArray[it]== computerNumber) {
                System.out.println("Congrats! You found the number");
                break;
            }
            else{
                if(computerNumber>guessedNumbersArray[it]) System.out.println("Please enter a larger number.");
                else System.out.println("Please enter a smaller number.");
            }
            it++;
            chance--;
        } while(chance>0);
        System.out.println("-------------- Numbers you guessed -------------");

            for(int i=0;i< guessedNumbersArray.length;i++){
                if(guessedNumbersArray[i]==null) break;
                System.out.println(guessedNumbersArray[i]+" ");
        }

    }
}
