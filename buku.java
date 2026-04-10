import java.sql.*;
import java.util.Scanner;

public class buku {

    
    public static void createBuku(Scanner sc) {
        System.out.print("Kode Buku: ");
        String kode = sc.nextLine();

        System.out.print("Judul Buku: ");
        String judul = sc.nextLine();

        System.out.print("Penulis: ");
        String penulis = sc.nextLine();

        System.out.print("Stok: ");
        int stok = sc.nextInt();
        sc.nextLine();

        String sql = "INSERT INTO buku VALUES (?, ?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ps.setString(2, judul);
            ps.setString(3, penulis);
            ps.setInt(4, stok);

            ps.executeUpdate();
            System.out.println("\nData berhasil ditambahkan!");

        } catch (SQLException e) {
            System.out.println("Gagal menambah buku: " + e.getMessage());
        }
    }


    public static void readBuku() {
        System.out.println("\n=== KATALOG PERPUSTAKAAN ===");

        String sql = "SELECT * FROM buku";

        try (Connection conn = koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Kode: " + rs.getString("kode_buku"));
                System.out.println("Judul: " + rs.getString("judul_buku"));
                System.out.println("Penulis: " + rs.getString("penulis"));
                System.out.println("Stok: " + rs.getInt("stok"));
                System.out.println("----------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }

    
    public static void updateStok(Scanner sc) {
        System.out.print("Masukkan Kode Buku yang ingin diupdate: ");
        String kode = sc.nextLine();

        System.out.print("Masukkan Stok Baru: ");
        int stok = sc.nextInt();
        sc.nextLine();

        String sql = "UPDATE buku SET stok=? WHERE kode_buku=?";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, stok);
            ps.setString(2, kode);

            ps.executeUpdate();
            System.out.println("\nData berhasil diperbarui!");

        } catch (SQLException e) {
            System.out.println("Gagal update: " + e.getMessage());
        }
    }

    public static void deleteBuku(Scanner sc) {
        System.out.print("Masukkan Kode Buku yang ingin dihapus: ");
        String kode = sc.nextLine();

        String sql = "DELETE FROM buku WHERE kode_buku=?";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ps.executeUpdate();
            System.out.println("\nData berhasil dihapus!");

        } catch (SQLException e) {
            System.out.println("Gagal menghapus: " + e.getMessage());
        }
    }
}
