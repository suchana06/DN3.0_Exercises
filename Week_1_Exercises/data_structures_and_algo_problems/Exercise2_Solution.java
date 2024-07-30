import java.util.Arrays;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", category='" + category + '\'' + '}';
    }
}

public class Exercise2_Solution{
    private Product[] products;
    private Product[] sortedProducts;

    public Exercise2_Solution(Product[] products) {
        this.products = products;
        this.sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (p1, p2) -> p1.productName.compareToIgnoreCase(p2.productName));
    }

    public Product linearSearch(String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(String productName) {
        int low = 0, high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = productName.compareToIgnoreCase(sortedProducts[mid].productName);
            if (cmp == 0) {
                return sortedProducts[mid];
            }
            if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Desk Chair", "Furniture"),
            new Product(5, "Notebook", "Stationery")
        };

        Exercise2_Solution searchSystem = new Exercise2_Solution(products);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter product name to search (Linear Search): ");
                    String nameLinear = scanner.nextLine();
                    Product resultLinear = searchSystem.linearSearch(nameLinear);
                    System.out.println(resultLinear != null ? resultLinear : "Product not found.");
                }
                case 2 -> {
                    System.out.print("Enter product name to search (Binary Search): ");
                    String nameBinary = scanner.nextLine();
                    Product resultBinary = searchSystem.binarySearch(nameBinary);
                    System.out.println(resultBinary != null ? resultBinary : "Product not found.");
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
