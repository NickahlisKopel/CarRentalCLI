package com.careerdevs.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString (String question){
        while(true){
            System.out.print(question+":");

            try {
                String inputString = scanner.nextLine();
                if(!inputString.trim().equals("")){
                    return  inputString.trim();
                }else{
                    System.out.println("You must enter a non empty String, try again.");
                }

            }catch (InputMismatchException e){
                System.out.println("You must enter a String, try again.");

            }
        }

    }

    public static int readInt (String question, int min, int max){
        while(true){
            System.out.print(question+":");

            try{
                int temp = scanner.nextInt();
                scanner.nextLine();
                if(temp >= min && temp <= max){
                    return temp;
                }

                System.out.println("You must enter a valid integer between "+min+" and "+max+", try again.");

            } catch(InputMismatchException e){
                System.out.println("You must enter an integer, try again.");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Not Available.");
            }



        }


    }
}
