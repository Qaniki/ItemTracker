package ItemTracker;
/** 
 * An Item class object represent a real life object that a user would like to keep track of. 
 * Item contains information such name, description, price at purchase, year of purchase and 
 * the type of item it falls under. 
 * @author  René Schou
 * @see     ItemTracker
 * @version   1.0
 */
public class Item implements Comparable<Item> {
    private final String name;
    private final String description;
    private final double price;
    private final int year;
    private final String type;

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

    public static class Builder{
        private final String name;
        private final String type;
        private double price = 0;
        private int year = 0;
        private String description = "";
        public Builder(String name, String type) {
            this.name = name;
            this.type = type;
        }
        public Builder price(double value){
            price = value; 
            return this; 
        }
        public Builder year(int value){
            year = value; 
            return this; 
        }
        public Builder description(String string){
            description = string; 
            return this; 
        }
        public Item build() {
        return new Item(this);
        }
    }
    private Item(Builder builder) {
        name = builder.name;
        description = builder.description;
        price = builder.price;
        year = builder.year;
        type = builder.type;
    }
    public static void main(String[] args) {
        Item itemtest = new Builder("Common Project", "Shoe")
        .price(3000.0).year(2020).description("Original").build();
        System.out.println(itemtest);
    }

    /**
     * Get the name of item
     * @return name of item
     */
    public String getName() {
        return name;
    }
    /**
     * Set the name of item
     * @param name The name to change into
     */
    /**
     * Get the description of item
     * @return description of item
     */
    public String getDescription() {
        return description;
    }
    /**
     * Set the description of item
     * @param description The description to change into
     */
    /**
     * Get the price of item at the time of purchase
     * @return price of item
     */
    public double getPrice() {
        return price;
    }
    /**
     * Set the price of item
     * @param price The price to change into
     */
    /**
     * Get the year of purchase of item
     * @return year of purchase
     */
    public int getYear() {
        return year;
    }
    /**
     * Set the year of purchase of item
     * @param price The year to change into
     */

    /**
     * Get the type of item
     * @return type of item
     */
    public String getType() {
        return type;
    }
    /**
     * Set the type of item
     * @param type The type to change into
     */

    /**
     * String representation of item
     */
    @Override
    public String toString() {
        return name+" [description="+description+", price=" + price + ", year=" + year + ", type=" + type + "]";
    }
    /**
     * Comparing two item objects, first using String compare on names, then 
     * use price to compare.
     * @param item The item to compare to
     * @return values < 0, 0 or > 0
     */
    @Override
    public int compareTo(Item item) {
        int c = this.name.compareTo(item.name);
        if(c == 0){
            c = (int) (this.price - item.price);
        }
        return c;
    }
    /**
     * Get the current price of item adjusted for appreciation or depreciation
     * over the years
     * @param year The year used calculate the time difference to year of purchase
     * @return price of item given year
     */
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
