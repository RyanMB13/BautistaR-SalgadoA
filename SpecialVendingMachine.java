import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashMap;
public class SpecialVendingMachine extends VendingMachine {
    private final ArrayList<Item> uniqueItemList;
    private final HashMap<String, Integer> initialStock;
    private final ArrayList<Item> orderList;
    private final ArrayList<Item> uniqueOrderList;
    private final ArrayList<String> notSoldSeparatelyList;

    /**
     * This generates a SpecialVendingMachine object which includes the super variables itemList, userCashList, userCash,
     * VMChangeList, VMChange, and totalSales.
     * This object also includes the variables
     */
    public SpecialVendingMachine() {
        super();
        this.uniqueItemList = new ArrayList<>();
        this.initialStock = new HashMap<>();
        this.orderList = new ArrayList<>();
        this.uniqueOrderList = new ArrayList<>();
        this.notSoldSeparatelyList = new ArrayList<>();
    }

    /**
     * Retrieves the initial stock quantity for an item by its name from a HashMap.
     * If the item name is not found in the HashMap, the method returns a default value of 0.
     *
     * @param name The name of the item for which the initial stock quantity is to be retrieved.
     * @return The initial stock quantity of the item with the specified name, or 0 if the item is not found.
     */
    public int getInitialStock(String name) {
        // Retrieve the initial stock quantity from the HashMap
        // 0 is default value if item not found
        return initialStock.getOrDefault(name, 0);
    }

    /**
     * Creates instances of an item with the specified details and adds them to the itemList.
     * The method creates 'stock' number of instances of the item and sets their initial stock quantity in the HashMap.
     *
     * @param name     The name of the item to be created.
     * @param calories The number of calories in the item.
     * @param price    The price of the item.
     * @param stock    The initial stock quantity of the item to be created.
     */
    public void createInstance(String name, int calories, double price, int stock) {
        for (int i = 0; i < stock; i++) {
            itemList.add(new Item(name, calories, price, 1));
        }
        // Store the initial stock quantity in the HashMap
        initialStock.put(name, stock);
    }

    /**
     * Deletes an instance of an item with the specified name from the itemList.
     * If there are multiple instances of the item, it removes one instance from the itemList.
     * If there is only one instance of the item, it sets the stock quantity of the item to 0 instead of removing it completely.
     *
     * @param name The name of the item instance to be deleted.
     */
    public void deleteInstance(String name) {
        boolean deleted = false;

        // Deletes an object instance if one has not yet been deleted and if the name of the object matches with the inputted name
        for (int i = 0; i < itemList.size(); i++) {
            if (!deleted && name.equalsIgnoreCase(itemList.get(i).getName()) && countStock(name) > 1) {
                itemList.remove(i);
                deleted = true;
                i--;
            } else if (!deleted && name.equalsIgnoreCase(itemList.get(i).getName()) && countStock(name) == 1){
                itemList.get(i).setStock(0);
                deleted = true;
            }
        }
    }

    /**
     * Dispenses items from the orderList by deleting their instances from the itemList.
     * The method iterates through each item in the orderList and deletes its corresponding instance (if found) from the itemList.
     * If there are multiple instances of the item, it removes one instance from the itemList.
     * If there is only one instance of the item, it sets the stock quantity of the item to 0 instead of removing it completely.
     */
    public void dispenseItems(){
        for (Item item : orderList)
        {
            deleteInstance(item.getName());
        }
    }

    /**
     * Counts the stock quantity of an item with the specified name in the itemList.
     * The method iterates through the itemList and counts the number of instances of the item that match the inputted name.
     * The method considers only instances with a stock quantity greater than 0 in the count.
     *
     * @param name The name of the item for which the stock quantity needs to be counted.
     * @return The stock quantity of the item with the specified name in the itemList.
     *         If no instances of the item are found with a stock quantity greater than 0, the method returns 0.
     */
    public int countStock(String name) {
        int stock = 0;
        for (Item item : itemList) {
            if (name.equalsIgnoreCase(item.getName()) && item.getStock() == 0) {
                stock = 0;
            } else if (name.equalsIgnoreCase(item.getName())) {
                stock++;
            }
        }
        return stock;
    }

    /**
     * Counts the total calories of all items in the orderList.
     * The method iterates through the orderList and calculates the sum of calories for all items.
     *
     * @return The total calories of all items in the orderList.
     *         If the orderList is empty or contains no items, the method returns 0.
     */
    public int countCalories(){
        int calories = 0;
        for (Item item : orderList){
            calories += item.getCalories();
        }
        return calories;
    }

    /**
     * Calculates the total price of all items in the orderList.
     * The method iterates through the orderList and calculates the sum of prices for all items.
     *
     * @return The total price of all items in the orderList.
     *         If the orderList is empty or contains no items, the method returns 0.0.
     */
    public double countPrice(){
        double price = 0;
        for (Item item : orderList){
            price += item.getPrice();
        }
        return price;
    }

    /**
     * Checks if all items in the orderList have stock available.
     * The method iterates through the orderList and checks if each item has a stock quantity greater than or equal to 1.
     *
     * @return true if all items in the orderList have stock available (stock quantity >= 1), false otherwise.
     *         If the orderList is empty or contains no items, the method returns true.
     *         If any item in the orderList is sold out (stock quantity < 1), the method returns false and prints an error message.
     */
    public boolean hasStock() {
        for (Item item : orderList) {
            if (item.getStock() < 1) {
                System.out.println("Error: " + item.getName() + " is sold out!");
                return false;
            }
        }
        return true;
    }

