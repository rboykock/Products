package pro.cherkassy.rboyko.products;

import pro.cherkassy.rboyko.Products;

/**
 * Created by rboyko on 06.11.16.
 */
public class Factory {
    public static Product create(int index){
        try {
            switch (Products.values()[index]){
                case BREAD:
                    return new Bread();
                case BUTTER:
                    return new Butter();
                case SAUSAGE:
                    return new Sausage();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
        return null;
    }
}
