public class TicketMachine
{
    // The price of a ticket from this machine.
    public int price;
    // The amount of money entered by a customer so far.
    public int balance;
    // The total amount of money collected by this machine.
    public int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Ensures that the price is greater than zero.
     */
    public TicketMachine(int cost)
    {
        if(cost > 0) {
            price = cost;
        } else {
            // Set a default price if an invalid one is provided
            price = 100; // default to 100 cents
            System.out.println("Invalid price! Price set to default: 100 cents.");
        }
        balance = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Ensure the inserted amount is not negative.
     */
    public int insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Invalid amount! Please insert a positive amount.");
        }
        return balance;
    }

    /**
     * Print a ticket if enough money has been inserted.
     * Otherwise, prompt the customer to insert more money.
     */
    public int printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price (not the balance).
            total = total + price;
            // Deduct the price from the balance.
            balance = balance - price;

            // Call giveChange() to return any leftover balance to the customer.
            giveChange();
        } else {
            System.out.println("Insufficient balance! Please insert at least " + (price - balance) + " more cents.");
        }
        return total;
    }

    /**
     * Refund the balance to the customer.
     * Reset the balance to zero.
     */
    public int refund()
    {
        int amountToRefund = balance;
        if(balance > 0) {
            System.out.println("Refunding " + amountToRefund + " cents.");
            balance = 0;
        } else {
            System.out.println("No balance to refund.");
        }
        return amountToRefund;
    }

    /**
     * Get the total amount of money collected by the machine.
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Return any change if the inserted balance is greater than the price.
     * Update the balance accordingly.
     */
    public int giveChange()
    {
        int change = balance;
        if(balance > 0) {
            System.out.println("Returning " + balance + " cents in change.");
            balance = 0;
        } else {
            System.out.println("No balance to return as change.");
        }
        return change;
    }
}
