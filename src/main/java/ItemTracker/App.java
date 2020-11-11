package ItemTracker;
import java.util.Scanner;
public class App {
    private ItemTracker itemTracker;
    private Scanner reader;
    // TODO: generate tests

    public App() {
        this.reader = new Scanner(System.in);
        this.itemTracker = addStartingItems();
    }

    public void start(){
        System.out.println("\n\nWelcome to Item Tracker 420");
        commandDisplay();
        boolean endProgram = false;
        while(!endProgram) {
            String command = reader.nextLine().toLowerCase();
            endProgram = processInput(command);
        }
        System.out.println("Program over");
        reader.close();
    }

    private boolean processInput(String input){
        boolean toQuit = false;

        switch (input) {
            case "commands":
                commandDisplay();
                break;
            
            case "list":
                itemTracker.printAll();
                break;

            case "wealth":
                itemTracker.printWealth();
                break;

            case "set year":
                setYearApp();
                break;
            
            case "add":
                addItemApp();
                break;
            
            case "remove":
                removeItemApp();
                break;

            case "search":
                searchItem();
                break;

            case "quit":
                toQuit = true;
                break;

            default:
                System.out.println("Unknown command");
                break;
        }
        return toQuit;
    }

    private void commandDisplay(){
        System.out.printf("Commands:\nSearch - Search for items\nQuit - Quit the program\n");
        System.out.printf("List - List all items\nWealth - Sums of values of all items\n");
        System.out.printf("Add - Add new item\nRemove - Remove an item\n");
        System.out.printf("Set year - Set current year. default 2020\nCommands - Go back to command list\n");
        System.out.println("\n\nEnter command:");
    }

    private void setYearApp(){
        System.out.println("Insert Year:");
        itemTracker.setYear(Integer.valueOf(reader.nextLine()));
        System.out.println("The year is set to " + itemTracker.getYear());
    }

    private void addItemApp(){
        System.out.println("Name:");
        String itemName = reader.nextLine();
        System.out.println("Description:");
        String itemDescription = reader.nextLine();
        System.out.println("Purchase Price:");
        double itemPrice = Double.valueOf(reader.nextLine());
        System.out.println("Year of Purchase:");
        int itemYear = Integer.valueOf(reader.nextLine());
        System.out.println("Type/category:");
        String itemType = reader.nextLine();
        itemType = itemType.substring(0,1).toUpperCase() + itemType.substring(1).toLowerCase();
        itemTracker.addItem(new Item.Builder(itemName, itemType)
        .price(itemPrice).year(itemYear).description(itemDescription).build());
        System.out.println("The item " + itemName + " is added.");
    }
    private void removeItemApp(){
        System.out.println("Name of item to remove:");
        String nameToRemove = reader.nextLine();
        String nameLowerCase = nameToRemove.toLowerCase();
        boolean removed = itemTracker.removeItemByName(nameLowerCase);
        System.out.println(removed ? nameToRemove + " has been removed." : "Can not find item " + nameToRemove);
    }
    private void searchItem(){
        System.out.printf("Search commands:\nName - Search by name\nYear - Search by Year\n");
        System.out.printf("Type - Search by Type/category\nPrice - Search by Price Threshold\n");
        String searchCommand = reader.nextLine().toLowerCase();
        switch (searchCommand) {
            case "name":
                System.out.println("Name to search:");
                String searchName = reader.nextLine().toLowerCase();
                itemTracker.getItems().stream()
                .filter(t -> t.getName().toLowerCase().equals(searchName))
                .map(Item::toString)
                .forEach(System.out::println);
                break;

            case "year":
                System.out.println("Year to search:");
                int searchYear = Integer.valueOf(reader.nextLine());
                itemTracker.getItems().stream()
                .filter(t -> t.getYear() == searchYear)
                .map(Item::toString)
                .forEach(System.out::println);
                break;
            
            case "type":
                System.out.println("Type to search:");
                String searchType = reader.nextLine().toLowerCase();
                itemTracker.getItems().stream()
                .filter(t -> t.getType().toLowerCase().equals(searchType))
                .map(Item::toString)
                .forEach(System.out::println);
                break;
            
            case "price":
                System.out.println("Price to search:");
                Double searchPrice = Double.valueOf(reader.nextLine());
                itemTracker.getItems().stream()
                .filter(t -> t.getPrice() < searchPrice)
                .map(Item::toString)
                .forEach(System.out::println);
                break;
        
            default:
                System.out.println("Unknown search format");
                break;
        }
    }

    private ItemTracker addStartingItems(){
        Item item1 = new Item.Builder("Iphone XR", "Gadget")
        .price(6000.0).year(2018).description("Iphone from Apple of the XR variaty").build();
        Item item2 = new Item.Builder("Gold Bar", "Metal")
        .price(10000.0).year(2000).description("Gold bar made from melted gold").build();
        Item item3 = new Item.Builder("Common Project", "Shoe")
        .price(2500.0).year(2020).description("Original Achilles, White").build();
        
        
        ItemTracker itemTracker = new ItemTracker();
        itemTracker.addItem(item1);
        itemTracker.addItem(item2);
        itemTracker.addItem(item3);
        return itemTracker;
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
}
