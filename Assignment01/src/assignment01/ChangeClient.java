

package assignment01;
/**
 *  @author Tan Hong Rui Freeman
 *  @version 1.0 
 */ 
import java.util.Scanner;

public class ChangeClient 
{
    /**Method to store output of My student information and tutor name
     */ 
    public static void StudentInfo() // For the StudentInfo
    {
        System.out.println("Name: Tan Hong Rui Freeman");
        System.out.println("Student No: 34177608");
        System.out.println("Enrolment: Computer Science ICT167(A)");
        System.out.println("Tutor Name: Tan Han Kee");
    }
    
    /** 9 hard-coded inputs to test the method
     * contains 9 inputs and prints out the name and coins of all the hard-coded input
     */
//  
//    public static String[][] testInput() // For the Testing-inputs
//    {
//        String[][] str = new String[9][2];
//        str[0][0] = "Jane";
//        str[0][1] = "30";
//        
//        str[1][0] = "John";
//        str[1][1] = "50";
//        
//        str[2][0] = "Fred";
//        str[2][1] = "95";
//        
//        str[3][0] = "Wilma";
//        str[3][1] = "75";
//        
//        str[4][0] = "Jane";
//        str[4][1] = "35";
//        
//        str[5][0] = "Timmy";
//        str[5][1] = "25";
//        
//        str[6][0] = "Jenny";
//        str[6][1] = "40";
//        
//        str[7][0] = "Jane";
//        str[7][1] = "85";
//        
//        str[8][0] = "John";
//        str[8][1] = "45";
//        
//        return str;             
//    } // END OF TESTINPUT
//    
    
    /** For the user-inputs if they want to key in any customer name and coins
     * Contain size of [9][2] arrays to store the user input
     * Coin value must be in range of 5 to 95 and must be multiple by 5 time tables
     * If it is incorrect coin values it will prompt the user to enter the coin values again
     * Ask the user too if they have any more person to enter in Yes or No. ( Y/N )
     * @return the output values 
     */
    public static String[][] input() // For the user-inputs
    {
        Scanner read = new Scanner(System.in);
        System.out.println("--- Please Enter at least Nine[9] person ---");
        String[][] str = new String[9][2];
        
        for(int i = 0; i<9; i++)
        {
            System.out.print("\nPlease enter the name of the person: ");
            str[i][0] = read.nextLine();
            do
            {
                System.out.print("Please enter the coin value for the person (range 5 to 95, multiple of 5) :");
                str[i][1] = read.nextLine();
                if(Integer.parseInt(str[i][1]) >= 5 && Integer.parseInt(str[i][1]) <= 95 && Integer.parseInt(str[i][1]) % 5 == 0)
                {
                    break;
                }
                else
                {
                    System.out.println("Incorrect coin values. Must be in the range 5 to 95, and multiple of 5. ");
                }    
            }while(true);
            System.out.print("Do you have more person to enter (Y/N): ");
            String YesNo = read.nextLine();
            if(YesNo.equalsIgnoreCase("N"))
            {
                break;
            }
        }
        return str;
    } // END OF INPUT
    
