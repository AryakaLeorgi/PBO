// Subclass BusinessTicket
public class BusinessTicket extends Ticket {

    public BusinessTicket(String passengerName, String destination, double baseFare) {
        super(passengerName, destination, baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.; // Tambahan biaya 25%
    }

    @Override
    public String getClassType() {
        return "Bisnis";
    }

    @Override
    public String getFacilities() {
        return "Hiburan premium, makanan lengkap  dengan pilihan menu, tempat duduk lebih luas.";
    }
}