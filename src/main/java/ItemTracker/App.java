package ItemTracker;
import java.util.Scanner;
public class App {
    private int setYear;
    private ItemTracker itemTracker;
    // TODO: generate tests
    public App() {
        this.setYear = 2020;
        this.itemTracker = addStartingItems();
    }
    public void setYear(int year){
        this.setYear = year;
    }
    public int getYear(){
        return this.setYear;
    }
    public void setYear(ItemTracker itemTracker){
        this.itemTracker = itemTracker;
    }
    public ItemTracker getItemTracker(){
        return this.itemTracker;
    }

    private ItemTracker addStartingItems(){
        Item item1 = new Item("Iphone XR", "Iphone from Apple of the XR variaty", 6000.0, 2018, "Gadget");
        Item item2 = new Item("Gold Bar", "Gold bar made from melted gold", 10000.0, 2000, "Metal");
        Item item3 = new Item("Common Project", "Original Achilles, White", 2500.0, 2020, "Shoe");
        ItemTracker itemTracker = new ItemTracker();
        itemTracker.addItem(item1);
        itemTracker.addItem(item2);
        itemTracker.addItem(item3);
        return itemTracker;
    }

    private void commandDisplay(){
        System.out.printf("Commands:\nSearch - Search for items\nStop - stops the program\n");
        System.out.printf("List - List all items\nWealth - Sums of values of all items\n");
        System.out.printf("Add - Add new item\nRemove - Remove an item\n");
        System.out.printf("Set year - Set current year. default 2020\nCommands - Go back to command\n");
        System.out.println("\n\nEnter command:");
    }

    private void start(){
        System.out.println("\n\nWelcome to Item Tracker 420");
        commandDisplay();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        App app = new App();

        String command = sc.nextLine().toLowerCase();

        while(!command.equals("stop")){
            
            if(command.equals("list")){
                it.printAll();
            }
            if(command.equals("command")||command.equals("commands")){
                commandDisplay();
            }
            if(command.equals("wealth")){
                int sum = 0;
                for(Item item : it.getItems()){
                    sum += item.getCurrentPrice(app.getYear());
                }
                System.out.println("The total value(value in "+app.getYear()+
                ") of all items being tracked is "+sum);
            }
            if(command.equals("set year")||command.equals("set")){
                System.out.println("Insert Year:");
                app.setYear = Integer.valueOf(sc.nextLine());
                System.out.println("The year is set to " + app.getYear());
            }
            if(command.equals("add")){
                System.out.println("Name:");
                String newname = sc.nextLine();
                System.out.println("Description:");
                String newdescription = sc.nextLine();
                System.out.println("Purchase Price:");
                double newprice = Double.valueOf(sc.nextLine());
                System.out.println("Year of Purchase:");
                int newyear = Integer.valueOf(sc.nextLine());
                System.out.println("Type/category:");
                String newtype = sc.nextLine();
                newtype = newtype.substring(0,1).toUpperCase() + newtype.substring(1).toLowerCase();
                it.addItem(new Item(newname, newdescription, newprice, newyear, newtype));
                System.out.println("The item " + newname + " is added.");
            }
            if(command.equals("remove")){
                System.out.println("Name of item to remove:");
                String t = sc.nextLine();
                String removename = t.toLowerCase();
                boolean found = false;
                for(Item item : it.getItems()){
                    if(item.getName().toLowerCase().equals(removename)){
                        it.removeItem(item);
                        found = true;
                        System.out.println(t + " has been removed.");
                        break;
                    }
                }
                if(!found){
                    System.out.println("Can not find item " + t);
                }
            }
            if(command.equals("search")){
                System.out.printf("Search commands:\nName - Search by name\nYear - Search by Year\n");
                System.out.printf("Type - Search by Type/category\nPrice - Search by Price Threshold\n");
                command = sc.nextLine().toLowerCase();
                if(command.equals("name")){
                    System.out.println("Name to search:");
                    String searchname = sc.nextLine().toLowerCase();
                    it.getItems().stream()
                    .filter(t -> t.getName().toLowerCase().equals(searchname))
                    .map(Item::toString)
                    .forEach(System.out::println);
                }
                if(command.equals("year")){
                    System.out.println("Year to search:");
                    int searchyear = Integer.valueOf(sc.nextLine());
                    it.getItems().stream()
                    .filter(t -> t.getYear() == searchyear)
                    .map(Item::toString)
                    .forEach(System.out::println);
                }
                if(command.equals("type")){
                    System.out.println("Type to search:");
                    String searchtype = sc.nextLine().toLowerCase();
                    it.getItems().stream()
                    .filter(t -> t.getType().toLowerCase().equals(searchtype))
                    .map(Item::toString)
                    .forEach(System.out::println);
                }
                if(command.equals("price")){
                    System.out.println("Price to search:");
                    Double searchprice = Double.valueOf(sc.nextLine());
                    it.getItems().stream()
                    .filter(t -> t.getPrice() < searchprice)
                    .map(Item::toString)
                    .forEach(System.out::println);
                }
            }
            command = sc.nextLine();
        }
        sc.close();
    }

    

   

    
}
