package ItemTracker;
import java.util.List;
import java.util.ArrayList;
    class ItemTracker {
    private List<Item> items;
    private int year;

    public ItemTracker() {
        this.items = new ArrayList<>();
        this.year = 2020;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void removeItem(Item item){
        this.items.remove(item);
    }
    public boolean removeItemByName(String name){
        for(Item item : items){
            if(item.getName().toLowerCase().equals(name)){
                items.remove(item);
                return true;
            }
        }
        return false;
    }
    public List<Item> getItems() {
        return items;
    }
    public void printAll(){
        for(Item item : items){
            System.out.println(item.toString());
        }
    }
    public void printWealth(){
        int sum = 0;
        for(Item item : getItems()){
            sum += item.getCurrentPrice(year);
        }
        System.out.println("The total value(value in "+year+
        ") of all items being tracked is "+sum);
    }

  
}
