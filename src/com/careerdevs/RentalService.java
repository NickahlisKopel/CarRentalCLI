package com.careerdevs;

import com.careerdevs.ui.CLI;

import java.util.Objects;
import java.util.Scanner;

public class RentalService {
    static Car car1 = new Car("Honda","Accord",false, "company");
    static Car car2 = new Car("Chevy","Cruze",false,"company");
    static Car car3 = new Car("Toyota","Corolla",false,"company");
    public static Car[] garage = {car1,car2,car3};
    public static void main(String[] args) {

        System.out.println("Welcome to the Car Rental CLI");
        mainMenu();
    }

    public static void mainMenu(){
        int x = 0;
        for(int i = 0; i < garage.length;i++){
            if(!garage[i].isRented()){
                x++;
            }
        }
        int selection = CLI.readInt("Would you like to:\n1)Rent("+x+" Cars Available)\n2)Return("+(garage.length - x)+" Cars Available)\nSelection",1,2);
        if(selection == 1 && x == 0){
            System.out.println("Not Available");
            mainMenu();
        }else if (selection == 2 && garage.length - x == 0){
            System.out.println("Not Available");
            mainMenu();
        }else if(selection == 1){
            rentCar();

        }else{
            returnCar();
        }
    }

    public static void rentCar(){
        System.out.println("Available Cars:");
        for(int i = 0; i < garage.length;i++){
            if(!garage[i].isRented()){
                System.out.println((i + 1)+ ")" + garage[i].getName());
            }
        }
        int selection = CLI.readInt("What car would you like to rent?",1,garage.length);
        String confirm  = CLI.readString("Are you sure you want to rent The "+garage[selection-1].getName()+"?\nConfirm y/n");
        if(confirm.equals("n") || confirm.equals("no") || confirm.equals("N") || confirm.equals("NO") || confirm.equals("No")){
            rentCar();
        }
        String name = CLI.readString("What is the name you would like to use to return your rental?\nEnter Name");
        garage[selection-1].setRenterName(name);
        garage[selection-1].setRented(true);
        mainMenu();


    }

    public static void returnCar(){
        System.out.println("Available Cars:");
        int x = 0;
        for(int i = 0; i < garage.length;i++){
            if(garage[i].isRented()){
                x++;
                System.out.println((i + 1)+ ")" + garage[i].getName());
            }else{
                x++;
            }
        }
        int selection = CLI.readInt("What Car are you returning?",1,x);

        if(!garage[selection-1].isRented()){
            System.out.println("Car Not Available");
            returnCar();
        }

        String name = CLI.readString("Enter the name you used to rent The "+garage[selection-1].getName()+"\nEnter Name");

        if(garage[selection-1].getRenterName().equals(name)){
            garage[selection-1].setRented(false);
            garage[selection-1].setRenterName("company");
            System.out.println("Thank you for returning the car.");
        }else{
            int again = CLI.readInt("Wrong name, would you like to 1) try again or 2) return to Main Menu?",1,2);
            if (again == 1){
                returnCar();
            }else{
                mainMenu();
            }

        }
        mainMenu();
    }

}
