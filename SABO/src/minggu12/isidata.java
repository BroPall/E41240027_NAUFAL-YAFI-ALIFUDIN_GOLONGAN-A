import java.util.Scanner;

public class isidata {
    public static void main(String[] args) {
        
        int inputnilai;
        
        Scanner MasukNilai = new Scanner(System.in);
        Siswa s = new Siswa();

        System.out.print("Masukkan Nama Anda: ");
        String namaInput = MasukNilai.nextLine();
        s.setNama(namaInput);
        
        do {
            System.out.print("Masukkan Nilai (0-100) : ");
            inputnilai = MasukNilai.nextInt();
            if (inputnilai < 0 || inputnilai > 100) {
                System.out.println("Nilai harus antara 0 sampai 100. Tolong Input Lagi.");
            }
        } while (inputnilai < 0 || inputnilai > 100);

        s.masuknilai(inputnilai);
        MasukNilai.close();
    }
}
