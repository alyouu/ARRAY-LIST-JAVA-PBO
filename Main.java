import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        
        // Menambahkan satu nasabah default 
        bank.addCustomer("Budi", "Santoso");
        Customer budi = bank.getCustomer(0);
        budi.addAccount(new Account(500000)); // Saldo awal 500.000
        
        boolean isRunning = true;
        
        while(isRunning) {
            System.out.println("\n=== MENU ATM SEDERHANA ===");
            System.out.println("Nasabah Aktif: " + budi.getFirstName() + " " + budi.getLastName());
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai (Deposit)");
            System.out.println("3. Tarik Tunai (Withdraw)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = scanner.nextInt();
            // Mengambil akun pertama (index 0) milik nasabah
            Account akunAktif = budi.getAccount(0); 
            
            switch(pilihan) {
                case 1:
                    System.out.println("Saldo Anda saat ini: Rp " + akunAktif.getBalance());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah setoran: Rp ");
                    double setor = scanner.nextDouble();
                    if(akunAktif.deposit(setor)) {
                        System.out.println("Setoran berhasil! Saldo baru: Rp " + akunAktif.getBalance());
                    } else {
                        System.out.println("Nominal tidak valid.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan: Rp ");
                    double tarik = scanner.nextDouble();
                    if(akunAktif.withdraw(tarik)) {
                        System.out.println("Penarikan berhasil! Sisa saldo: Rp " + akunAktif.getBalance());
                    } else {
                        System.out.println("Saldo tidak mencukupi!");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan ATM kami.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}