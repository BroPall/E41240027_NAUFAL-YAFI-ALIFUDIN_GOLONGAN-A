package semester_2;

import java.util.Scanner;

public class Tugas_minggu3_Acara_9_10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Batas awal : ");
        int batasAwal =  input.nextInt();
        System.out.print("Batas akhir : ");
        int batasAkhir = input.nextInt();
        
        System.out.print("Bilangan genap mulai dari " + batasAwal + " hingga " + batasAkhir + " = ");
        
        for (int k = batasAwal; k <= batasAkhir; k++) {
        if (k % 2 == 0){
            System.out.println(k + " ");
        }
    }
    }
}
