package pro.cherkassy.rboyko;

import pro.cherkassy.rboyko.products.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by rboyko on 06.11.16.
 */
public class ProductsDemo {
    public static void main(String[] args){
        Inventory<Product> inventory=new Inventory<>();
        Product product;
        boolean isExit=true;
        do{
            System.out.print("Add the product to your inventory:\n\t[0] Bread\n\t[1] Butter\n\t[2] Sausage\n\t[3] Done\n");
            System.out.print("Chose:");
            int index=ProductsDemo.input();
            if(index==3){
                isExit=false;
            } else {
                if((product=Factory.create(index))!=null)
                    inventory.add(product);
            }
        }while (isExit);


        InventoryManager manager=new InventoryManager(inventory);
        System.out.print(manager);

    }

    public static int input(){
        Scanner scanner;
        int input;
        try {
            scanner=new Scanner(System.in);
            input=scanner.nextInt();
        }catch (InputMismatchException e){
            return -1;
        }

        return input;
    }
}
