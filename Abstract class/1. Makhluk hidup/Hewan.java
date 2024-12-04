public class Hewan extends MakhlukHidup {
    @Override
    public void makan() {
        System.out.println("Hewan makan dengan cara berbeda-beda sesuai jenisnya.");
    }

    @Override
    public void bernafas() {
        System.out.println("Hewan bernafas menggunakan paru-paru, insang, atau kulit.");
    }

    @Override
    public void berkembangBiak() {
        System.out.println("Hewan berkembang biak secara seksual atau aseksual.");
    }
}
