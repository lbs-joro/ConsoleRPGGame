import java.util.ArrayList;
import java.util.List;

public class Inventory <T extends Item> {
    List<T> itemList = new ArrayList<>();
    int capacity = 50;

    public void print(){
        for (int i = 0; i < itemList.size(); i ++){
            System.out.println(i + " " + itemList.get(i).name);
        }
    }

    public void add(T newItem){

        itemList.add(newItem );
    }

    public T getItem(int index){
        return itemList.get(index);
    }

}