    /**
     * Counts the minimum stock quantity of Ramen ingredients in the orderList.
     * The method iterates through the orderList and calculates the minimum stock quantity of all Ramen items.
     *
     * @return The minimum stock quantity of Ramen items in the orderList.
     *         If the orderList is empty or contains no Ramen items, the method returns 0.
     */
    public int countRamenStock() {
        int min = countStock(orderList.get(0).getName());
        int stock;
        for (Item item : orderList) {
            stock = countStock(item.getName());
            if (stock < min) {
                min = stock;
            }
        }
        return min;
    }

    /**
     * Retrieves an Item object from the uniqueItemList based on the provided name.
     *
     * @param name The name of the item to retrieve.
     * @return The Item object with the specified name, if found in the uniqueItemList.
     *         If no Item object with the specified name is found, the method returns null.
     */
    private Item getItemByName(String name) {
        for (Item item : uniqueItemList) {
            if (name.equalsIgnoreCase(item.getName())) {
                return item;
            }
        }
        return null;
    }

    /**
     * Adds an item to the notSoldSeparatelyList, indicating that it cannot be bought alone.
     *
     * @param name The name of the item to be added to the notSoldSeparatelyList.
     */
    public void addToCantBuyAlone(String name){
        notSoldSeparatelyList.add(notSoldSeparatelyList.size(), name);
    }

