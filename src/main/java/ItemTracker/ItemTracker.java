package ItemTracker;
import java.util.List;
import java.util.ArrayList;
public class ItemTracker {
    private List<Item> items;

    public ItemTracker() {
        this.items = new ArrayList<>();
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }
    public List<Item> getItems() {
        return items;
    }
    public void printAll(){
        for(Item item : items){
            System.out.println(item.toString());
        }
    }
}
