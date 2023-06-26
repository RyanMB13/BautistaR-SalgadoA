import java.util.Scanner;
import java.util.ArrayList;

class Item {
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
        return  this.EndStock;
    }

}

class Money{
    private final double value;
    private int quantity;

    /**
     * This generates a money object which includes the variables value and quantity.
     *
     * @param value    the value of money
     * @param quantity the quantity of money
     */
    public Money(double value, int quantity)
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

public class VendingMachine {
    private final ArrayList<Item> itemList;
    private final ArrayList<Money> userCashList;
    private double userCash;
    private double userBalance;
    private final ArrayList<Money> paymentList;
    private double totalPayment;
    private final ArrayList<Money> VMChangeList;
    private double VMChange;
    private double totalSales;
    private int sold;

    /**
     * This generates a VendingMachine object which includes the variables itemList, userCashList, userCash, userBalance,
     * VMChangeList, VMChange, and totalSales.
     */
    public VendingMachine() {
        this.itemList = new ArrayList<>();
        this.userCashList = new ArrayList<>();
        this.userCash = 0.00;
        this.userBalance = 0.00;
        this.paymentList = new ArrayList<>();
        this.totalPayment = 0.00;
        this.VMChangeList = new ArrayList<>();
        this.VMChange = 9430.00;
        this.totalSales = 0.00;
        this.sold = 0;
    }

    /**
     * This sets the amount of userCash the VendingMachine has to the double userCash.
     *
     * @param userCash the amount of money that will be set for the VendingMachine object.
     */
    public void setUserCash(double userCash) {
        this.userCash = userCash;
    }

    /**
     * Returns the double userCash.
     *
     * @return the value of userCash.
     */
    public double getUserCash() {
        return this.userCash;
    }

    /**
     * This sets the amount of userBalance the VendingMachine has to the double userBalance.
     *
     * @param userBalance the amount of balance that will be set for the VendingMachine object.
     */
    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    /**
     * Returns the double userBalance.
     *
     * @return the value of userBalance.
     */
    public double getUserBalance() {
        return this.userBalance;
    }

    /**
     * This sets the amount of totalPayment the VendingMachine has to the double totalPayment.
     *
     * @param totalPayment the amount of totalPayment that will be set for the VendingMachine object.
     */
    public void setTotalPayment(double totalPayment) { this.totalPayment = totalPayment; }

    /**
     * Returns the double totalPayment.
     *
     * @return the value of totalPayment.
     */
    public double getTotalPayment() { return this.totalPayment; }

    /**
     * This sets the amount of VMChange the VendingMachine has to the double VMChange.
     *
     * @param VMChange the amount of change that will be set for the VendingMachine object.
     */
    public void setVMChange(double VMChange) {
        this.VMChange = VMChange;
    }

    /**
     * Returns the double VMChange.
     *
     * @return the value of VMChange.
     */
    public double getVMChange() {
        return this.VMChange;
    }

    /**
     * This sets the amount of totalSales the VendingMachine has to the double totalSales.
     *
     * @param totalSales the amount of sales that will be set for the VendingMachine object.
     */
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * Returns the double totalSales.
     *
     * @return the value of totalSales.
     */
    public double getTotalSales() {
        return this.totalSales;
    }

    /**
     * Returns the int sold.
     *
     * @return the value of sold.
     */
    public int getSold() { return this.sold; }

    /**
     * This sets the amount of sold items the VendingMachine has to the int sold.
     *
     * @param sold the amount of sold items that will be set for the VendingMachine object.
     */
    public void setSold (int sold) { this.sold = sold; }

    /**
     * This initializes the Item objects in itemList to be utilized in VendingMachine.
     * Initialization includes name, calories, price, and stock of each Item object.
     */
    public void addItems() {
        itemList.add(new Item("Pork", 96, 45, 20));
        itemList.add(new Item("Chicken", 92, 35, 20));
        itemList.add(new Item("Beef", 100, 50, 20));
        itemList.add(new Item("Egg", 72, 10, 20));
        itemList.add(new Item("Cabbage", 22, 20, 20));
        itemList.add(new Item("Seaweed",	20,5, 20));
        itemList.add(new Item("Rice",	205, 20, 20));
        itemList.add(new Item("Rice Cake", 60, 14, 20));
        itemList.add(new Item("Fish Cake", 120, 15, 20));
        itemList.add(new Item("Noodles", 220, 10, 20));

    }

