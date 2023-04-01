// ✅ Import java library untuk user input
import java.util.Scanner;

public class Ecommerce {
    // 📔 Method utama 
    public static void main( String[] args ){
        // Deklarasi objek scanner
        Scanner scanner_menu = new Scanner(System.in);
        // ✅ passing parameter scanner menu ke fungsi display menu ( line 21)
        displayMenu(scanner_menu);
    }
    // ✅ method untuk menampilkan sama dengan
    public static void garis(){
      System.out.println("========================================");
    }
    // ✅ method untuk nge print sesuatu ke layar
    public static void print(String x){
      System.out.println(x);
    }
    // ✅ method untuk menampilkan menu
    public static void displayMenu(Scanner scanner_menu){
        print("\n");
        garis();
        print("SELAMAT DATANG DI APLIKASI E-COMMERCE");
        garis();
        print("\nMENU :");
        print("1. ITEM YANG DIJUAL");
        print("2. ITEM YANG AKAN DIBELI");
        print("3. PEMBAYARAN \n");
        System.out.print("PILIH MENU( 1/2/3 ) : ");
        int selected_menu = scanner_menu.nextInt();
        garis();
        if(selected_menu == 1){
            displayItem();
        }
        garis();
    }
    // ✅ method untuk menampilkan item pada menu 1
    public static void displayItem(){
        // ✅ Buat array untuk tampung data - data ecommerce
        String[] items = {"KERIPIK KACA", "CELANA API", "BASRENG", "FANTA CAMPUR ENERGEN", "KUKUBIMA SUSU DANCOW"};
        String[] categories = {"MAKANAN", "PAKAIAN", "MAKANAN", "MINUMAN", "MINUMAN"};
        print("\nITEM YANG DIJUAL : \n");
        // ✅ Tampilin data array dengan for loop
        for (int i = 0; i < items.length; i++) {
          System.out.println("| " + (i+1) + " | "+ items[i] + " | " + categories[i]);
        }
    }

    // KALAU MAU DILANJUTKAN SILAHKAN YAA 👋
    /* YANG BELUM SELESAI DARI ALUR KERJA APLIKASI : 
        NOMOR 4 - 15 
    */
}
