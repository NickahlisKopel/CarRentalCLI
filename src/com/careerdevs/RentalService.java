package com.careerdevs;

import java.util.Scanner;

public class RentalService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        int x = 0;
        Car car1 = new Car("Honda","Accord",false);
        Car car2 = new Car("Chevy","Cruze",false);
        Car car3 = new Car("Toyota","Corolla",false);
        Car[] garage = {car1,car2,car3};
        System.out.println("Welcome to the Car Rental CLI");
        while (!done){
            System.out.println("Available Cars:");
            for(int i = 0; i < garage.length;i++){
                if(!garage[i].isRented()){
                    System.out.println((i + 1)+ ")" + garage[i].getName());
                }else{
                    x++;
                }

            }
            System.out.println("Enter a number to select the car you'd like to rent");
            System.out.print("Selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine();
            while(selection > garage.length){
                System.out.println("Car selection invalid, please try again");
                System.out.print("Selection: ");
                selection = scanner.nextInt();
                scanner.nextLine();
            }
            while(garage[selection-1].isRented()){
                System.out.println("Car selection invalid, please try again");
                System.out.print("Selection: ");
                selection = scanner.nextInt();
                scanner.nextLine();
            }

            garage[selection -1].setRented(true);

            System.out.println("Thank you! You are now renting the " + garage[selection-1].getName());

            if (x == garage.length){
                done = true;
            }

        }
    }
}
