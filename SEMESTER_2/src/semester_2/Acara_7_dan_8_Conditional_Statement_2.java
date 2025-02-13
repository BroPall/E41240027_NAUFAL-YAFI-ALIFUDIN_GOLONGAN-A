package semester_2;

import java.util.Scanner;

public class Acara_7_dan_8_Conditional_Statement_2 {

    public static void main(String[] args) {
        String minuman;
        int angka;
        String nama;

        Scanner scan = new Scanner(System.in);
        Scanner can = new Scanner(System.in);

        System.out.println("                CAFE CERIA");
        System.out.println("               ANEKA MINUMAN");
        System.out.println("----------------------------------------------");
        System.out.println("              SPESIAL MENU :");
        System.out.println("             1. Soft Drinks");
        System.out.println("             2. Mix Juice");
        System.out.println("             3. Nescafe");
        System.out.println("             4. Soda milk");
        System.out.println("             5. Tea");
        System.out.println("----------------------------------------------");

        System.out.print("Masukkan nama pembeli : ");
        nama = scan.nextLine();
        
        System.out.print("Silahkan masukkan pilihan anda : ");
        angka = can.nextInt();

        switch (angka) {
            case 0:
                System.out.println("Minuman yang anda pesan tidak tersedia pada Cafe kami");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
            case 1:
                System.out.println("Minuman yang anda pesan adalah Soft Drinks");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
            case 2:
                System.out.println("Minuman yang anda pesan adalah Mix Juice");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
            case 3:
                System.out.println("Minuman yang anda pesan adalah Nescafe");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
            case 4:
                System.out.println(" Minuman yang anda pesan adalah Soda milk");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
            case 5:
                System.out.println("Minuman yang anda pesan adalah Tea");
                System.out.println("Pesanan akan segera kami antar");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
            case 6:
                System.out.println("Minuman yang anda pesan tidak tersedia pada Cafe kami");
                System.out.println("Terima Kasih " + nama + " telah berkunjung di Cafe Ceria");
                break;
        }

    }

}
