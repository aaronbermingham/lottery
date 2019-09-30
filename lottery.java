
/**
 * lottery.java
 * 
 * Program that simulates a small lottery game
 *
 * Author Aaron Bermingham
 */

import java.util.Scanner; // import java
import java.util.Random; //import Java class

public class lottery
{
    public static void main(String[] args)
    {
        System.out.print("\f"); // Clears screen everytime the program starts
        //Declaring variables
        Scanner stdIn = new Scanner(System.in); // Scanner variable for user input
        int num1; // Variable to hold user inputted number
        int num2;
        int num3;
        int ranNum1;
        int ranNum2;
        int ranNum3;
        int matchCount;
        int count = 0;
        int winCount = 0;
        String answer;

        //Print out on screen welcome and game explanation
        System.out.println("\n\t\t\t --- Lottery Game --- ");

        do{
            matchCount = 0;
            count ++; // Variable to count number of times the game has been played
            //Prompt and store user input and tests for valid numbers & duplicates
            System.out.println("Please enter your first number");
            num1 = stdIn.nextInt();
            while(num1 <1 || num1 > 45)
            {
                System.out.println("You have entered an invalid number, please enter a number between 1 and 45 or a number that is not a duplicate");
                System.out.println("Please enter your first number");
                num1 = stdIn.nextInt();
            }
            System.out.println("Please enter your second number");
            num2 = stdIn.nextInt();
            while(num2 <1 || num2 > 45 || num2 == num1)
            {
                System.out.println("You have entered an invalid number, please enter a number between 1 and 45 or a number that is not a duplicate");
                System.out.println("Please enter your second number");
                num2 = stdIn.nextInt();
            }
            System.out.println("Please enter your third number");
            num3 = stdIn.nextInt();
            while(num3 <1 || num3 > 45 || num3 ==num2 || num3 == num1 )
            {
                System.out.println("You have entered an invalid number, please enter a number between 1 and 45 or a number that is not a duplicate");
                System.out.println("Please enter your third number");
                num3 = stdIn.nextInt();
            }

            //Generate random numbers
            Random ranNum = new Random();
            ranNum1 = ranNum.nextInt(45)+1;
            ranNum2 = ranNum.nextInt(45)+1;
            ranNum3 = ranNum.nextInt(45)+1;

            while(ranNum2 == ranNum1)
            {
                ranNum2 = ranNum.nextInt(45)+1;
            }

            while(ranNum3 == ranNum2 || ranNum3 == ranNum1)
            {
                ranNum3 = ranNum.nextInt(45)+1;
            }
            System.out.println("\n\n\t\t****The winning numbers are" + " " + ranNum1 + " " + ranNum2 + " " + ranNum3 + "****");

            //Compare user and random numbers
            if(num1 == ranNum1 || num1 == ranNum2 || num1 == ranNum3)
            {
                matchCount ++;
            }
            if(num2 == ranNum1 || num2 == ranNum2 || num2 == ranNum3)
            {
                matchCount  ++;
            }
            if(num3 == ranNum1 || num3 == ranNum2 || num3 == ranNum3)
            {
                matchCount ++;
            }

            if(matchCount == 3)
            {
                System.out.println("\n\t\t****Congratulations! You have matched three numbers and won the game!!****\n");
                winCount ++;
            }

            else if(matchCount == 2)
            {
                System.out.println("You only matched" + " " + matchCount + " " + "number, better luck next time\n");
            }
            else if(matchCount == 1)
            {
                System.out.println("You only matched" + " " + matchCount + " " + "number, better luck next time\n");
            }
            else
            {
                System.out.println("\n\t\t Unfortunately you matched" + " " + matchCount + " " + "numbers and did not win this time\n");
            }
            
            //System.out.println(matchCount);
            
            //Play again?
            stdIn.nextLine();
            System.out.print("Do you want to play again? (y/n) ");
            answer = stdIn.nextLine();
        } while (answer.equalsIgnoreCase("y"));
        
        if(answer.equalsIgnoreCase("n"))
        {
            System.out.println("You have played"  + " " + count + " " + "game(s) and won" + " " + winCount + " " + "game(s)." );
        }
    }

}
