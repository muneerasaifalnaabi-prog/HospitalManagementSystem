package interfaces;

public interface Billable {
    public void calculateCharges();
    public void generateBill();
    public void processPayment(double amount);

}