    /**
     * Checks if an item is present in the notSoldSeparatelyList.
     *
     * @param name The name of the item to check for in the notSoldSeparatelyList.
     * @return true if the item is found in the notSoldSeparatelyList list (non case-insensitive match), false otherwise.
     */
    public boolean isInCantBuyAlone(String name){
        boolean found = false;
        for (String s : notSoldSeparatelyList) {
            if (name.equalsIgnoreCase(s)) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Displays a list of items that cannot be sold separately along with their details.
     * The method iterates through the uniqueItemList and checks if each item is present in the notSoldSeparatelyList.
     * If an item is found in the "not sold separately" list, its details such as name, calories, price, and stock quantity are displayed.
     * The items are displayed in a tabular format with their corresponding item numbers.
     */
    public void displayCantBuyAlone(){
        int itemNumber = 1;
        System.out.println("Items that cannot be sold separately are:");
        for (Item item : uniqueItemList) {
            if (isInCantBuyAlone(item.getName())) {
                System.out.printf("Item %-2d: %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                        itemNumber, item.getName(), item.getCalories(), item.getPrice(), countStock(item.getName()));
                itemNumber++;
            }
        }
        System.out.println("Finished displaying all items that cannot be sold separately!");
    }

    /**
     * Updates the price of an item with the specified name in the itemList.
     * The method iterates through the itemList and finds the item with a name that matches the input 'name'.
     * If a matching item is found, its price is updated to the provided 'price'.
     *
     * @param name  The name of the item whose price needs to be updated.
     * @param price The new price to set for the item.
     */
    public void updatePrice(String name, double price){
        for (Item item : itemList){
            if (name.equalsIgnoreCase(item.getName())) {
                item.setPrice(price);
            }
        }
    }

    /**
     * Updates the uniqueItemList to contain unique items while preserving the order of occurrence.
     * The method clears the existing uniqueItemList and then creates a LinkedHashSet to store unique items while preserving their order.
     * It iterates over the original itemList and adds each item to the LinkedHashSet, which automatically removes duplicates.
     * If an item is added to the set (i.e., it is unique), it is also added to the uniqueItemList.
     * After the method call, the uniqueItemList will only contain unique items from the original itemList.
     */
    public void updateUniqueItemList(){
        // Clears uniqueItemList every call
        uniqueItemList.clear();

        // Create a LinkedHashSet to store unique items while preserving order
        LinkedHashSet<Item> uniqueItemsSet = new LinkedHashSet<>();

        // Iterate over the original ArrayList
        for (Item item : itemList) {
            // Add the item to the LinkedHashSet (which automatically removes duplicates)
            boolean added = uniqueItemsSet.add(item);

            // If the item was added to the set, also add it to the unique ArrayList
            if (added) {
                uniqueItemList.add(item);
            }
        }
    }

    /**
     * Updates the uniqueOrderList to contain unique items while preserving the order of occurrence.
     * The method clears the existing uniqueOrderList and then creates a LinkedHashSet to store unique items while preserving their order.
     * It iterates over the original orderList and adds each item to the LinkedHashSet, which automatically removes duplicates.
     * If an item is added to the set (i.e., it is unique), it is also added to the uniqueOrderList.
     * After the method call, the uniqueOrderList will only contain unique items from the original orderList, and their order will be preserved.
     * Note: The uniqueOrderList will be different from the original orderList if the latter contains duplicate items.
     */
    public void updateUniqueOrderList(){
        // Clears uniqueItemList every call
        uniqueOrderList.clear();

        // Create a LinkedHashSet to store unique items while preserving order
        LinkedHashSet<Item> uniqueOrdersSet = new LinkedHashSet<>();

        // Iterate over the original ArrayList
        for (Item item : orderList) {
            // Add the item to the LinkedHashSet (which automatically removes duplicates)
            boolean added = uniqueOrdersSet.add(item);

            // If the item was added to the set, also add it to the unique ArrayList
            if (added) {
                uniqueOrderList.add(item);
            }
        }
    }

    /**
     * This initializes the Item objects in itemList to be utilized in VendingMachine.
     * Initialization includes name, calories, price, and stock of each Item object.
     */
    @Override
    public void addItems() {
        // Items that can be sold individually
        createInstance("Pork", 96, 45, 1);
        createInstance("Chicken", 92, 35, 20);
        createInstance("Beef", 100, 50, 20);
        createInstance("Egg", 72, 10, 20);
        createInstance("Cabbage", 22, 20, 20);
        createInstance("Seaweed", 20, 5, 20);
        createInstance("Rice", 205, 20, 20);
        createInstance("Rice Cake", 60, 14, 20);
        createInstance("Fish Cake", 120, 15, 20);
        createInstance("Noodles", 220, 10, 20);
        createInstance("Water", 0, 15, 20);
        createInstance("Whole Milk", 149, 30, 20);
        // Items that cannot be sold individually
        createInstance("Broth", 42, 8, 20);
        createInstance("Cheese", 371, 30, 20);
        createInstance("Ramen Powder", 4, 5, 20);
        createInstance("Green Onion", 32, 10, 20);
        createInstance("Gochujang", 50, 10, 20);
        createInstance("Gochugaru", 22, 10, 20);
        createInstance("Chunjang", 41, 40, 20);
        createInstance("Radish", 14, 15, 20);
        createInstance("Zucchini", 20, 15, 20);
        createInstance("Onion", 40, 20, 20);
        createInstance("Vegetable Oil", 120, 15, 20);
        createInstance("Salt", 0, 5, 20);

        addToCantBuyAlone("Broth");
        addToCantBuyAlone("Cheese");
        addToCantBuyAlone("Ramen Powder");
        addToCantBuyAlone("Green Onion");
        addToCantBuyAlone("Gochujang");
        addToCantBuyAlone("Gochugaru");
        addToCantBuyAlone("Black Bean Paste");
        addToCantBuyAlone("Radish");
        addToCantBuyAlone("Zucchini");
        addToCantBuyAlone("Onion");
        addToCantBuyAlone("Vegetable Oil");
        addToCantBuyAlone("Salt");

        // Call updateUniqueItemList to add instances to uniqueItemList
        updateUniqueItemList();
    }

    /**
     * This method acts as the text-based interface for Vending Features Menu.
     * Options include Enter Money, Display Items, Purchase Individual Item, Purchase Ramen, Produce Change, and Back to Test Menu.
     *
     * @param scanner The Scanner object to read user input.
     */
    @Override
    public void vendingFeatures(Scanner scanner) {
        int option;

        do {
            System.out.println("----- Vending Features -----");
            System.out.println("1. Enter Money");
            System.out.println("2. Display Items");
            System.out.println("3. Purchase Individual Item");
            System.out.println("4. Purchase Ramen");
            System.out.println("5. Produce Change");
            System.out.println("6. Back to Test Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> cashInput(scanner);
                case 2 -> displayItems();
                case 3 -> purchaseItem(scanner);
                case 4 -> purchaseRamen(scanner);
                case 5 -> produceChange();
                case 6 -> System.out.println("Returning to the test menu...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 6);
    }

    /**
     * This method acts as the text-based interface for Maintenance Features Menu.
     * Options include Add Item, Change Price, Collect Payment, Replenish Stock, Replenish Change, Print Purchase Summary, and Back to test Menu.
     *
     * @param scanner The Scanner object to read user input.
     */
    @Override
    public void maintenanceFeatures(Scanner scanner) {
        int option;

        do {
            System.out.println("----- Maintenance Features -----");
            System.out.println("1. Add Item");
            System.out.println("2. Change Price");
            System.out.println("3. Add to Cannot be Sold Separately");
            System.out.println("4. Collect Payment");
            System.out.println("5. Replenish Stock");
            System.out.println("6. Replenish Change");
            System.out.println("7. Print Purchase Summary");
            System.out.println("8. Back to Test Menu");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> addItem(scanner);
                case 2 -> changePrice(scanner);
                case 3 -> newNotSoldSeparately(scanner);
                case 4 -> collectPayment();
                case 5 -> replenishStock(scanner);
                case 6 -> replenishChange(scanner);
                case 7 -> printSummary();
                case 8 -> System.out.println("Returning to the test menu...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 8);

    }

    /**
     * Handles the purchase of different types of ramen and processes the transaction.
     * The method checks if there is sufficient change in the vending machine (VMChangeList) for the purchase.
     * If there is enough change, it displays the available ramen options to the user and takes their choice as input.
     * Based on the user's choice, it creates an orderList with the selected ramen's ingredients and calculates the total calories and price.
     * If the user has enough cash to purchase the selected ramen, the transaction is processed, and the ramen is prepared.
     * The total calories and price of the purchased ramen are displayed along with the cooking instructions.
     * The purchased ingredients are then removed from the inventory (dispenseItems() method is called).
     * If the vending machine has insufficient change or the selected ramen is not available due to incomplete ingredients,
     * an appropriate error message is displayed, and the transaction is not processed.
     *
     * @param scanner The Scanner object to read user input.
     */
    public void purchaseRamen(Scanner scanner) {
        int option;
        boolean validOption;
        if (VMChangeList.get(0).getQuantity() == 0 || VMChangeList.get(1).getQuantity() == 0 || VMChangeList.get(2).getQuantity() == 0 ||
                VMChangeList.get(3).getQuantity() == 0 || VMChangeList.get(4).getQuantity() == 0 || VMChangeList.get(5).getQuantity() == 0 ||
                VMChangeList.get(6).getQuantity() == 0 || VMChangeList.get(7).getQuantity() == 0 || VMChangeList.get(8).getQuantity() == 0) {
            System.out.println("Cannot continue transaction due to insufficient change, please ask the owner to replenish all denominations of change.");
        } else {
            displayRamen();
            do {
                System.out.print("Enter your choice: ");
                option = scanner.nextInt();
                if (option >= 1 && option <= 7) {
                    validOption = true;
                } else {
                    System.out.println("Invalid input! Please try again.");
                    validOption = false;
                }
            } while (!validOption);

            switch (option) {
                case 1 -> {
                    orderList.clear(); // Clear the orderList if mags-start ng new ramen
                    orderList.add(getItemByName("Broth"));
                    orderList.add(getItemByName("Noodles"));
                    orderList.add(getItemByName("Egg"));
                    orderList.add(getItemByName("Pork"));
                    orderList.add(getItemByName("Salt"));

                    // Calculate total calories and total price based on the ingredients in orderList
                    int totalCalories = countCalories();
                    double totalPrice = countPrice();

                    if (hasStock()) {
                        if (totalPrice <= getUserCash()) {
                            setUserCash(getUserCash() - totalPrice);
                            setSold(getSold() + 1);
                            setTotalSales(getTotalSales() + totalPrice);

                            System.out.println("You have bought: Ramen");
                            System.out.println("Making the broth and seasoning to taste...");
                            System.out.println("Boiling the noodles...");
                            System.out.println("Soft boiling the egg...");
                            System.out.println("Frying the pork and seasoning with salt to taste...");
                            System.out.println("Assembling...1");
                            System.out.println("Finished!");
                            System.out.println("Now Serving: Ramen");
                            System.out.println("Total Calories: " + totalCalories);
                            System.out.println("Total Price: ₱" + totalPrice);

                            // Delete instances of the purchased ingredients
                            dispenseItems();

                        } else {
                            System.out.println("You cannot afford this item!");
                        }
                    } else {
                        System.out.println("Incomplete ingredients, cannot complete ramen order!");
                    }
                }
                case 2 -> {
                    orderList.clear(); // Clear the orderList if mags-start ng new ramen
                    orderList.add(getItemByName("Water"));
                    orderList.add(getItemByName("Noodles"));
                    orderList.add(getItemByName("Egg"));
                    orderList.add(getItemByName("Cheese"));
                    orderList.add(getItemByName("Ramen Powder"));
                    orderList.add(getItemByName("Green Onion"));

                    // Calculate total calories and total price based on the ingredients in orderList
                    int totalCalories = countCalories();
                    double totalPrice = countPrice();

                    if (hasStock()) {
                        if (totalPrice <= getUserCash()) {
                            setUserCash(getUserCash() - totalPrice);
                            setSold(getSold() + 1);
                            setTotalSales(getTotalSales() + totalPrice);

                            System.out.println("You have bought: Kujirai Ramen");
                            System.out.println("Boiling water...");
                            System.out.println("Cooking noodles in boiling water, draining, and rinsing with cold water...");
                            System.out.println("Whisking egg, cooking, and cutting into thin strips...");
                            System.out.println("Grating cheese into small cubes...");
                            System.out.println("Sprinkling ramen powder into boiling water with noodles...");
                            System.out.println("Washing and chopping green onions into thin slices for garnish...");
                            System.out.println("Assembling...");
                            System.out.println("Finished!");
                            System.out.println("Now Serving: Kujirai Ramen");
                            System.out.println("Total Calories: " + totalCalories);
                            System.out.println("Total Price: ₱" + totalPrice);

                            // Delete instances of the purchased ingredients
                            dispenseItems();

                        } else {
                            System.out.println("You cannot afford this item!");
                        }
                    } else {
                        System.out.println("Incomplete ingredients, cannot complete ramen order!");
                    }
                }
                case 3 -> {
                    orderList.clear(); // Clear the orderList if mags-start ng new ramen
                    orderList.add(getItemByName("Water"));
                    orderList.add(getItemByName("Noodles"));
                    orderList.add(getItemByName("Gochugaru"));
                    orderList.add(getItemByName("Whole Milk"));
                    orderList.add(getItemByName("Ramen Powder"));
                    orderList.add(getItemByName("Green Onion"));

                    // Calculate total calories and total price based on the ingredients in orderList
                    int totalCalories = countCalories();
                    double totalPrice = countPrice();

                    if (hasStock()) {
                        if (totalPrice <= getUserCash()) {
                            setUserCash(getUserCash() - totalPrice);
                            setSold(getSold() + 1);
                            setTotalSales(getTotalSales() + totalPrice);

                            System.out.println("You have bought: Milk Ramen");
                            System.out.println("Boiling water in a pot and adding noodles...");
                            System.out.println("Mixing in gochugaru...");
                            System.out.println("Pouring in whole milk and stirring until well combined for a creamy broth...");
                            System.out.println("Adding ramen powder for additional flavor and seasoning...");
                            System.out.println("Washing and chopping green onions into thin slices for garnish...");
                            System.out.println("Assembling...");
                            System.out.println("Finished!");
                            System.out.println("Now Serving: Milk Ramen");
                            System.out.println("Total Calories: " + totalCalories);
                            System.out.println("Total Price: ₱" + totalPrice);

                            // Delete instances of the purchased ingredients
                            dispenseItems();

                        } else {
                            System.out.println("You cannot afford this item!");
                        }
                    } else {
                        System.out.println("Incomplete ingredients, cannot complete ramen order!");
                    }
                }
                case 4 -> {
                    orderList.clear(); // Clear the orderList if mags-start ng new ramen
                    orderList.add(getItemByName("Broth"));
                    orderList.add(getItemByName("Noodles"));
                    orderList.add(getItemByName("Egg"));
                    orderList.add(getItemByName("Rice Cake"));
                    orderList.add(getItemByName("Fish Cake"));
                    orderList.add(getItemByName("Cabbage"));
                    orderList.add(getItemByName("Seaweed"));
                    orderList.add(getItemByName("Gochujang"));
                    orderList.add(getItemByName("Gochugaru"));

                    // Calculate total calories and total price based on the ingredients in orderList
                    int totalCalories = countCalories();
                    double totalPrice = countPrice();

                    if (hasStock()) {
                        if (totalPrice <= getUserCash()) {
                            setUserCash(getUserCash() - totalPrice);
                            setSold(getSold() + 1);
                            setTotalSales(getTotalSales() + totalPrice);

                            System.out.println("You have bought: Rabokki");
                            System.out.println("Preparing the broth in a pot...");
                            System.out.println("Boiling the noodles...");
                            System.out.println("Poaching the egg...");
                            System.out.println("Adding the rice cake and fish cake to the simmering broth...");
                            System.out.println("Shredding the cabbage and adding it to the pot...");
                            System.out.println("Soaking the seaweed in water to rehydrate...");
                            System.out.println("Stirring in gochujang...");
                            System.out.println("Sprinkling gochugaru...");
                            System.out.println("Assembling...");
                            System.out.println("Finished!");
                            System.out.println("Now Serving: Rabokki");
                            System.out.println("Total Calories: " + totalCalories);
                            System.out.println("Total Price: ₱" + totalPrice);

                            // Delete instances of the purchased ingredients
                            dispenseItems();

                        } else {
                            System.out.println("You cannot afford this item!");
                        }
                    } else {
                        System.out.println("Incomplete ingredients, cannot complete ramen order!");
                    }
                }
                case 5 -> {
                    orderList.clear(); // Clear the orderList if mags-start ng new ramen
                    orderList.add(getItemByName("Water"));
                    orderList.add(getItemByName("Noodles"));
                    orderList.add(getItemByName("Chunjang"));
                    orderList.add(getItemByName("Pork"));
                    orderList.add(getItemByName("Salt"));
                    orderList.add(getItemByName("Radish"));
                    orderList.add(getItemByName("Zucchini"));
                    orderList.add(getItemByName("Onion"));
                    orderList.add(getItemByName("Vegetable Oil"));

                    // Calculate total calories and total price based on the ingredients in orderList
                    int totalCalories = countCalories();
                    double totalPrice = countPrice();

                    if (hasStock()) {
                        if (totalPrice <= getUserCash()) {
                            setUserCash(getUserCash() - totalPrice);
                            setSold(getSold() + 1);
                            setTotalSales(getTotalSales() + totalPrice);

                            System.out.println("You have bought: Jjajjangmyeon");
                            System.out.println("Boiling water in a pot and cooking the noodles...");
                            System.out.println("Stir-frying the pork with vegetable oil...");
                            System.out.println("Adding diced onions and continuing to stir-fry until they become translucent...");
                            System.out.println("Incorporating the chunjang and mixing well with the pork and onions...");
                            System.out.println("Adding sliced radish and zucchini...");
                            System.out.println("Seasoning the mixture with a pinch of salt for taste...");
                            System.out.println("Cooking the chunjang until it thickens...");
                            System.out.println("Assembling...");
                            System.out.println("Finished!");
                            System.out.println("Now Serving: Jjajjangmyeon");
                            System.out.println("Total Calories: " + totalCalories);
                            System.out.println("Total Price: ₱" + totalPrice);

                            // Delete instances of the purchased ingredients
                            dispenseItems();

                        } else {
                            System.out.println("You cannot afford this item!");
                        }
                    } else {
                        System.out.println("Incomplete ingredients, cannot complete ramen order!");
                    }
                }
                case 6 -> {
                    if (userCash >= 18) {
                        if (countStock("Noodles") >= 1 && countStock("Water") >= 1 && countStock("Broth") >= 1) {
                            customizeRamen(scanner);
                        } else {
                            System.out.println("Incomplete ingredients, cannot customize ramen order!");
                        }
                    }
                    else {
                        System.out.println("You cannot afford to customize ramen!");
                    }
                }
                case 7 -> System.out.println("Returning to the test menu...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    /**
     * This method displays the available ramen options in the vending machine along with their details,
     * such as name, calories, price, and current stock quantity.
     */
    public void displayRamen(){
        System.out.println("----- Ramen Options -----");

        // Ramen Block
        orderList.clear(); // Clear the orderList if mags-start ng new ramen
        orderList.add(getItemByName("Broth"));
        orderList.add(getItemByName("Noodles"));
        orderList.add(getItemByName("Egg"));
        orderList.add(getItemByName("Pork"));
        orderList.add(getItemByName("Salt"));
        System.out.printf("1. %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                "Ramen", countCalories(), countPrice(), countRamenStock());

        // Kujirai Ramen Block
        orderList.clear(); // Clear the orderList if mags-start ng new ramen
        orderList.add(getItemByName("Water"));
        orderList.add(getItemByName("Noodles"));
        orderList.add(getItemByName("Egg"));
        orderList.add(getItemByName("Cheese"));
        orderList.add(getItemByName("Ramen Powder"));
        orderList.add(getItemByName("Green Onion"));
        System.out.printf("2. %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                "Kujirai Ramen", countCalories(), countPrice(), countRamenStock());

        // Milk Ramen Block
        orderList.clear(); // Clear the orderList if mags-start ng new ramen
        orderList.add(getItemByName("Water"));
        orderList.add(getItemByName("Noodles"));
        orderList.add(getItemByName("Gochugaru"));
        orderList.add(getItemByName("Whole Milk"));
        orderList.add(getItemByName("Ramen Powder"));
        orderList.add(getItemByName("Green Onion"));
        System.out.printf("3. %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                "Milk Ramen", countCalories(), countPrice(), countRamenStock());

        // Rabokki Block
        orderList.clear(); // Clear the orderList if mags-start ng new ramen
        orderList.add(getItemByName("Broth"));
        orderList.add(getItemByName("Noodles"));
        orderList.add(getItemByName("Egg"));
        orderList.add(getItemByName("Rice Cake"));
        orderList.add(getItemByName("Fish Cake"));
        orderList.add(getItemByName("Cabbage"));
        orderList.add(getItemByName("Seaweed"));
        orderList.add(getItemByName("Gochujang"));
        orderList.add(getItemByName("Gochugaru"));
        System.out.printf("4. %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                "Rabokki", countCalories(), countPrice(), countRamenStock());

        // Jjajjangmyeon Block
        orderList.clear(); // Clear the orderList if mags-start ng new ramen
        orderList.add(getItemByName("Water"));
        orderList.add(getItemByName("Noodles"));
        orderList.add(getItemByName("Chunjang"));
        orderList.add(getItemByName("Pork"));
        orderList.add(getItemByName("Salt"));
        orderList.add(getItemByName("Radish"));
        orderList.add(getItemByName("Zucchini"));
        orderList.add(getItemByName("Onion"));
        orderList.add(getItemByName("Vegetable Oil"));
        System.out.printf("5. %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                "Jjajjangmyeon", countCalories(), countPrice(), countRamenStock());

        System.out.printf("6. %-15s Minimum Calories: %-5d Minimum Price: %-7.2f\n",
                "Customize Ramen", 220, 18.00);
        System.out.println("7. Back to Vending Features Menu");
    }

    /**
     * This method allows the user to customize their own ramen order.
     *
     * @param scanner The Scanner object used to input data from the user.
     */
    public void customizeRamen(Scanner scanner){
        int option;
        int slot;
        boolean validOption;
        orderList.clear();
        System.out.println("----- Customize Ramen -----");
        orderList.add(getItemByName("Noodles"));
        deleteInstance("Noodles");

        // Asks the user if they want broth or water
        System.out.println("Please choose a soup base");
        System.out.println("1. Water");
        System.out.println("2. Broth");
        do {
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            if (option >= 1 && option <= 2) {
                validOption = true;
            } else {
                System.out.println("Invalid input! Please try again.");
                validOption = false;
            }
        } while (!validOption);

        if (option == 1){
            if (userCash >= 25){
                orderList.add(getItemByName("Water"));
                deleteInstance("Water");
            } else {
                System.out.println("You cannot afford this item!");
                System.out.println("Broth will be used instead");
                orderList.add(getItemByName("Broth"));
                deleteInstance("Broth");
            }
        } else {
            orderList.add(getItemByName("Broth"));
            deleteInstance("Broth");
        }

        // Asks the user if they want to add more items or finish their order
        System.out.println("1. Add more items to custom ramen order");
        System.out.println("2. Finish custom ramen order");
        do {
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            if (option >= 1 && option <= 2) {
                validOption = true;
            } else {
                System.out.println("Invalid input! Please try again.");
                validOption = false;
            }
        } while (!validOption);

        if (option == 1) {
            if (getUserCash() >= countPrice()) {
                // Code for buying more items
                do {
                    displayItems();
                    System.out.printf("You currently have ₱%.2f\n", getUserCash());
                    System.out.println("Choose any item to add to your custom ramen order.");
                    System.out.println("Enter 0 if you are finished.");
                    System.out.print("Enter the slot number: ");
                    slot = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    while (slot < 0 || slot > uniqueItemList.size()) {
                        System.out.println("Invalid slot number! Please try again.");
                        System.out.print("Enter the slot number: ");
                        slot = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    }
                    if (slot > 0) {
                            Item item = uniqueItemList.get(slot - 1);
                            if (item.getStock() >= 1) {
                                if (item.getPrice() <= getUserCash()) {
                                    setUserCash(getUserCash() - item.getPrice());
                                    item.setStock(item.getStock() - 1);
                                    setSold(getSold() + 1);
                                    System.out.println("Purchase successful! You have added " + item.getName() + " to your custom ramen order");
                                    setTotalSales(getTotalSales() + item.getPrice());

                                    // New code for purchaseItem
                                    orderList.add(getItemByName(item.getName()));
                                    deleteInstance(item.getName());
                                    updateUniqueItemList();
                                } else {
                                    System.out.println("You cannot afford this item!");
                                    System.out.println("Choose a cheaper item or finish your custom order.");
                                }
                            } else {
                                System.out.println("This item is sold out!");
                            }
                        }
                } while (slot != 0);
            } else {
                System.out.println("You cannot afford to purchase any more items");
            }
        }

        // Prints the different ingredients and how they are prepared
        updateUniqueOrderList();
        printIngredients();

        double totalPrice = countPrice();
        System.out.println("Total Calories: " + countCalories());
        System.out.println("Total Price: ₱" + totalPrice);

        setUserCash(getUserCash() - totalPrice);
        setSold(getSold() + 1);
        setTotalSales(getTotalSales() + totalPrice);

        orderList.clear();
    }

    /**
     * This method prints the preparation steps for the ingredients in the customized ramen order.
     */
    public void printIngredients(){
        String name;
        for (Item item : uniqueOrderList){
            name = item.getName();
            switch (name){
                case "Noodles" -> System.out.println("Cooking Noodles to al dente...");
                case "Water" -> System.out.println("Boiling Water...");
                case "Broth" -> System.out.println("Heating Broth...");
                case "Pork" -> System.out.println("Stir Frying Pork till cooked through...");
                case "Chicken" -> System.out.println("Frying Chicken till golden brown...");
                case "Beef" -> System.out.println("Stir frying Beef till cooked through...");
                case "Egg" -> System.out.println("Soft boiling Egg...");
                case "Cabbage" -> System.out.println("Chopping Cabbage...");
                case "Seaweed" -> System.out.println("Cutting Seaweed into squares...");
                case "Rice" -> System.out.println("Cooking Rice...");
                case "Rice Cake" -> System.out.println("Boiling Rice Cake until soft...");
                case "Fish Cake" -> System.out.println("Boiling Fish Cake until soft...");
                case "Whole Milk" -> System.out.println("Heating Milk...");
                case "Cheese" -> System.out.println("Grating Cheese for toppings...");
                case "Ramen Powder" -> System.out.println("Mixing in Ramen Powder for a flavourful soup...");
                case "Green Onion" -> System.out.println("Chopping Green Onion...");
                case "Gochujang" -> System.out.println("Incorporating Gochujang for heat and flavor...");
                case "Gochugaru" -> System.out.println("Incorporating Gochugaru...");
                case "Chunjang" -> System.out.println("Incorporating Chunjang for extra savoury...");
                case "Radish" -> System.out.println("Dicing Radish...");
                case "Zucchini" -> System.out.println("Chopping Zucchini...");
                case "Onion" -> System.out.println("Dicing Onion...");
                case "Vegetable Oil" -> System.out.println("Drizzling with Vegetable Oil...");
                case "Salt" -> System.out.println("Seasoning with Salt to taste...");
                default -> System.out.println("Adding " + name + "...");
            }
        }
    }

    /**
     * This method displays all the items in the vending machine along with their details,
     * such as name, calories, price, and current stock quantity.
     */
    @Override
    public void displayItems() {
        System.out.println("----- Display Items -----");
        int itemNumber = 1;
        updateUniqueItemList();
        // Printing of unique elements
        for (Item item : uniqueItemList) {
            System.out.printf("Item %-2d: %-15s Calories: %-5d Price: %-7.2f Quantity: %-3d\n",
                    itemNumber, item.getName(), item.getCalories(), item.getPrice(), countStock(item.getName()));
            itemNumber++;
        }
        System.out.println("Finished displaying all items!");
    }

    /**
     * This method allows a user to purchase an item from the vending machine.
     *
     * @param scanner The Scanner object used to input data from the user.
     */
    @Override
    public void purchaseItem(Scanner scanner){
        displayItems();
        updateUniqueItemList();
        System.out.println("----- Purchase Item -----");
        System.out.printf("You currently have ₱%.2f\n", getUserCash());
        System.out.print("Enter the slot number: ");
        int slot = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while (slot < 1 || slot > uniqueItemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            slot = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        Item item = uniqueItemList.get(slot - 1);
        if(VMChangeList.get(0).getQuantity() == 0 || VMChangeList.get(1).getQuantity() == 0 || VMChangeList.get(2).getQuantity() == 0 ||
                VMChangeList.get(3).getQuantity() == 0 || VMChangeList.get(4).getQuantity() == 0 || VMChangeList.get(5).getQuantity() == 0 ||
                VMChangeList.get(6).getQuantity() == 0 || VMChangeList.get(7).getQuantity() == 0 || VMChangeList.get(8).getQuantity() == 0) {
            System.out.println("Cannot continue transaction due to insufficient change, please ask the owner to replenish all denominations of change.");
        } else {
            if (!isInCantBuyAlone(item.getName())) {
                if (item.getStock() >= 1) {
                    if (item.getPrice() <= getUserCash()) {
                        setUserCash(getUserCash() - item.getPrice());
                        item.setStock(item.getStock() - 1);
                        setSold(getSold() + 1);
                        System.out.println("Purchase successful! Dispensing: " + item.getName());
                        setTotalSales(getTotalSales() + item.getPrice());
                        // Code for deleting instance of purchased item

                        deleteInstance(item.getName());

                    } else {
                        System.out.println("You cannot afford this item!");
                    }
                } else {
                    System.out.println("This item is sold out!");
                }
            } else {
                System.out.println("You cannot purchase " + item.getName() + " separately!");
            }
        }
    }


    /**
     * This method allows replenishing the stock of an existing item in the vending machine.
     *
     * @param scanner The Scanner object used to input data from the user.
     */
    @Override
    public void replenishStock(Scanner scanner) {
        int quantity;
        boolean validStock;
        displayItems();
        System.out.println("----- Replenish Stock -----");
        System.out.print("Enter the slot number: ");
        int slot = scanner.nextInt();
        scanner.nextLine();

        while (slot < 1 || slot > uniqueItemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            slot = scanner.nextInt();
            scanner.nextLine();
        }

        int itemIndex = slot - 1;
        Item item = uniqueItemList.get(itemIndex);

        do {
            System.out.print("Enter the quantity to replenish: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity > 0) {
                validStock = true;
            } else {
                System.out.println("Invalid input! Please try again.");
                System.out.println("Stock to be added cannot be less than 1");
                validStock = false;
            }
        } while (!validStock);

        System.out.println("Stock replenished successfully!");
        System.out.println("Item " + slot + ": " + item.getName() + " Previous Stock: " + countStock(item.getName()));

        // Create new instances based on the quantity and add them to the itemList
        if (item.getStock() == 0){
            item.setStock(quantity);
            createInstance(item.getName(), item.getCalories(), item.getPrice(), quantity - 1);
        } else {
            item.setStock(quantity);
            createInstance(item.getName(), item.getCalories(), item.getPrice(), quantity);
        }

        System.out.println("Item " + slot + ": " + item.getName() + " Current Stock: " + countStock(item.getName()));
    }

    /**
     * This method allows adding a new item to the vending machine.
     *
     * @param scanner The Scanner object used to input data from the user.
     */
    @Override
    public void addItem(Scanner scanner){
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

            // Call createInstance with the parameters entered by the user
            createInstance(name, calories, price, stock);
            // Call updateUniqueItemList to add created item to uniqueItemList
            updateUniqueItemList();
            System.out.println("You have successfully added Item " + (uniqueItemList.size()) + ": " + uniqueItemList.get(uniqueItemList.size() - 1).getName() + " Calories: "
                    + uniqueItemList.get(uniqueItemList.size() - 1).getCalories() + " Price: " + uniqueItemList.get(uniqueItemList.size() - 1).getPrice() +
                    " Stock: " + countStock(uniqueItemList.get(uniqueItemList.size() - 1).getName()));
        }

    }

    /**
     * This method allows changing the price of an existing item in the vending machine.
     *
     * @param scanner The Scanner object used to input data from the user.
     */
    @Override
    public void changePrice(Scanner scanner){
        double price;
        boolean validPrice;
        System.out.println("----- Change Price -----");
        displayItems();
        System.out.println("Choose an item to edit the price.");
        int item = scanner.nextInt();
        scanner.nextLine();
        while (item < 1 || item > uniqueItemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            item = scanner.nextInt();
            scanner.nextLine();
        }
        do {
            System.out.println("Please enter the price: ");
            price = scanner.nextDouble();
            if (price >= 1){
                validPrice = true;
            } else {
                System.out.println("Invalid input! Please try again.");
                System.out.println("Price cannot be less than 1.");
                validPrice = false;
            }
        } while (!validPrice);

        System.out.println("Item " + item + ": " + uniqueItemList.get(item - 1).getName() + " Previous Price: " + uniqueItemList.get(item - 1).getPrice());
        // Call updatePrice to update price of each instance of the object
        updatePrice(uniqueItemList.get(item - 1).getName(), price);
        // Call updateUniqueItemList to reflect updated price to uniqueItemList
        updateUniqueItemList();
        System.out.println("Item " + item + ": " + uniqueItemList.get(item - 1).getName() + " Current Price: " + uniqueItemList.get(item - 1).getPrice());
        System.out.println("Price updated successfully!");
    }

    /**
     * This method prints a summary of the vending machine's inventory and sales.
     */
    @Override
    public void printSummary() {
        int itemNumber = 1;
        updateUniqueItemList();
        System.out.println("----- Purchase Summary -----");
        System.out.println("Starting Inventory:");

        for (Item item : uniqueItemList) {
            int startingStock = getInitialStock(item.getName());
            System.out.printf("Item %d: %-20s Quantity: %-5d\n", itemNumber, uniqueItemList.get(itemNumber-1).getName(), startingStock);
            itemNumber++;
        }

        itemNumber = 1;
        System.out.println("\nEnding Inventory:");

        for (Item item : uniqueItemList) {
            int endingStock = countStock(item.getName());
            System.out.printf("Item %d: %-20s Quantity: %-5d\n", itemNumber, uniqueItemList.get(itemNumber-1).getName(), endingStock);
            itemNumber++;
        }

        System.out.println("\nQuantity Sold: " + getSold());
        System.out.println("Total Sales: ₱" + getTotalSales());
    }

    /**
     * This method marks an item as "not sold separately," meaning it cannot be purchased individually.
     *
     * @param scanner The Scanner object used to input data from the user.
     */
    public void newNotSoldSeparately(Scanner scanner){
        System.out.println("----- Cannot Be Sold Separately -----");
        displayItems();
        System.out.println("Choose an item to make it unable to be purchased individually");
        int item = scanner.nextInt();
        scanner.nextLine();
        while (item < 1 || item > uniqueItemList.size()) {
            System.out.println("Invalid slot number! Please try again.");
            System.out.print("Enter the slot number: ");
            item = scanner.nextInt();
            scanner.nextLine();
        }
        if (isInCantBuyAlone(uniqueItemList.get(item - 1).getName())){
            System.out.println(uniqueItemList.get(item - 1).getName() + " is already present!");
        } else {
            addToCantBuyAlone(uniqueItemList.get(item - 1).getName());
            System.out.println("Successfully added " + uniqueItemList.get(item - 1).getName() + " to the list!");
            displayCantBuyAlone();
        }
    }
}
