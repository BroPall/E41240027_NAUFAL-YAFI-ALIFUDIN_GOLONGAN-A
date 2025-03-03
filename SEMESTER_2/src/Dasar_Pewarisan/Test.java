package Dasar_Pewarisan;

public class Contoh_pelajar extends Contoh_orang {
    private String nim;
    private String asalSekolah;
    private double nilai;
    
    public Contoh_pelajar (String nama, double tinggi, double berat, String nama, String asalSekolah, double nilai) {
        super (nama, tinggi, berat);
        this .nim = nim;
        asalSekolah = sekolah;
        this.nilai = nilai;
    }
    
    public String toString(){
        return (super.toString()+"\nNIM : " + nim + "\nSekolah : " + asalSekolah + "\nNilai : " + nilai);
    }
    
    public class Test {
        public static void main(String[] args) {
            pelajar mahasiswa= new Pelajar("Lukman", 172, 75, "1010651098", "UM JEMBER", 98.8);
            System.out.println(mahasiswa.toString());
        }
    }
}