    /**
     * This initializes the Money objects in an ArrayList to be utilized in VendingMachine.
     * Denominations include: ₱1000, ₱500, ₱200, ₱100, ₱50, ₱20, ₱10, ₱5, and ₱1.
     * Initial quantities for each denomination are set to 0 for userCashList and paymentList.
     * Initial quantities for each denomination are set to 5 for VMChangeList.
     */
    public void addMoney() {
        // User Money arraylist initialization
        userCashList.add(new Money(1000, 0)); // index 0
        userCashList.add(new Money(500, 0)); // index 1
        userCashList.add(new Money(200, 0)); // index 2
        userCashList.add(new Money(100, 0)); // index 3
        userCashList.add(new Money(50, 0)); // index 4
        userCashList.add(new Money(20, 0)); // index 5
        userCashList.add(new Money(10, 0)); // index 6
        userCashList.add(new Money(5, 0)); // index 7
        userCashList.add(new Money(1, 0)); // index 8

        // Vending Machine change arraylist initialization
        VMChangeList.add(new Money(1000, 5)); // index 0
        VMChangeList.add(new Money(500, 5)); // index 1
        VMChangeList.add(new Money(200, 5)); // index 2
        VMChangeList.add(new Money(100, 5)); // index 3
        VMChangeList.add(new Money(50, 5)); // index 4
        VMChangeList.add(new Money(20, 5)); // index 5
        VMChangeList.add(new Money(10, 5)); // index 6
        VMChangeList.add(new Money(5, 5)); // index 7
        VMChangeList.add(new Money(1, 5)); // index 8

        // Vending Machine collection arraylist initialization
        paymentList.add(new Money(1000, 0)); // index 0
        paymentList.add(new Money(500, 0)); // index 1
        paymentList.add(new Money(200, 0)); // index 2
        paymentList.add(new Money(100, 0)); // index 3
        paymentList.add(new Money(50, 0)); // index 4
        paymentList.add(new Money(20, 0)); // index 5
        paymentList.add(new Money(10, 0)); // index 6
        paymentList.add(new Money(5, 0)); // index 7
        paymentList.add(new Money(1, 0)); // index 8

    }

    /**
     * This method acts as the text-based interface for Testing Vending Machine Menu.
     * Options include Vending Features, Maintenance Features, and Back to Main Menu.
     *
     * @param scanner the initialized scanner
     */

