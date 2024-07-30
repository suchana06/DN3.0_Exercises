import java.util.Scanner;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerName='" + customerName + '\'' + ", totalPrice=" + totalPrice + '}';
    }
}

public class Exercise3_Solution {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of orders: ");
        int n = scanner.nextInt();
        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter Total Price: ");
            double totalPrice = scanner.nextDouble();
            orders[i] = new Order(orderId, customerName, totalPrice);
        }
        bubbleSort(orders);
        System.out.println("\nSorted Order List (Bubble Sort):");
        for (Order order : orders) {
            System.out.println(order);
        }

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nSorted Order List (Quick Sort):");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
