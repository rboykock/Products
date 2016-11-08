package pro.cherkassy.rboyko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by rboyko on 06.11.16.
 */
public class Inventory<T> implements Iterable<T>{
    protected ArrayList<T> items=new ArrayList<>();
    private int i=0;
    public void add(T item){
        this.items.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    public int getTotalItems(){
        return items.size();
    }
}