    public void testFeatures(Scanner scanner) {
        int option;

        do {
            System.out.println("----- Test Vending Machine Menu -----");
            System.out.println("1. Vending Features");
            System.out.println("2. Maintenance Features");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> vendingFeatures(scanner);
                case 2 -> maintenanceFeatures(scanner);
                case 3 -> System.out.println("Returning to the main menu...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 3);
    }

    /**
     * This method acts as the text-based interface for Vending Features Menu.
     * Options include Enter Money, Display Items, Purchase Item, Produce Change, and Back to Test Menu.
     *
     * @param scanner the initialized scanner
     */
    private void vendingFeatures(Scanner scanner) {
        int option;

        do {
            System.out.println("----- Vending Features -----");
            System.out.println("1. Enter Money");
            System.out.println("2. Display Items");
            System.out.println("3. Purchase Item");
            System.out.println("4. Produce Change");
            System.out.println("5. Back to Test Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> cashInput(scanner);
                case 2 -> {
                    System.out.println("----- Display Items -----");
                    displayItems();
                }
                case 3 -> purchaseItem(scanner);
                case 4 -> produceChange();
                case 5 -> System.out.println("Returning to the test menu...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 5);
    }

    /**
     * This method acts as the text-based interface for Maintenance Features Menu.
     * Options include Vending Features, Maintenance Features, and Back to Main Menu.
     *
     * @param scanner the initialized scanner
     */

    private void maintenanceFeatures(Scanner scanner) {
        int option;

        do {
            System.out.println("----- Maintenance Features -----");
            System.out.println("1. Add Item");
            System.out.println("2. Change Price");
            System.out.println("3. Collect Payment");
            System.out.println("4. Replenish Stock");
            System.out.println("5. Replenish Change");
            System.out.println("6. Print purchase Summary");
            System.out.println("7. Back to Test Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> addItem(scanner);
                case 2 -> changePrice(scanner);
                case 3 -> collectPayment();
                case 4 -> replenishStock(scanner);
                case 5 -> replenishChange(scanner);
                case 6 -> printSummary();
                case 7 -> System.out.println("Returning to the test menu...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 7);
    }
    /**
     * This method acts as accumulator for user cash input and updater to the userCashList.
     * This method also updates the paymentList to reflect the user's cash input.
     * After every method call, this method shows the current value of userCash.
     * @param scanner the initialized scanner
     */

    private void cashInput(Scanner scanner) {
        int cashInput;
        double totalCash = 0;
        int count1000 = 0;
        int count500 = 0;
        int count200 = 0;
        int count100 = 0;
        int count50 = 0;
        int count20 = 0;
        int count10 = 0;
        int count5 = 0;
        int count1 = 0;
        System.out.println("----- Enter Money -----");
        System.out.println("This vending machine only accepts valid bills and coins.");
        System.out.println("Valid bills include: ₱1000, ₱500, ₱200, ₱100, ₱50, and ₱20");
        System.out.println("Valid coins include: ₱10, ₱5, and ₱1");
        do {
            System.out.println("Enter the denomination of your bill or coin: ");
            System.out.println("Enter 0 if you are finished.");
            cashInput = scanner.nextInt();
            switch (cashInput) {
                case 1000 -> {
                    System.out.println("You have successfully added ₱1000!");
                    count1000 += 1;
                }
                case 500 -> {
                    System.out.println("You have successfully added ₱500!");
                    count500 += 1;
                }
                case 200 -> {
                    System.out.println("You have successfully added ₱200!");
                    count200 += 1;
                }
                case 100 -> {
                    System.out.println("You have successfully added ₱100!");
                    count100 += 1;
                }
                case 50 -> {
                    System.out.println("You have successfully added ₱50!");
                    count50 += 1;
                }
                case 20 -> {
                    System.out.println("You have successfully added ₱20!");
                    count20 += 1;
                }
                case 10 -> {
                    System.out.println("You have successfully added ₱10!");
                    count10 += 1;
                }
                case 5 -> {
                    System.out.println("You have successfully added ₱5!");
                    count5 += 1;
                }
                case 1 -> {
                    System.out.println("You have successfully added ₱1!");
                    count1 += 1;
                }
                case 0 -> {
                    System.out.println("You are done adding money!");
                    System.out.println("Returning to vending features menu...");
                    // adding of quantity for userCashList
                    userCashList.get(0).setQuantity(count1000);
                    userCashList.get(1).setQuantity(count500);
                    userCashList.get(2).setQuantity(count200);
                    userCashList.get(3).setQuantity(count100);
                    userCashList.get(4).setQuantity(count50);
                    userCashList.get(5).setQuantity(count20);
                    userCashList.get(6).setQuantity(count10);
                    userCashList.get(7).setQuantity(count5);
                    userCashList.get(8).setQuantity(count1);
                    // adding of quantity for paymentList
                    paymentList.get(0).setQuantity(paymentList.get(0).getQuantity() + count1000);
                    paymentList.get(1).setQuantity(paymentList.get(1).getQuantity() + count500);
                    paymentList.get(2).setQuantity(paymentList.get(2).getQuantity() + count200);
                    paymentList.get(3).setQuantity(paymentList.get(3).getQuantity() + count100);
                    paymentList.get(4).setQuantity(paymentList.get(4).getQuantity() + count50);
                    paymentList.get(5).setQuantity(paymentList.get(5).getQuantity() + count20);
                    paymentList.get(6).setQuantity(paymentList.get(6).getQuantity() + count10);
                    paymentList.get(7).setQuantity(paymentList.get(7).getQuantity() + count5);
                    paymentList.get(8).setQuantity(paymentList.get(8).getQuantity() + count1);
                    // iterates through userCashList to get total value of money stored in the array list.
                    for (Money money : userCashList) {
                        totalCash += money.getValue() * money.getQuantity();
                    }
                    setUserCash(getUserCash() + totalCash);
                    System.out.println("You have: ₱" + getUserCash());
                }
                default -> System.out.println("Invalid input! Please try again.");
            }
        } while (cashInput != 0);
    }

    /**
     * This method acts as the printer for each instance of the Item object in the Arraylist itemList.
     * Displays each Item with the format Number : Name : Calories : Price : Stock.
     */
    private void displayItems() {
        int itemNumber = 1;
        for (Item item : itemList) {
            System.out.printf("Item %-2d: %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                    itemNumber, item.getName(), item.getCalories(), item.getPrice(), item.getStock());
            itemNumber++;
        }
        System.out.println("Finished displaying all items!");
    }

    /**
     * This method acts as the text-based interface for purchasing an Item in the Vending Machine.
     * Displays the userCash every time the method is called for the user to know their current cash in the Vending Machine.
     * An Item can only be bought if the price is less than or equal to the userCash and if the userBalance is less than or equal to userCash.
     * @param scanner the initialized scanner
     */
    private void purchaseItem(Scanner scanner) {
        System.out.println("----- Purchase Item -----");
        System.out.println("You currently have ₱" + getUserCash());
        System.out.print("Enter the slot number: ");
        int slot = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while (slot < 1 || slot > itemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            slot = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        Item item = itemList.get(slot - 1);
        if (item.getStock() >= 1) {
            if (item.getPrice() <= getUserCash() && getUserBalance() <= getUserCash()) {
                setUserBalance(getUserBalance() + item.getPrice());
                setUserCash(getUserCash() - item.getPrice());
                item.setStock(item.getStock() - 1);
                setSold(getSold() + 1);
                System.out.println("Purchase successful! Dispensing: " + item.getName());
                setTotalSales(getTotalSales() + item.getPrice());
            } else {
                System.out.println("You cannot afford this item!");
            }
        } else {
            System.out.println("This item is sold out!");
        }
    }

    /**
     * This method acts as the change producer for the user if their userCash is more than their userBalance.
     * Change will be the same as userCash if the user did not buy an item.
     * If the VMChange is not enough, a message will be printed.
     * Prints the denominations of the change from the greatest value to the lowest value.
     */
    private void produceChange() {
        boolean enoughChange = true;
        System.out.println("----- Produce Change -----");
        double change = getUserCash();
        setVMChange(getVMChange() - change);
        if (change > 0) {
            System.out.println("Change to be returned: ₱" + change);
            do {
                if (change >= 1000) {
                    if (VMChangeList.get(0).getQuantity() > 0) {
                        change -= 1000;
                        VMChangeList.get(0).setQuantity(VMChangeList.get(0).getQuantity() - 1);
                        System.out.println("Dispensing ₱1000");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 500) {
                    if (VMChangeList.get(1).getQuantity() > 0) {
                        change -= 500;
                        VMChangeList.get(1).setQuantity(VMChangeList.get(1).getQuantity() - 1);
                        System.out.println("Dispensing ₱500");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 200) {
                    if (VMChangeList.get(2).getQuantity() > 0) {
                        change -= 200;
                        VMChangeList.get(2).setQuantity(VMChangeList.get(2).getQuantity() - 1);
                        System.out.println("Dispensing ₱200");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 100) {
                    if (VMChangeList.get(3).getQuantity() > 0) {
                        change -= 100;
                        VMChangeList.get(3).setQuantity(VMChangeList.get(3).getQuantity() - 1);
                        System.out.println("Dispensing ₱100");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 50) {
                    if (VMChangeList.get(4).getQuantity() > 0) {
                        change -= 50;
                        VMChangeList.get(4).setQuantity(VMChangeList.get(4).getQuantity() - 1);
                        System.out.println("Dispensing ₱50");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 20) {
                    if (VMChangeList.get(5).getQuantity() > 0) {
                        change -= 20;
                        VMChangeList.get(5).setQuantity(VMChangeList.get(5).getQuantity() - 1);
                        System.out.println("Dispensing ₱20");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 10) {
                    if (VMChangeList.get(6).getQuantity() > 0) {
                        change -= 10;
                        VMChangeList.get(6).setQuantity(VMChangeList.get(6).getQuantity() - 1);
                        System.out.println("Dispensing ₱10");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 5) {
                    if (VMChangeList.get(7).getQuantity() > 0) {
                        change -= 5;
                        VMChangeList.get(7).setQuantity(VMChangeList.get(7).getQuantity() - 1);
                        System.out.println("Dispensing ₱5");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                } else if (change >= 1) {
                    if (VMChangeList.get(8).getQuantity() > 0) {
                        change -= 1;
                        VMChangeList.get(8).setQuantity(VMChangeList.get(8).getQuantity() - 1);
                        System.out.println("Dispensing ₱1");
                    } else {
                        System.out.println("Not enough money to produce change, please insert the exact amount to continue the transaction.");
                        enoughChange = false;
                    }
                }
            } while (change != 0 || !enoughChange);
        } else {
            System.out.println("You do not have change.");
        }

        // Reset userCash and userBalance
        setUserCash(0.00);
        setUserBalance(0.00);

        // Update VMChange
        setVMChange(getVMChange() - change);
        System.out.println("Change produced successfully!");
    }
    /**
     * This method acts as stock replenisher for the Vending Machine.
     * Replenishes stock based on the slot number and the quantity the user inputs.
     * @param scanner the initialized scanner
     */

    private void replenishStock(Scanner scanner) {
        System.out.println("----- Replenish Stock -----");
        System.out.print("Enter the slot number: ");
        int slot = scanner.nextInt();
        scanner.nextLine();

        while (slot < 1 || slot > itemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            slot = scanner.nextInt();
            scanner.nextLine();
        }

        int itemIndex = slot - 1;
        Item item = itemList.get(itemIndex);

        System.out.print("Enter the quantity to replenish: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        item.setStock(item.getStock() + quantity);
        System.out.println("Stock replenished successfully!");
    }
    /**
     * This method acts as the text-based interface for adding a new Item.
     * New Items must be unique from Items already present in itemList.
     * A new Item will be added upon valid inputs of name, calories, price, and stock.
     * A preview of the Item will be printed if successful.
     * @param scanner the initialized scanner
     */

    private void addItem(Scanner scanner) {
        String name;
        int calories;
        double price;
        int stock;
        boolean validCalories;
        boolean validPrice;
        boolean validStock;
        System.out.println("----- Add Item -----");
        System.out.println("To add an item, please input the following: name, calories, price, and stock");
        System.out.println("Only unique items will be added to the Vending Machine");
        System.out.println("Please enter the name of the item: ");
        scanner.nextLine(); // Consume newline
        name = scanner.nextLine();

        boolean itemExists = false;
        for (Item item : itemList) {
            if (name.equalsIgnoreCase(item.getName())) {
                System.out.println("Item already exists!");
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            do {
                System.out.println("Please enter the amount of calories: ");
                calories = scanner.nextInt();
                if (calories >= 1) {
                    validCalories = true;
                } else {
                    System.out.println("Invalid input! Please try again.");
                    System.out.println("Calories cannot be less than 1.");
                    validCalories = false;
                }
            } while (!validCalories);

            do {
                System.out.println("Please enter the price: ");
                price = scanner.nextDouble();
                if (price >= 1) {
                    validPrice = true;
                } else {
                    System.out.println("Invalid input! Please try again.");
                    System.out.println("Price cannot be less than 1.");
                    validPrice = false;
                }
            } while (!validPrice);

            do {
                System.out.println("Please enter the stock: ");
                stock = scanner.nextInt();
                if (stock >= 10) {
                    validStock = true;
                } else {
                    System.out.println("Invalid input! Please try again.");
                    System.out.println("Stock cannot be less than 10.");
                    validStock = false;
                }
            } while (!validStock);

            itemList.add(new Item(name, calories, price, stock));
            System.out.println("You have successfully added Item " + (itemList.size()) + ": " + itemList.get(itemList.size() - 1).getName() + " Calories: "
                    + itemList.get(itemList.size() - 1).getCalories() + " Price: " + itemList.get(itemList.size() - 1).getPrice() +
                    " Stock: " + itemList.get(itemList.size() - 1).getStock());
        }
    }


    /**
     * This method acts as the text-based interface for changing an Item's price.
     * An Item's price can be changed given the Item slot and new price.
     * Price is valid if it is greater than or equal to 1.0
     * Prints the previous value of price and then prints the current value of price if successful.
     * @param scanner the initialized scanner
     */

    private void changePrice(Scanner scanner){
        double price;
        boolean validPrice;
        System.out.println("----- Change Price -----");
        displayItems();
        System.out.println("Choose an item to edit the price.");
        int item = scanner.nextInt();
        scanner.nextLine();
        while (item < 1 || item > itemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            item = scanner.nextInt();
            scanner.nextLine();
        }
        do {
            System.out.println("Please enter the price: ");
            price = scanner.nextDouble();
            if(price >= 1){
                validPrice = true;
            } else{
                System.out.println("Invalid input! Please try again.");
                System.out.println("Price cannot be less than 1.");
                validPrice = false;
            }
        } while (!validPrice);
        System.out.println("Item " + item + ": " + itemList.get(item - 1).getName() + " Previous Price: " + itemList.get(item - 1).getPrice());
        itemList.get(item - 1).setPrice(price);
        System.out.println("Item " + item + ": " + itemList.get(item - 1).getName() + " Current Price: " + itemList.get(item - 1).getPrice());
        System.out.println("Price updated successfully!");
    }

    /**
     * This method acts as the payment collection in the Vending Machine.
     * Each time the user inputs cash, the paymentList will reflect this as well.
     * Totals all the Money objects in paymentList and sets it as totalCash.
     * Prints the denominations of bills and coins based on how much totalCash is.
     */
    public void collectPayment(){
        double totalCash = 0;
        for (Money money : paymentList) {
            totalCash += money.getValue() * money.getQuantity();
        }
        setTotalPayment(totalCash);
        System.out.println("----- Collect Payment -----");
        System.out.println("Total to be collected: ₱" + getTotalPayment());
        if (totalCash > 0){
           do {
               if (totalCash >= 1000){
                   totalCash -= 1000;
                   System.out.println("Dispensing ₱1000");
               } else if (totalCash >= 500){
                   totalCash -= 500;
                   System.out.println("Dispensing ₱500");
               } else if (totalCash >= 200){
                   totalCash -= 200;
                   System.out.println("Dispensing ₱200");
               } else if (totalCash >= 100){
                   totalCash -= 100;
                   System.out.println("Dispensing ₱100");
               } else if (totalCash >= 50){
                   totalCash -= 50;
                   System.out.println("Dispensing ₱50");
               } else if (totalCash >= 20){
                   totalCash -= 20;
                   System.out.println("Dispensing ₱20");
               }  else if (totalCash >= 10){
                   totalCash -= 10;
                   System.out.println("Dispensing ₱10");
               } else if (totalCash >= 5){
                   totalCash -= 5;
                   System.out.println("Dispensing ₱5");
               } else if (totalCash >= 1){
                   totalCash -= 1;
                   System.out.println("Dispensing ₱1");
               }
           } while (totalCash != 0);
           System.out.println("Payment collection is complete!");
        } else {
            System.out.println("There is no total to collect!");
        }
        // reset paymentList arraylist
        for (Money money : paymentList){
            money.setQuantity(0);
        }
    }

    /**
     * This method acts as accumulator for the VMChange input and updater to the VMChangeList.
     * After every method call, this method shows the current value of VMChange.
     * @param scanner the initialized scanner
     */
    private void replenishChange(Scanner scanner) {
        int cashInput;
        double totalCash = getVMChange();
        int count1000 = 0;
        int count500 = 0;
        int count200 = 0;
        int count100 = 0;
        int count50 = 0;
        int count20 = 0;
        int count10 = 0;
        int count5 = 0;
        int count1 = 0;
        System.out.println("----- Replenish Change -----");
        System.out.println("This vending machine only accepts valid bills and coins.");
        System.out.println("Valid bills include: ₱1000, ₱500, ₱200, ₱100, ₱50, and ₱20");
        System.out.println("Valid coins include: ₱10, ₱5, and ₱1");
        do {
            System.out.println("Enter the denomination of your bill or coin: ");
            System.out.println("Enter 0 if you are finished.");
            cashInput = scanner.nextInt();
            switch (cashInput) {
                case 1000 -> {
                    System.out.println("You have successfully added ₱1000!");
                    count1000 += 1;
                }
                case 500 -> {
                    System.out.println("You have successfully added ₱500!");
                    count500 += 1;
                }
                case 200 -> {
                    System.out.println("You have successfully added ₱200!");
                    count200 += 1;
                }
                case 100 -> {
                    System.out.println("You have successfully added ₱100!");
                    count100 += 1;
                }
                case 50 -> {
                    System.out.println("You have successfully added ₱50!");
                    count50 += 1;
                }
                case 20 -> {
                    System.out.println("You have successfully added ₱20!");
                    count20 += 1;
                }
                case 10 -> {
                    System.out.println("You have successfully added ₱10!");
                    count10 += 1;
                }
                case 5 -> {
                    System.out.println("You have successfully added ₱5!");
                    count5 += 1;
                }
                case 1 -> {
                    System.out.println("You have successfully added ₱1!");
                    count1 += 1;
                }
                case 0 -> {
                    System.out.println("You are done adding money!");
                    System.out.println("Returning to maintenance features menu...");
                    // adding of quantity for userCashList
                    VMChangeList.get(0).setQuantity(count1000);
                    VMChangeList.get(1).setQuantity(count500);
                    VMChangeList.get(2).setQuantity(count200);
                    VMChangeList.get(3).setQuantity(count100);
                    VMChangeList.get(4).setQuantity(count50);
                    VMChangeList.get(5).setQuantity(count20);
                    VMChangeList.get(6).setQuantity(count10);
                    VMChangeList.get(7).setQuantity(count5);
                    VMChangeList.get(8).setQuantity(count1);
                    // iterates through VMChangeList to get total value of money stored in the array list.
                    for (Money money : VMChangeList) {
                        totalCash += money.getValue() * money.getQuantity();
                    }
                    setVMChange(totalCash);
                    System.out.println("You have: ₱" + getVMChange());
                }
                default -> System.out.println("Invalid input! Please try again.");
            }
        } while (cashInput != 0);
    }

    /**
     * This method acts as the printer for Items sold in the Vending Machine.
     * Prints the starting inventory as well as the ending inventory of the Vending Machine.
     * Prints the quantity of sold items and the amount of total sales.
     */
    private void printSummary() {
        System.out.println("----- Purchase Summary -----");
        System.out.println("Starting Inventory:");

        for (Item item : itemList) {
            System.out.printf("Item: %-20s Quantity: %-5d\n", item.getName(), item.getEndStock());
        }

        System.out.println("\nEnding Inventory:");

        for (Item item : itemList) {
            System.out.printf("Item: %-20s Quantity: %-5d\n", item.getName(), item.getStock());
        }

        System.out.println("\nQuantity Sold: " + getSold());
        System.out.println("Total Sales: ₱" + getTotalSales());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = null;
        int option;

        do {
            System.out.println("----- Main Menu -----");
            System.out.println("1. Create Vending Machine");
            System.out.println("2. Test Vending Machine");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> {
                    System.out.println("----- Create Vending Machine -----");
                    System.out.println("Choose the type of vending machine:");
                    System.out.println("1. Regular");
                    System.out.println("2. Special");
                    System.out.print("Enter your choice: ");
                    int vendingType = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    while (vendingType < 1 || vendingType > 2) {
                        System.out.println("Invalid vending machine type! Please try again.");
                        System.out.print("Enter your choice: ");
                        vendingType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    }
                    vendingMachine = new VendingMachine();
                    vendingMachine.addItems();
                    vendingMachine.addMoney();
                }
                case 2 -> {
                    if (vendingMachine == null) {
                        System.out.println("Vending Machine not created yet!");
                    } else {
                        vendingMachine.testFeatures(scanner);
                    }
                }
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 3);
    }
}
