package Dasar_Pewarisan;

public class Contoh_pelajar extends Contoh_orang {
    private String nim;
    private String asalSekolah;
    private double nilai;

    public Contoh_pelajar(String nama, double tinggi, double berat, String nim, String asalSekolah, double nilai) {
        super(nama, tinggi, berat);
        this.nim = nim;
        this.asalSekolah = asalSekolah;
        this.nilai = nilai;
    }
    public String toString(){
        return (super.toString()+"\nNIM : " + nim + "\nSekolah : " + asalSekolah + "\nNilai : " + nilai);
    }
        
}