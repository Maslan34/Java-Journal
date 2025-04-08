package CapstoneProjects.PatikaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Brand Samsung = new Brand(1L, "Samsung");
        Brand Lenova = new Brand(2L, "Lenova");
        Brand Apple = new Brand(3L, "Apple");
        Brand Huawei = new Brand(4L, "Huawei");
        Brand Casper = new Brand(5L, "Casper");
        Brand Asus = new Brand(6L, "Asus");
        Brand Hp = new Brand(7L, "Hp");
        Brand Xiaomi = new Brand(8L, "Xiaomi");
        Brand Monster = new Brand(9L, "Monster");

        final StorageManager storeManager = StorageManager.getInstance();

        Notebook notebook = new Notebook("Abra A5", 12000.0, 5, 3.0, Monster, "Green", 16, 512, 16);
        Notebook notebook6 = new Notebook("Abra A7", 14000.0, 15, 3.0, Monster, "Green", 32, 512, 16);
        Notebook notebook1 = new Notebook("Tulpar T7", 18000.0, 3, 4.5, Monster, "Black", 32, 512, 14);
        Notebook notebook2 = new Notebook("Semruk S9", 25000.0, 2, 4.8, Monster, "Silver", 64, 1024, 16);


        Notebook notebook3 = new Notebook("Huawei MateBook", 13000.0, 12, 12.0, Huawei, "Gray", 8, 512, 13);
        Notebook notebook4 = new Notebook("Asus ROG", 25000.0, 5, 8.0, Asus, "Black", 32, 2_048, 17);
        Notebook notebook5 = new Notebook("HP Spectre", 20000.0, 6, 5.0, Hp, "Gold", 16, 512, 14);


        MobilePhone phone1 = new MobilePhone("Samsung Galaxy S24", 49999.99, 15, 10.0, Samsung, "Black", 256, 6.2, 4000);
        MobilePhone phone2 = new MobilePhone("iPhone 15 Pro", 59999.99, 10, 5.0, Apple, "Silver", 512, 6.1, 4200);
        MobilePhone phone3 = new MobilePhone("Xiaomi 13T Pro", 29999.99, 20, 8.0, Xiaomi, "Blue", 256, 6.7, 5000);
        MobilePhone phone4 = new MobilePhone("Samsung Galaxy S23", 39999.99, 12, 7.0, Samsung, "Green", 512, 6.8, 4800);

        storeManager.addProduct(notebook);
        storeManager.addProduct(notebook6);
        storeManager.addProduct(notebook1);
        storeManager.addProduct(notebook2);
        storeManager.addProduct(notebook3);
        storeManager.addProduct(notebook4);
        storeManager.addProduct(notebook5);


        storeManager.addProduct(phone1);
        storeManager.addProduct(phone2);
        storeManager.addProduct(phone3);
        storeManager.addProduct(phone4);

        Scanner input = new Scanner(System.in);

        int selection;
        do {
            printMenu();
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    String operations = "----- Notebook Operations -----";
                    String result = centerString(operations, 30);
                    System.out.println(result);
                    System.out.println(String.format("%-30s", "1-List Notebooks"));
                    System.out.println(String.format("%-30s", "2-Add Notebook"));
                    System.out.println(String.format("%-30s", "3-Delete Notebook"));
                    System.out.println(String.format("%-30s", "4-Update Notebook"));
                    System.out.println(String.format("%-30s", "5-Filter Notebook"));

                    int operation = input.nextInt();
                    switch (operation) {
                        case 1:
                            storeManager.listProducts(PRODUCT_TYPES.NOTEBOOK);
                            break;
                        case 2:
                            addProcut(PRODUCT_TYPES.NOTEBOOK);
                            break;
                        case 3:
                            deleteProduct();
                            break;
                        case 4:
                            updateProduct(PRODUCT_TYPES.NOTEBOOK);
                            break;
                        case 5:
                            filterProduct(PRODUCT_TYPES.NOTEBOOK);
                            break;
                        default:
                            System.out.println("Invalid selection");
                            break;

                    }

                    break;
                case 2:
                    String operationmobile = "----- Mobile Phone Operations -----";
                    String resultMobile = centerString(operationmobile, 30);
                    System.out.println(resultMobile);
                    System.out.println(String.format("%-30s", "1-List Mobile Phones"));
                    System.out.println(String.format("%-30s", "2-Add Mobile Phone"));
                    System.out.println(String.format("%-30s", "3-Delete Mobile Phone"));
                    System.out.println(String.format("%-30s", "4-Update Mobile Phone"));
                    System.out.println(String.format("%-30s", "5-Filter Mobile Phone"));

                    int operationMobile = input.nextInt();
                    switch (operationMobile) {
                        case 1:
                            storeManager.listProducts(PRODUCT_TYPES.MOBILE_PHONES);
                            break;
                        case 2:
                            addProcut(PRODUCT_TYPES.MOBILE_PHONES);
                            break;
                        case 3:
                            deleteProduct();
                            break;
                        case 4:
                            updateProduct(PRODUCT_TYPES.MOBILE_PHONES);
                            break;
                        case 5:
                            filterProduct(PRODUCT_TYPES.MOBILE_PHONES);
                            break;
                        default:
                            System.out.println("Invalid selection");
                            break;

                    }
                    break;
                case 3:
                    Brand.printBrands();
                    System.out.println();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nInvalid selection\n");
            }
        } while (selection != 4);


    }

    private static void updateProduct(PRODUCT_TYPES type) {

        System.out.println("\nUpdate Product Operation");
        System.out.println("Enter Product ID");
        Scanner input = new Scanner(System.in);
        int productID = input.nextInt();



        StorageManager storageManager = StorageManager.getInstance();

        if (productID < 0 || storageManager.findProduct(productID) == null) {
            System.out.println("Please Enter a Valid ID");
        } else {
            StorageManager storeManager = StorageManager.getInstance();

            if (type == PRODUCT_TYPES.NOTEBOOK) {
                Notebook notebook = (Notebook) storeManager.findProduct(productID);
                System.out.println();
                System.out.println("""
                        Which field do you want to update?
                        1-Name          2-Price          3-Stock
                        4-Discount Rate 5-Brand          6-Color
                        7-Ram           8-Storage        9-Screen Size
                        """);

                Scanner scanner = new Scanner(System.in);
                int choice;
                while (true) {

                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice >= 1 && choice <= 9) {
                            break;
                        } else {
                            System.out.println("Invalid selection! Please enter a number between 1 and 9.");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a numeric value.");
                        scanner.next();
                    }
                }
                switch (choice) {

                    case 1: // Name
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        notebook.setName(newName);
                        break;
                    case 2: // Price
                        System.out.print("Enter new price: ");
                        Double newPrice = scanner.nextDouble();
                        notebook.setPrice(newPrice);
                        break;
                    case 3: // Stock
                        System.out.print("Enter new stock: ");
                        int newStock = scanner.nextInt();
                        notebook.setStock(newStock);
                        break;
                    case 4: // Discount Rate
                        System.out.print("Enter new discount rate: ");
                        Double newDiscountRate = scanner.nextDouble();
                        notebook.setDiscountRate(newDiscountRate);
                        break;
                    case 5: // Brand

                        Brand selectedBrand = null;
                        boolean valid = false;

                        while (!valid) {
                            scanner.nextLine();
                            Brand.printBrands();
                            System.out.print("Please specify a brand: ");
                            int brandChoice = scanner.nextInt();
                            if (brandChoice >= 1 && brandChoice <= Brand.brands.size()) {
                                selectedBrand = Brand.brands.get(brandChoice - 1);
                                valid = true;
                            } else {
                                System.out.println("Invalit input! Please enter a valid brand.");
                            }
                        }
                        notebook.setBrand(selectedBrand);
                        break;
                    case 6: // Color
                        System.out.print("Enter new color: ");
                        String newColor = scanner.nextLine();
                        notebook.setColor(newColor);
                        break;
                    case 7: // Ram
                        System.out.print("Enter new RAM size: ");
                        int newRam = scanner.nextInt();
                        notebook.setRam(newRam);
                        break;
                    case 8: // Storage
                        System.out.print("Enter new Storage size: ");
                        int storage = scanner.nextInt();
                        notebook.setStorage(storage);
                        break;
                    case 9: // Screen Size
                        System.out.print("Enter new Screen Size: ");
                        float newScreenSize = scanner.nextFloat();
                        notebook.setScreeSize(newScreenSize);
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            } else {

                MobilePhone mobilePhone = (MobilePhone) storeManager.findProduct(productID);
                System.out.println();
                System.out.println("""
                        Which field do you want to update?
                        1-Name          2-Price          3-Stock
                        4-Discount Rate 5-Brand          6-Color
                        7-Memory           8-Battery Power        9-Screen Size
                        """);

                Scanner scanner = new Scanner(System.in);
                int choice;
                while (true) {

                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        if (choice >= 1 && choice <= 9) {
                            break;
                        } else {
                            System.out.println("Invalid selection! Please enter a number between 1 and 9.");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a numeric value.");
                        scanner.next();
                    }
                }


                switch (choice) {

                    case 1: // Name
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        mobilePhone.setName(newName);
                        break;
                    case 2: // Price
                        System.out.print("Enter new price: ");
                        Double newPrice = scanner.nextDouble();
                        mobilePhone.setPrice(newPrice);
                        break;
                    case 3: // Stock
                        System.out.print("Enter new stock: ");
                        int newStock = scanner.nextInt();
                        mobilePhone.setStock(newStock);
                        break;
                    case 4: // Discount Rate
                        System.out.print("Enter new discount rate: ");
                        Double newDiscountRate = scanner.nextDouble();
                        mobilePhone.setDiscountRate(newDiscountRate);
                        break;
                    case 5: // Brand
                        Brand selectedBrand = null;
                        boolean valid = false;

                        while (!valid) {
                            scanner.nextLine();
                            Brand.printBrands();
                            System.out.print("Please specify a brand: ");
                            int brandChoice = scanner.nextInt();
                            if (brandChoice >= 1 && brandChoice <= Brand.brands.size()) {
                                selectedBrand = Brand.brands.get(brandChoice - 1);
                                valid = true;
                            } else {
                                System.out.println("Invalit input! Please enter a valid brand.");
                            }
                        }
                        mobilePhone.setBrand(selectedBrand);
                        break;
                    case 6: // Color
                        System.out.print("Enter new color: ");
                        String newColor = scanner.nextLine();
                        mobilePhone.setColor(newColor);
                        break;
                    case 7: // Memory
                        System.out.print("Enter new memory size: ");
                        int memory = scanner.nextInt();
                        mobilePhone.setMemory(memory);
                        break;
                    case 8: // Battery Power
                        System.out.print("Enter new Battery Power size: ");
                        int batteryPower = scanner.nextInt();
                        mobilePhone.setBatteryPower(batteryPower);
                        break;
                    case 9: // Screen Size
                        System.out.print("Enter new Screen Size: ");
                        Double newScreenSize = scanner.nextDouble();
                        mobilePhone.setScreenSize(newScreenSize);
                        break;
                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            }
        }
    }


    private static void filterProduct(PRODUCT_TYPES type) {
        System.out.println("----- Filter Product -----");
        System.out.println("Please enter the filter you want to:");
        System.out.println("1- Filter By Name");
        System.out.println("2- Filter By Price");

        Scanner input = new Scanner(System.in);
        StorageManager storeManager = StorageManager.getInstance();

        int selection = input.nextInt();
        List<Product> filteredList = new ArrayList<>();

        switch (selection) {
            case 1:
                // Name filter
                System.out.println("Please Enter A Name");
                String filter = input.next().toLowerCase();  // input name and convert to lower case for case-insensitive matching
                filteredList = storeManager.filterProductsByName(type, filter);
                break;

            case 2:
                // Price filter
                System.out.println("Please Enter A Min Price (Min 0 and Max 10000000):");
                int minPrice = input.nextInt();
                System.out.println("Please Enter A Max Price (Min 0 and Max 10000000):");
                int maxPrice = input.nextInt();

                // Check if the min and max price are valid
                if (minPrice < 0 || minPrice > 10000000 || maxPrice < 0 || maxPrice > 10000000 || minPrice > maxPrice) {
                    System.out.println("Invalid price range. Please ensure prices are within the allowed range (0-10,000,000) and Min <= Max.");
                    return;
                }
                // Filter by price range
                filteredList = storeManager.filterProductsByPrice(type, minPrice, maxPrice);
                break;

            default:
                System.out.println("Invalid selection");
                return;  // Exit if invalid selection
        }

        // Check if the filtered list is empty and display results
        if (filteredList.isEmpty()) {
            System.out.println("No matching products found.\n");
        } else {
            filteredList.forEach(n -> System.out.println("ID: " + n.getId() +
                    " | Name: " + n.getName() +
                    " | Brand: " + n.getBrand() +
                    " | Price: " + n.getPrice() + " TL"));
            System.out.println();
        }
    }


    private static void deleteProduct() {
        System.out.println("\nDelete Product Operation");
        System.out.println("Enter Product ID");
        Scanner input = new Scanner(System.in);
        int productID = input.nextInt();
        StorageManager storeManager = StorageManager.getInstance();

        if (productID < 0 && Notebook.counter < productID) {
            System.out.println("Please Enter a Valid ID");
        } else {
            storeManager.deleteProduct(productID);
        }
    }


    public static void printMenu() {
        String textWelcome = "Welcome to Patika Store";
        String resultWelcome = centerString(textWelcome, 30);
        System.out.println(resultWelcome);
        String text = "Panel";
        String result = centerString(text, 30);
        System.out.println(result);
        System.out.println(String.format("%-30s", "\n1-Notebook Operations"));
        System.out.println(String.format("%-30s", "2-Mobile Operations"));
        System.out.println(String.format("%-30s", "3-List Brands"));
        System.out.println(String.format("%-30s", "4-Exit Panel"));

    }

    public static String centerString(String str, int width) {
        int padding = Math.max(0, (width - str.length()) / 2);
        int remaining = Math.max(0, width - (padding * 2 + str.length()));
        return " ".repeat(padding) + str + " ".repeat(remaining);
    }

    public static void addProcut(PRODUCT_TYPES type) {
        if (type == PRODUCT_TYPES.NOTEBOOK) {
            System.out.println("\nAdd Notebook Operation");
            System.out.println("Please Enter the name of the notebook you would like to add. (String)");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            System.out.println("Please Enter the price of the notebook you would like to add.(Double)");
            double price = input.nextDouble();
            System.out.println("Please Enter the quantity of the notebook you would like to add.(Integer)");
            int quantity = input.nextInt();
            System.out.println("Please Enter the rate of the discount of notebook you would like to add. (Double)");
            double rate = input.nextDouble();
            input.nextLine(); // Clearing line
            Brand selectedBrand = null;
            boolean valid = false;
            while (!valid) {
                input.nextLine();
                Brand.printBrands();
                System.out.print("Please specify a brand: ");
                int brandChoice = input.nextInt();
                if (brandChoice >= 1 && brandChoice <= Brand.brands.size()) {
                    selectedBrand = Brand.brands.get(brandChoice - 1);
                    valid = true;
                } else {
                    System.out.println("Invalit input! Please enter a valid brand.");
                }
            }
            input.nextLine();
            System.out.println("Please Enter the color of the notebook you would like to add.(String)");
            String color = input.nextLine();
            System.out.println("Please Enter the ram of the notebook you would like to add.(Integer)");
            int ram = input.nextInt();
            System.out.println("Please Enter the size storage of the notebook you would like to add.(Integer)");
            int storage = input.nextInt();
            System.out.println("Please Enter the screen size of the notebook you would like to add.(Float)");
            float screen = input.nextFloat();
            Notebook notebook = new Notebook(name, price, quantity, 3.0, selectedBrand, color, ram, storage, screen);
            StorageManager storageManager = StorageManager.getInstance();
            storageManager.addProduct(notebook);
        } else {
            System.out.println("\nAdd Mobile Phone Operation");
            System.out.println("Please Enter the name of the mobile phone you would like to add.(String)");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            System.out.println("Please Enter the price of the mobile phone you would like to add.(Double)");
            double price = input.nextDouble();
            System.out.println("Please Enter the quantity of the mobile phone you would like to add.(Integer)");
            int quantity = input.nextInt();
            System.out.println("Please Enter the battery power of the mobile phone you would like to add.(Integer)");
            int batteryPower = input.nextInt();
            System.out.println("Please Enter the rate of the discount of mobile phone you would like to add.(Double)");
            double rate = input.nextDouble();
            input.nextLine(); // Clearing line
            Brand selectedBrand = null;
            boolean valid = false;
            while (!valid) {
                input.nextLine();
                Brand.printBrands();
                System.out.print("Please specify a brand: ");
                int brandChoice = input.nextInt();
                if (brandChoice >= 1 && brandChoice <= Brand.brands.size()) {
                    selectedBrand = Brand.brands.get(brandChoice - 1);
                    valid = true;
                } else {
                    System.out.println("Invalit input! Please enter a valid brand.");
                }
            }
            input.nextLine();
            System.out.println("Please Enter the color of the mobile phone you would like to add.(String)");
            String color = input.nextLine();
            System.out.println("Please Enter the memory of the mobile phone you would like to add.(Integer)");
            int memory = input.nextInt();
            System.out.println("Please Enter the screen size of the mobile phone you would like to add.(Double)");
            double screen = input.nextDouble();
            MobilePhone phone = new MobilePhone(name, price, quantity, rate, selectedBrand, color, memory, screen, batteryPower);
            StorageManager storageManager = StorageManager.getInstance();
            storageManager.addProduct(phone);
        }

    }
}
