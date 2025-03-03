package Dasar_Pewarisan;

public class Contoh_orang {
    private String nama;
    private double tinggi;
    private double berat;
    
    
    public Contoh_orang (String nama, double tinggi, double berat){
        this.nama = nama;
        this.berat = berat;
        this.tinggi = tinggi;
    }
    public String toString () {
        return ("Nama : " + nama + "\nTinggi : " + tinggi + "\nberat : " + berat);
    }
}
