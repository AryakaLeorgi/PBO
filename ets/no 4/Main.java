import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        orderFood();
    }

    public static void orderFood() {
        Scanner scanner = new Scanner(System.in);
        FoodOrder order = new FoodOrder();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Display Order");
            System.out.println("2. Display Menu");
            System.out.println("3. Order Food");
            System.out.println("4. Insert Money");
            System.out.println("5. Pay");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    order.displayOrder();
                    break;
                case 2:
                    order.displayMenu();
                    break;
                case 3:
                    System.out.print("Enter menu number to add: ");
                    int menuNumber = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    order.orderFood(menuNumber, quantity);
                    break;
                case 4:
                    System.out.print("Enter amount to insert: ");
                    double amount = scanner.nextDouble();
                    order.insertMoney(amount);
                    break;
                case 5:
                    order.pay();
                    if (order.isPaid()) {
                        ordering = false;
                    }
                    break;
                case 6:
                    // Keluar dari program
                    ordering = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close(); 
    }
}
