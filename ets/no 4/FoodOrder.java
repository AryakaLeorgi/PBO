import java.util.ArrayList;
import java.util.HashMap;

public class FoodOrder {
    private ArrayList<MenuItem> menuItems;
    private HashMap<MenuItem, Integer> orderItems;
    private double totalPrice;
    private double moneyInserted;
    private boolean isPaid;

    public FoodOrder() {
        menuItems = new ArrayList<>();
        orderItems = new HashMap<>();
        totalPrice = 0.0;
        moneyInserted = 0.0;
        isPaid = false;

        menuItems.add(new MenuItem("Ayam Geprek", 12000));
        menuItems.add(new MenuItem("Cumi Calamary", 15000));
        menuItems.add(new MenuItem("Ayam Panggang", 12000));
        menuItems.add(new MenuItem("Sosis Sapi", 13000));
        menuItems.add(new MenuItem("Enoki Kremus", 10000));
        menuItems.add(new MenuItem("Kulit Ayam Jumbo", 15000));
    }

    public void displayMenu() {
        System.out.println("Available Menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }

    public void orderFood(int menuNumber, int quantity) {
        if (menuNumber >= 1 && menuNumber <= menuItems.size()) {
            MenuItem selectedItem = menuItems.get(menuNumber - 1);
            orderItems.put(selectedItem, orderItems.getOrDefault(selectedItem, 0) + quantity);
            calculateTotal();
            System.out.println(quantity + " " + selectedItem.getName() + " added to order.");
        } else {
            System.out.println("Invalid menu selection.");
        }
    }

    private void calculateTotal() {
        totalPrice = 0.0;
        for (MenuItem item : orderItems.keySet()) {
            totalPrice += item.getPrice() * orderItems.get(item);
        }
    }

    public void insertMoney(double amount) {
        if (amount > 0) {
            moneyInserted += amount;
            System.out.println("Rp" + amount + " has been inserted.");
            System.out.println("Total money inserted: Rp" + moneyInserted);
        } else {
            System.out.println("Please insert a valid amount.");
        }
    }

    public void pay() {
        if (moneyInserted >= totalPrice) {
            double change = moneyInserted - totalPrice;
            isPaid = true;
            System.out.printf("Payment successful! Change: Rp%.2f\n", change);
        } else {
            double remaining = totalPrice - moneyInserted;
            System.out.printf("Payment failed. You need to insert Rp%.2f more.\n", remaining);
        }
    }

    public void displayOrder() {
        System.out.println("Your Order:");
        for (MenuItem item : orderItems.keySet()) {
            int quantity = orderItems.get(item);
            double itemTotalPrice = item.getPrice() * quantity;
            System.out.printf("%d %s - Rp%.2f\n", quantity, item.getName(), itemTotalPrice);
        }
        System.out.printf("Total Price: Rp%.2f\n", totalPrice);

        if (isPaid) {
            System.out.println("Thank you for purchasing, please enjoy your order.");
        } else {
            System.out.println("You have not made a payment yet.");
        }
    }

    public boolean isPaid() {
        return isPaid;
    }
}
