import java.util.HashMap;
import java.util.Scanner;

// Product class to define the product attributes
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", quantity=" + quantity + ", price=" + price + '}';
    }
}

// Main class to manage the inventory
public class Exercise1_Solution {
    private HashMap<Integer, Product> inventory;

    public Exercise1_Solution() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.quantity = quantity;
            product.price = price;
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        Product removedProduct = inventory.remove(productId);
        if (removedProduct != null) {
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exercise1_Solution system = new Exercise1_Solution();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    system.addProduct(new Product(id, name, quantity, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    double newPrice = scanner.nextDouble();
                    system.updateProduct(updateId, newQuantity, newPrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    system.deleteProduct(deleteId);
                    break;
                case 4:
                    System.out.println("Products in Inventory:");
                    system.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
