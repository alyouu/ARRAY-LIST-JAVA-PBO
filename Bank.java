public class Bank {
    private Customer[] customers; 
    private int numberOfCustomers;

    public Bank() {
        // Menginisialisasi array dengan batas maksimal, misalnya 10 nasabah
        customers = new Customer[10]; 
        numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l) {
        customers[numberOfCustomers] = new Customer(f, l);
        numberOfCustomers++;
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}