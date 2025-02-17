package semester_2;

public class Array_satu_dimensi {

    
    public static void main(String[] args) {
    int [] angka = {5, 10, 17, 20, 1};
    String[]teks={"Saya","Sedang","Belajar","OOP","Java"};
    
    for (int i=0; i<angka.length; i++) {
        System.out.println(angka[i]);
    }
    
    for(int j=0; j<teks.length; j++){
        System.out.print(teks[j]);
        System.out.print(" ");
    }
    }
}
