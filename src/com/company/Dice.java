package com.company;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void drawingDices(int random) {
        switch (random) {
            case 1:
                System.out.println("+-------+\n|       |\n|   #   |\n|       |\n+-------+");
                break;
            case 2:
                System.out.println("+-------+\n| #     |\n|       |\n|     # |\n+-------+");
                break;
            case 3:
                System.out.println("+-------+\n|     # |\n|   #   |\n| #     |\n+-------+");
                break;
            case 4:
                System.out.println("+-------+\n| #   # |\n|       |\n| #   # |\n+-------+");
                break;
            case 5:
                System.out.println("+-------+\n| #   # |\n|   #   |\n| #   # |\n+-------+");
                break;
            case 6:
                System.out.println("+-------+\n| #   # |\n| #   # |\n| #   # |\n+-------+");
        }
    }
    public static int[] oneDiceGame()  {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("----<< Start Game >>-----");
        System.out.print("Predict amount of points [2/12] ");
        System.out.println("\nUser rolls the dices... \nwrite here:");
        int userPrediction = scanner.nextInt();
        int computerPrediction = random.nextInt(11) + 1;
        int userFirstDice = random.nextInt(5) + 1;
        int userSecondDice = random.nextInt(5) + 1;
        int userDiceSum = userFirstDice + userSecondDice;
        int userNotDiceSum = Math.abs(userDiceSum - userPrediction) * 2;
        if (userPrediction >= 2 && userPrediction <= 12) {
            Dice.drawingDices(userFirstDice);
            Dice.drawingDices(userSecondDice);
        } else {
            System.err.println("WRONG!!!");
        }
        System.out.println("On the dice fell " + userDiceSum + " points!." +
                "\nResult is " + userDiceSum + " - abs ( "
                + userDiceSum + " - " + userPrediction
                + " ) *2: " + userNotDiceSum);


        System.out.println("---------------------------------");
        System.out.println("Computer predicted : " + computerPrediction + " points!.");
        System.out.println("Computer rolls the dices...");
        int computerFirstDice = random.nextInt(5) + 1;
        int computerSecondDice = random.nextInt(5) + 1;
        int computerDiceSum = computerFirstDice + computerSecondDice;
        int computerNotDiceSum = Math.abs(computerDiceSum - computerPrediction) * 2;
        Dice.drawingDices(computerFirstDice);
        Dice.drawingDices(computerSecondDice);
        System.out.println("On the dice fell " + computerDiceSum + " points!.\nResult is " + computerDiceSum + " - abs ( " + computerDiceSum + " - " + computerPrediction + " ) *2: " + computerNotDiceSum);
        return new int[]{userDiceSum, userPrediction, userNotDiceSum,
                        computerDiceSum, computerPrediction, computerNotDiceSum};

    }
    public static void calculateAllRounds(int a[], int b[], int c[]){
        System.out.println(a[0]+" 1ая игра счёт компьютера");
        System.out.println(a[1]+" 1ая игра счёт человека");
        System.out.println(b[0]+" 2ая игра счёт компьютера");
        System.out.println(b[1]+" 2ая игра счёт человека");
        System.out.println(c[0]+" 2ая игра счёт компьютера");
        System.out.println(c[1]+" 2ая игра счёт человека");
        int totalComp = a[0]+b[0]+c[0];
        int totalUser = a[2]+b[2]+c[2];
        System.out.println("Total comp = "+totalComp);
        System.out.println("Total user = "+totalUser);

        System.out.println("\n----- Current score ----");
        System.out.println("User:  " + totalUser);
        System.out.println("Computer:  " + totalComp);
        if(totalComp>totalUser){
            System.out.println("Comp is ahead by " + (totalComp-totalUser));
        }
        else{
            System.out.println("User is ahead by " + (totalUser-totalComp));
        }
        System.out.println("________________________________________________________");
        System.out.println("----------------------FINISH GAME-----------------------");
        System.out.println("  Round      |     User           |      Computer      |");
        System.out.println("-------------+--------------------+--------------------|");
        System.out.println("             | Predicted: "+a[1]+"   | Predicted:"+a[4]+"   |");
        System.out.println("    - 1 -    | Dice:  "+a[0]+"    | Dice:"+a[3]+"     |");
        System.out.println("             | Result:"+a[2]+"| Result:"+a[5]+"|");
        System.out.println("-------------+--------------------+--------------------|");
        System.out.println("             | Predicted: "+b[1]+"   | Predicted:"+b[4]+"   |");
        System.out.println("    - 2 -    | Dice:"+b[0]+"      | Dice:"+b[3]+"     |");
        System.out.println("             | Result:"+b[2]+"| Result:"+b[5]+"|");
        System.out.println("-------------+-------------------+---------------------+");
        System.out.println("             | Predicted:"+c[1]+"    | Predicted:"+c[4]+"   |");
        System.out.println("    - 3 -    | Dice:"+c[0]+"      | Dice:"+c[3]+"     |");
        System.out.println("             | Result:"+c[2]+"| Result:"+c[5]+"|");
        System.out.println("-------------+--------------------+--------------------|");
        System.out.println("  Total      |  Points:           | Points:            |");
        System.out.println("             |     "+(a[2]+b[2]+c[2])+"              |" +
                "     "+(c[5]+a[5]+b[5])+"               |");
    }

}





