package org.example.WeekPlanner;

import java.util.Scanner;

public class WeekPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] planArray = new String[7][2];
        planArray[0][0] = "Sunday";
        planArray[0][1] = "have a rest and watch movie";
        planArray[1][0] = "Monday";
        planArray[1][1] = "go to course (Informatika); Do English homework  ";
        planArray[2][0] = "Tuesday";
        planArray[2][1] = "go to course (English); Do IQ homework";
        planArray[3][0] = "Wednesday";
        planArray[3][1] = "go to course (IQ); Do Informatika homework";
        planArray[4][0] = "Thursday";
        planArray[4][1] = "go to course (Informatika); Do English homework";
        planArray[5][0] = "Friday";
        planArray[5][1] = "go to course (English); Do IQ homework ";
        planArray[6][0] = "Saturday";
        planArray[6][1] = "go to course (IQ); Do Informatika homework";


        while (true) {
            System.out.print("Please, input the day of the week : ");
            String weekDay = scanner.nextLine().trim().toLowerCase();

            if (weekDay.equals("exit")) {
                System.out.println("Exiting the program!");
                break;
            }
            switch (weekDay) {
                case "sunday":
                    System.out.println("Your tasks for Sunday: " + planArray[0][1]);
                    break;
                case "monday":
                    System.out.println("Your tasks for Monday: " + planArray[1][1]);
                    break;
                case "tuesday":
                    System.out.println("Your tasks for Tuesday: " + planArray[2][1]);
                    break;
                case "wednesday":
                    System.out.println("Your tasks for Wednesday: " + planArray[3][1]);
                    break;
                case "thursday":
                    System.out.println("Your tasks for Thursday: " + planArray[4][1]);
                    break;
                case "friday":
                    System.out.println("Your tasks for Friday: " + planArray[5][1]);
                    break;
                case "saturday":
                    System.out.println("Your tasks for Saturday: " + planArray[6][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
            }
        }
    }
}