    /**The main method that has all the programming to store names,coins and calculate the value of Change
     * And doing the Menus of choice using switch case
     * Choice 1 : Search the specific name and coin the user want
     * Choice 2 : Find the smallest coin and display the name and the coin
     * Choice 3 : Find the largest coin and display the name and the coin
     * Choice 4 : Find the biggest coin denominator and display it
     * Choice 5 : Exiting the Program
     * Default : Incase of invalid choice it will prompt the user to enter the choice again.
     * @param args command-line arguments
     */
    public static void main(String[] args) // Main Method
    {
        Scanner read = new Scanner(System.in);
        StudentInfo(); // Calling the StudentInfo
        System.out.println();
        // This is for testing the input you can comment it to remove from testing.
        // String[][] str = testInput();
        // uncomment this to do the input testing and comment the testInput.
        String[][] str = input();
        int len = 0;
        System.out.println("Values to be created as an object: ");
        
        for(int i = 0; i < str.length; i++)
        {
            if(str[i][0] != null)
            {
                System.out.println("Name: " + str[i][0] + ", Change: " + str[i][1] );
                len++;
            }
        }
        
        
        // Calcuation for the mulitpler of 5 and number range must be 5 to 95.
        Change[] change = new Change[9];
        int count = 0; 
        for(int i = 0; i < len; i++)
        {
            if(Integer.parseInt(str[i][1]) >= 5 && Integer.parseInt(str[i][1]) <= 95 && Integer.parseInt(str[i][1]) % 5 == 0)
            {
                if (count == 0)
                {
                    change[count] = new Change(str[i][0], Integer.parseInt(str[i][1]));
                    count++;
                }
                else
                {
                    int flag = 0;
                    for(int j = 0; j < count; j++)
                    {
                        if(change[j].getName().equals(str[i][0]))
                        {
                            change[j].totalCoin(Integer.parseInt(str[i][1]));
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0)
                    {
                        change[count] = new Change(str[i][0], Integer.parseInt(str[i][1]));
                        count++;
                    }
                }
            }
            else
            {
                System.out.println("Incorrect coin values. Must be in the range 5 to 95, and multiple of 5. ");
            }
        } // END OF FOR LOOP
        
        // For the Menu.
        do // Start of DO
        {
            System.out.println("Menu");
            System.out.println("[1] Find name and display change. ");
            System.out.println("[2] Find the smallest change. ");
            System.out.println("[3] Find the largest change. ");
            System.out.println("[4] Calculate and display the largest number of coin denomination and the total number of the coin ");
            System.out.println("[5] Exit.");
            System.out.print("Choice: ");
            int Menu = Integer.parseInt(read.nextLine());
            
            switch(Menu)
            {
                case 1: // Check for the user input name.
                    System.out.print("Enter name: ");
                    String name = read.nextLine();
                    System.out.println("Customer: ");
                    int flag = 0;
                    for(int i = 0; i < count; i++)
                    {
                        if(change[i].getName().equals(name))
                        {
                            System.out.println(change[i].toString());
                            flag = 1;
                        }
                    }
                    if(flag == 0 )
                    {
                        System.out.println(name + " not found. ");
                    }
                    break;
                    
                case 2: // Case to find the smallest coin amount.
                    int smallChange = change[0].getCoin();
                    int smallest = 0;
                    for(int i = 0; i < count; i++)
                    {
                        if(smallChange > change[i].getCoin())
                        {
                            smallChange = change[i].getCoin();
                            smallest = i;
                        }
                    }
                    System.out.println("Smallest coin amount");
                    System.out.println(change[smallest].toString());
                    break;
                    
                case 3: // Case to find the largest coin amount.
                    int largeChange = change[0].getCoin();
                    int largest = 0;
                    for(int i = 0; i < count; i++)
                    {
                        if(largeChange < change[i].getCoin())
                        {
                            largeChange = change[i].getCoin();
                            largest = i;
                        }
                    }
                    System.out.println("Largest coin amount : ");
                    System.out.println(change[largest].toString());
                    break;
                    
                case 4 : // Case to find the total coin amounts.
                    
                    int temp=0;
                    int oneDollar = 0;
                    int fifty = 0;
                    int twenty = 0;
                    int ten = 0;
                    int five = 0;
                   
                    //for loop runs through the array and sum up all the denominations to the above declared variables
                    for(int i = 0; i < count; i++)
                    {
                        oneDollar += change[i].forOneDollar();
                        fifty += change[i].forFifty();
                        twenty += change[i].forTwenty();
                        ten += change[i].forTen();
                        five += change[i].forFive();
                        change[i].resetCoin();
                    }
                     
                //stores temp as the biggest number of denomination      
                    temp = oneDollar;
                    if(temp<fifty)
			temp = fifty;
                    if(temp<twenty)
			temp = twenty;
                    if(temp<ten)
			temp = ten;
                    if(temp<five)
			temp = five;
                
                //prints out if any of the denomination is the biggest number.
                    if(temp == oneDollar)
			System.out.println("$1 " + oneDollar);
                    if(temp == fifty)
			System.out.println("50 cent " + fifty);
                    if(temp == twenty)
			System.out.println("20 cent " + twenty);
                    if(temp == ten)
			System.out.println("10 cent " + ten);
                    if(temp == five)
			System.out.println("5 cent " + five);          
                    break;
                
                case 5: // Exiting the program
                    System.exit(0);
                default: // Invalid choice if user key in other numbers then 1-5.
                    System.out.println("Invalid choice!!.");
            }
        }while(true); // End of DO-WHILE
    } // END OF MAIN   
} // END OF CHANGECLIENT 
