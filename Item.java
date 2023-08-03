public class Item {
    private final String name;
    private final int calories;
    private double price;
    private int InitialStock;
    private final int EndStock;

    /**
     * This generates an item object which includes the variables name, price, InitialStock, calories, and EndStock.
     *
     * @param name     the name of the item
     * @param calories the calories
     * @param price    the price of the item
     * @param stock    the amount of items
     */
    public Item(String name, int calories, double price, int stock) {
        this.name = name;
        this.price = price;
        this.InitialStock = stock;
        this.calories = calories;
        this.EndStock = stock;
    }

    /**
     * Returns the string name.
     *
     * @return the name of the item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the int calories.
     *
     * @return the amount of calories of the item.
     */
    public int getCalories() { return this.calories; }

    /**
     * Returns the double price.
     *
     * @return the price of the item.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This sets the price of the item has to the double price.
     *
     * @param price the price that will be set  for the item object.
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Returns the int stock.
     *
     * @return the stock of the item.
     */
    public int getStock() {
        return InitialStock;
    }

    /**
     * This sets the number of stock the item has to the int stock.
     *
     * @param stock the number of stock that will be set for the item object.
     */
    public void setStock(int stock) { this.InitialStock = stock; }

    /**
     * Returns the int EndStock.
     *
     * @return the stock of the item.
     */
    public int getEndStock() {
        return this.EndStock;
    }

    public int getInitialStock() { return this.InitialStock; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + calories;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + InitialStock;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (calories != other.calories)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        return InitialStock == other.InitialStock;
    }
}
