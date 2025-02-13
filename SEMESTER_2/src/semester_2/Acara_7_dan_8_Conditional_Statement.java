package semester_2;

import java.util.Scanner;

public class Acara_7_dan_8_Conditional_Statement {

    public static void main(String[] args) {
//     membuat variabel 
        int harga = 0;
        int total;
        String nama;
        Scanner scan = new Scanner(System.in);
        Scanner can = new Scanner(System.in);
//     mengambil input

        System.out.println("----------------------------------------------");
        System.out.println("     Kharisma Agung PLaza < KAP > ");
        System.out.println("        Promo Belanja berhadiah");
        System.out.println("  Khusus Pembelian 5 Barang Pertama");
        System.out.println("   Dengan Harga minimum Rp 10000,00");
        System.out.println("----------------------------------------------");
        System.out.print("Masukkan nama pembeli : ");
        nama = scan.next();
        System.out.println();

        System.out.print("Masukkan harga barang ke-1 : ");
        harga += can.nextInt();
        System.out.print("Masukkan harga barang ke-2 : ");
        harga += can.nextInt();
        System.out.print("Masukkan harga barang ke-3 : ");
        harga += can.nextInt();
        System.out.print("Masukkan harga barang ke-4 : ");
        harga += can.nextInt();
        System.out.print("Masukkan harga barang ke-5 : ");
        harga += can.nextInt();
        System.out.println("Total harga pembelian atas nama " + nama + " adalah " + " Rp. " + harga);

        System.out.println();
            System.out.println("Selamat.... ");
            System.out.println("Anda mendapat hadiah 1 buah mug cantik");

            System.out.println("----------------------------------------------");
        

        System.out.println("             Terima Kasih    ");
        System.out.println(" Anda sudah belanja di Kharisma Agung Plaza");

    }
}
