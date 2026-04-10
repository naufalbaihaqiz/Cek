import java.util.Scanner;
//sss
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Data Buku");
            System.out.println("3. Update Stok Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");

            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1 -> buku.createBuku(sc);
                case 2 -> buku.readBuku();
                case 3 -> buku.updateStok(sc);
                case 4 -> buku.deleteBuku(sc);
                case 5 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        sc.close();
    }
}
