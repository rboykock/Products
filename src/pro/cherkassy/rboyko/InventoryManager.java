package pro.cherkassy.rboyko;

import pro.cherkassy.rboyko.Inventory;
import pro.cherkassy.rboyko.products.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rboyko on 06.11.16.
 */
public class InventoryManager {
    protected Inventory<Product> inventory;
    public InventoryManager(Inventory<Product> inventory){
        this.inventory=inventory;
    }

    public int getTotalItems(){
        return inventory.getTotalItems();
    }

    public HashMap<Product,Integer> getTotalByItems(){
        HashMap<Product,Integer> items=new HashMap<>();
        int total;
        for (Product product:inventory){
            if(items.containsKey(product)){
                total=items.get(product)+1;
                items.replace(product,total);
            }else{
                items.put(product,1);
            }
        }
        return items;
    }

    @Override
    public String toString() {
        HashMap<Product,Integer> totalByItems=getTotalByItems();
        StringBuilder string=new StringBuilder("Items in the inventory:\n\t");
        double totalPrice=0;
        if(getTotalItems()>0) {
            for (Map.Entry<Product, Integer> entry : totalByItems.entrySet()) {
                double tPrice=entry.getValue()*entry.getKey().getQuantity()*entry.getKey().getPrice();
                string.append(String.format("%-20s%dq %15.2f price%20.2f total\n\t", entry.getKey().getName(), entry.getValue(),entry.getKey().getPrice(), tPrice));
                totalPrice+=tPrice;
            }
        }else
            string.append("empty");
        string.append(String.format("\nTotal items: %d Total price: %.2f", getTotalItems(),totalPrice));
        return string.toString();
    }


}
