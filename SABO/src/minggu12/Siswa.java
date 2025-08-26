public class Siswa {
    private int nilai;
    private String nama;

    public void masuknilai(int n) {
           nilai = n;
        if (n >= 0 && n <= 70) 
            System.out.println("Nilai " + nama + " Adalah : " + nilai + "\nPesan dan Kesan Untuk " + nama + " : Terus Belajar dan jangan putus asa");
        else if (n >= 71 && n <= 80) 
            System.out.println("Nilai " + nama + " Adalah : " + nilai + "\nPesan dan Kesan Untuk " + nama + " : Tingkatkan Terus Agar Meraih Ranking");
        else if (n >= 81 && n <= 90) 
            System.out.println("Nilai " + nama + " Adalah : " + nilai + "\nPesan dan Kesan Untuk " + nama +  " : Tetap Pertahankan Nilai Saat Ini Dan Tingkatkan Lebih Baik Lagi");
        else if (n >= 91 && n <= 100) 
            System.out.println("Nilai " + nama + " Adalah : " + nilai + "\nPesan dan Kesan Untuk " + nama +  " : Luar Biasa, Terus Pertahankan Nilai Anda!!");
    }

    private int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    private String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
