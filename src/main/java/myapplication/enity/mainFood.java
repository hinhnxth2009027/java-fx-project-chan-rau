package myapplication.enity;

import myapplication.models.modelsfood;

import java.util.Scanner;
public class mainFood {

    static foodType foodType;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("name : ");
            String name = scanner.nextLine();
            System.out.println("price : ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("img : ");
            String img = scanner.nextLine();
            System.out.println("food type : ");
            int foodtype = scanner.nextInt();
            scanner.nextLine();
            Food food = new Food(name,price,img,foodtype);
            modelsfood modelsfood = new modelsfood();
            modelsfood.newfood(food);
        }
    }
}
