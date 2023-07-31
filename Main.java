import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachineGUI gui1 = new VendingMachineGUI();
        VendingMachineOptions gui2 = new VendingMachineOptions();
        RegularVendingFeatures gui3 = new RegularVendingFeatures();
        RegularMaintenanceFeatures gui4 = new RegularMaintenanceFeatures();
        SpecialVendingFeatures gui5 = new SpecialVendingFeatures();
        SpecialMaintenanceFeatures gui6 = new SpecialMaintenanceFeatures();
        VendingMachine regularVM = new VendingMachine();
        SpecialVendingMachine specialVM = new SpecialVendingMachine();

        VendingMachineController controller = new VendingMachineController(gui1, gui2, gui3, gui4, gui5, gui6,
                regularVM, specialVM);
    }
}
/*
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = null;
        SpecialVendingMachine specialVendingMachine = null;
        int vmType = 0;
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
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.println("Choose the type of vending machine:");
                        System.out.println("1. Regular");
                        System.out.println("2. Special");
                        System.out.print("Enter your choice: ");
                        int vendingType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (vendingType) {
                            case 1 -> {
                                vendingMachine = new VendingMachine();
                                vendingMachine.addItems();
                                vendingMachine.addMoney();
                                validInput = true;
                                vmType = 1;
                            }
                            case 2 -> {
                                specialVendingMachine = new SpecialVendingMachine();
                                specialVendingMachine.addItems();
                                specialVendingMachine.addMoney();
                                validInput = true;
                                vmType = 2;
                            }
                            default -> System.out.println("Invalid vending machine type! Please try again.");
                        }
                    }
                }
                case 2 -> {
                    if (vendingMachine == null && specialVendingMachine == null) {
                        System.out.println("Vending Machine not created yet!");
                    } else if (vmType == 1){
                        vendingMachine.testFeatures(scanner);
                    } else {
                        specialVendingMachine.testFeatures(scanner);
                         SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                new VendingMachineGUI();
                            }
                        }
                    }
                }
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (option != 3);
    }
 */
