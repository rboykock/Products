package pro.cherkassy.rboyko.products;

import pro.cherkassy.rboyko.interfaces.IProduct;

/**
 * Created by rboyko on 06.11.16.
 */
public class Product implements IProduct {
    protected String name;
    protected double price;
    protected int quantity;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        return this.hashCode()==obj.hashCode();
    }

    @Override
    public int hashCode() {
        int result=name.hashCode();
        result=31*result+Double.valueOf(price).hashCode();
        result=31*result+quantity;
        return result;
    }
}
