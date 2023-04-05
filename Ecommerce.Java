// ✅ Import java library untuk user input
import java.util.Scanner;

public class Ecommerce {
    // 👋 Deklarasi fields
    public static int total; // => untuk menyimpan value dari total harga
    public static int is_resume = 1; // => 1 : run app, 0 : stop app

    // 📔 Method utama 
    public static void main( String[] args ){
        // Deklarasi objek scanner
        Scanner scanner_menu = new Scanner(System.in);
        // ✅ passing parameter scanner menu ke fungsi display menu ( line 21)
        displayMenu(scanner_menu);
    }
    // ✅ method untuk menampilkan sama dengan yang banyak
    public static void garis(){
      System.out.println("===========================================");
    }
    // ✅ method untuk nge print sesuatu ke layar
    public static void print(Object x){
      System.out.println(x);
    }
    // ✅ method untuk menampilkan menu
    public static void displayMenu(Scanner scanner_menu){
        // 👏 Buat array untuk tampung data - data ecommerce : item, kategori, harga
        String[] items = {"KERIPIK KACA", "CELANA API", "BASRENG", "FANTA CAMPUR ENERGEN", "KUKUBIMA SUSU DANCOW"};
        String[] categories = {"MAKANAN", "PAKAIAN", "MAKANAN", "MINUMAN", "MINUMAN"};
        String[] harga = {"9000", "12000", "5000", "12000", "9000"};

        print("\n");
        garis();
        print("   SELAMAT DATANG DI APLIKASI E-COMMERCE");
        garis();
        // 👏 Jika property is_resume bernilai 1 maka jalankan perintah dibawah
        while(Ecommerce.is_resume == 1){
            print("\nMENU :");
            print("1. ITEM YANG DIJUAL");
            print("2. ITEM YANG AKAN DIBELI");
            print("3. PEMBAYARAN \n");
            System.out.print("PILIH MENU( 1/2/3 ) : ");
            int selected_menu = scanner_menu.nextInt();
            garis();
            // Jika user memilih 1 ✍️
            if(selected_menu == 1){
                displayItem(items, categories, harga);
            }else if(selected_menu == 2){ // Jika user memilih 2 ✍️
                displayBuyItem(scanner_menu, items, categories, harga);
            }else if(selected_menu == 3){ // Jika user memilih 3 ✍️
                displayCash(scanner_menu);
            }else{
                print("MENU YANG ANDA MASUKKAN SALAH/TIDAK DITEMUKAN");
            }
            garis();
        }
    }
    // ✅ method untuk menampilkan item pada menu 1 dengan 3 param
    public static void displayItem(String[] items, String[] categories, String[] harga){
        print("\nITEM YANG DIJUAL : \n");
        // ✅ Tampilin data array dengan for loop
        for (int i = 0; i < items.length; i++) {
          System.out.println("| " + (i+1) + " | "+ items[i] + " | " + categories[i] + " | => " + harga[i]);
        }
    }

    // ✅ method untuk menampilkan item pada menu 2 dengan 4 param
    public static void displayBuyItem(Scanner scanner_buy, String[] items, String[] categories, String[] harga){
        System.out.print("MASUKKAN NOMOR ITEM YANG AKAN DIBELI : ");
        int selected_buy = scanner_buy.nextInt();
        for (int item = 0; item < items.length; item++) {
            if( selected_buy == item + 1 ){
                print(" > " + items[item] + " | "+categories[item] + " | => Rp. " + harga[item]);
            }
        }
        
        System.out.print("\nMASUKKAN JUMLAH ITEM YANG AKAN DIBELI : ");
        int count_item = scanner_buy.nextInt();
        // Banyaknya item yang di beli akan dikalikan dengan harga item
        Ecommerce.total = count_item * Integer.parseInt(harga[selected_buy - 1]);
    }
    // ✅ Method untuk display menu 3 dengan 1 param
    public static void displayCash(Scanner scanner_cash){
        print("\nTOTAL HARGA BELANJA KAMU ADALAH >> " + Ecommerce.total + "\n");
        System.out.print("MASUKKAN JUMLAH UANG KAMU : ");
        int uang_pembeli = scanner_cash.nextInt();
        scanner_cash.nextLine();
        // Jika uang si pembeli kelebihan... maka kembalikan 👍 & reset property total
        if(uang_pembeli > Ecommerce.total){
            int bayar = uang_pembeli - Ecommerce.total;
            print("TRANSAKSI BERHASIL");
            print("KEMBALIAN KAMU >> " + bayar + " <<");
            Ecommerce.total = 0;
        }
        // Jika uang si pembeli sama seperti harga barang & reset property total 👇
        else if(uang_pembeli == Ecommerce.total){ 
            print("KAMU MEMBERIKAN UANG PAS");
            print("TRANSAKSI BERHASIL");
            Ecommerce.total = 0;
        }
        // saat uang pembeli tidak cukup 👇
        while(uang_pembeli < Ecommerce.total){
            print("\n >> UANG TIDAK MENCUKUPI <<");
            print("UANG ANDA >> " + uang_pembeli);
            // Untuk nge cek berapa jumlah yang gak cukup bisa total dikurang uang pembeli 👇
            print("UANG YANG KURANG : " + (Ecommerce.total - uang_pembeli));
            System.out.print("\nTAMBAH UANG YANG KURANG : ");
            int uang_kurang = scanner_cash.nextInt();
            scanner_cash.nextLine();
            // Jika uang yang kurangnya kelebihan.. maka kembalikan 👇
            if(uang_kurang > Ecommerce.total - uang_pembeli){
                print("KEMBALIAN KAMU ADALAH : " + (uang_kurang - (Ecommerce.total - uang_pembeli)));
            }
            // Kalo masi ga cukup maka minta lagi 👇
            while(uang_kurang < (Ecommerce.total - uang_pembeli)){
                print("\n>> UANG TIDAK MENCUKUPI <<");
                System.out.print("TAMBAH UANG KAMU : ");
                int uang_kurang_2 = scanner_cash.nextInt();
                scanner_cash.nextLine();
                uang_kurang += uang_kurang_2;
            }
            uang_pembeli += uang_kurang;
            print(">> TRANSAKSI BERHASIL << \n");
            Ecommerce.total = 0;
        }
         // Cek apakah pembeli ingin lanjut belanja atau tidak👇
        System.out.print("\nAPAKAH ANDA INGIN MELANJUTKAN BELANJA (1:Iya/0:Tidak)? ");
        int lanjut = scanner_cash.nextInt();
        if(lanjut == 0){
            print("\n");
            garis();
            print("TERIMA KASIH SUDAH BERBELANJA DI TOKO KAMI");
            Ecommerce.is_resume = 0;
        }else if(lanjut == 1){
            print("SILAHKAN MELANJUTKAN BELANJA NYA ");
        }
        // switch(lanjut){
        //     case 0:
        //         print("\n");
        //         garis();
        //         print("TERIMA KASIH SUDAH BERBELANJA DI TOKO KAMI");
        //         Ecommerce.is_resume = 0;
        //         break;
        //     case 1:
        //         print("SILAHKAN MELANJUTKAN BELANJA NYA ");
        //     default :
        //         print("PERINTAH TIDAK DIKETAHUI");
        // }
    }

}
