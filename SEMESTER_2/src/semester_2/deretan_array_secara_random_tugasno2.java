package semester_2;

import java.util.Scanner;

public class deretan_array_secara_random_tugasno2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah angka yang diinginkan: ");
        int nilai = scanner.nextInt();

        int[] deret = new int[nilai];

        for (int i = 0; i < nilai; i++) {
            deret[i] = (int) (Math.random() * 100);
        }

        System.out.print("Hasil deretan array random anda sebagai berikut: ");
        for (int angka : deret) {
            System.out.print(angka + " ");
        }
        System.out.println(); 
    }
}
