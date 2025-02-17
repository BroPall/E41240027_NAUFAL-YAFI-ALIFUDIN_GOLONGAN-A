
package semester_2;

public class Array_dua_dimensi {

   
    public static void main(String[] args) {
      int [][] angka = {{5,4,3,2,1,5}, {9,6,5,7,8}, {5,2,1,5,10}};
      for(int baris = 0; baris < 3; baris++){
          for (int kolom = 0; kolom < 5; kolom++) {
              System.out.println(angka[baris][kolom] + "   ");
          }
          System.out.println("");
      }
    }
    
}
