public class Money {
    private final int value;
    private int quantity;

    /**
     * This generates a money object which includes the variables value and quantity.
     *
     * @param value    the value of money
     * @param quantity the quantity of money
     */
    public Money(int value, int quantity)
    {
        this.value = value;
        this.quantity = quantity;
    }

    /**
     * Returns the double value.
     *
     * @return the value of value.
     */
    public double getValue() { return this.value; }

    /**
     * Returns the int quantity.
     *
     * @return the value of quantity.
     */
    public int getQuantity() { return this.quantity; }

    /**
     * This sets the number of quantity the money has to the int quantity.
     *
     * @param quantity the number of quantity that will be set for the money object.
     */
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
