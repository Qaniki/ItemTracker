package ItemTracker;

public class Item implements Comparable<Item> {
    private String name;
    private String description;
    private double price;
    private int year;
    private String type;

    private static final double AnnualDepreciationGadget = 0.30;
    private static final double AnnualDepreciationMetal = -0.05;
    private static final double AnnualDepreciationShoe = 0.10;

    /**
     * Constructs a new {@code Item} that holds information
     * about the item itself.
     *
     * @param  name Name of item
     * @param  description Description of item
     * @param  price Item price at purchase
     * @param  year Year of purchase
     * @param  type The type of the item, ie. Gadget, Shoe
     */
    public Item(String name, String description, Double price, int year, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.year = year;
        this.type = type;
    }
    /**
     * Get name of item
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " [description=" + description + ", price=" + price + ", year=" + year + ", type=" + type + "]";
    }

    @Override
    public int compareTo(Item item) {
        int c = this.name.compareTo(item.name);
        if(c == 0){
            c = (int) (this.price - item.price);
        }
        return c;
    }

    public double getCurrentPrice(int year){
        double s;
        int age = year - this.year;
        switch (this.type) {
            case "Gadget":
                s = AnnualDepreciationGadget;
                break;
            case "Metal":
                s = AnnualDepreciationMetal;
                break;
            case "Shoe":
                s = AnnualDepreciationShoe;
                break;
            default:
                s = 0;
                break;
        }
        return this.price * Math.pow(1-s,age);
    }
}
