package CapstoneProjects.PatikaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageManager {
    private static StorageManager instance;
    private List<Product> products;

    private StorageManager() {
        products = new ArrayList<>();
    }

    public static StorageManager getInstance() {
        if (instance == null) {
            instance = new StorageManager();
        }
        return instance;
    }


    public void addProduct(Product product) {
        products.add(product);
        System.out.println("\n" + product.getName() + " added Succesfuly!\n");
    }

    public void deleteProduct(int productId) {
        boolean removed = products.removeIf(product -> product.getId() == productId);
        if (removed) {
            System.out.println("\nProduct Deleted!\n");
        } else {
            System.out.println("\nProduct Not Found!\n");
        }
    }

    public void listProducts(PRODUCT_TYPES type) {
        System.out.println("----- List of Products -----");

        List<Notebook> notebooks = new ArrayList<>();
        List<MobilePhone> mobilePhones = new ArrayList<>();

        for (Product product : products) {
            if (product instanceof Notebook) {
                notebooks.add((Notebook) product);
            } else if (product instanceof MobilePhone) {
                mobilePhones.add((MobilePhone) product);
            }
        }

        if(type == PRODUCT_TYPES.NOTEBOOK) {
            if (!notebooks.isEmpty()) {
                printNotebookTable(notebooks);
            }
        }
        else{
            if (!mobilePhones.isEmpty()) {
                printMobilePhoneTable(mobilePhones);
            }
        }


    }

    public List<Product> filterProductsByName(PRODUCT_TYPES type, String name) {

        List<Product> filteredList;

        if (type == PRODUCT_TYPES.NOTEBOOK) {
            filteredList = getNotebooks().stream()
                    .filter(notebook -> notebook.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        } else {
            filteredList = getMobilePhones().stream()
                    .filter(mobilePhone -> mobilePhone.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return filteredList;
    }

    public List<Product> filterProductsByPrice(PRODUCT_TYPES type, int minPrice, int maxPrice) {
        if (minPrice < 0 || maxPrice < 0 || minPrice > maxPrice) {
            System.out.println("Invalid price range. Please enter a valid range.");
            return List.of(); // Boş liste döndür
        }

        List<Product> filteredList;

        if (type == PRODUCT_TYPES.NOTEBOOK) {
            filteredList = getNotebooks().stream()
                    .filter(notebook -> notebook.getPrice() >= minPrice && notebook.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        } else {
            filteredList = getMobilePhones().stream()
                    .filter(mobilePhone -> mobilePhone.getPrice() >= minPrice && mobilePhone.getPrice() <= maxPrice)
                    .collect(Collectors.toList());
        }

        return filteredList;
    }

    private void printNotebookTable(List<Notebook> notebooks) {
        String format = "| %-2s | %-25s | %-9s | %-8s | %-8s | %-8s | %-10s |%n";
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf(format, "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Notebook notebook : notebooks) {
            System.out.printf(format, notebook.getId(), notebook.getName(), notebook.getPrice() + " TL",
                    notebook.getBrand(), notebook.getStorage(), notebook.getScreeSize(), notebook.getRam());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    private void printMobilePhoneTable(List<MobilePhone> mobilePhones) {
        String format = "| %-2s | %-25s | %-9s | %-8s | %-8s | %-8s |%n";
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf(format, "ID", "Product Name", "Price", "Brand", "Battery Power", "Color");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (MobilePhone mobilePhone : mobilePhones) {
            System.out.printf(format, mobilePhone.getId(), mobilePhone.getName(), mobilePhone.getPrice() + " TL",
                    mobilePhone.getBrand(), mobilePhone.getBatteryPower(), mobilePhone.getColor());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }


    public ArrayList<Notebook> getNotebooks(){
            ArrayList<Notebook> notebooks = new ArrayList<>();
            for (Product p : products) {
                if (p instanceof Notebook) {
                    notebooks.add((Notebook) p);
                }
            }
            return notebooks;
    }

    public ArrayList<MobilePhone> getMobilePhones() {
        ArrayList<MobilePhone> mobilePhones = new ArrayList<>();
        for (Product p : products) {
            if (p instanceof MobilePhone) {
                mobilePhones.add((MobilePhone) p);
            }
        }
        return mobilePhones;
    }


    public Product findProduct(int Id){
        for (Product p : products) {
            if (p.getId() == Id) {
                return p;
            }
        }
        return null;
    }
}
