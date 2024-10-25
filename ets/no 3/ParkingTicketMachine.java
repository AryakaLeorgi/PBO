public class ParkingTicketMachine {
    private int balance;
    private int ticketPrice;
    private int ticketTime;

    public ParkingTicketMachine(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.balance = 0;
        this.ticketTime = 0;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Uang berhasil ditambahkan: Rp" + amount);
        } else {
            System.out.println("Masukkan jumlah uang yang valid.");
        }
    }

    public void issueTicket() {
        if (balance >= ticketPrice) {
            ticketTime = balance / ticketPrice;
            balance = balance % ticketPrice; 
            System.out.println("Tiket berhasil dikeluarkan untuk " + ticketTime + " jam parkir.");
        } else {
            System.out.println("Saldo tidak cukup untuk membeli tiket. Tambahkan lebih banyak uang.");
        }
    }

    public int getTimePurchased() {
        return ticketTime;
    }

    public int getBalance() {
        return balance;
    }
}