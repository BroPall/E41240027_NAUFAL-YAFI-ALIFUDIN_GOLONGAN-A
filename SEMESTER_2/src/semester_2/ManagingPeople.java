package semester_2;

public class ManagingPeople {
    public static void main(String[] args) {

        Person p1 = new Person("Arial", 37);
        Person p2 = new Person("Jashon", 15);
        
       if (p1.getAge()==p2.getAge()) {
           System.out.println(p1.getName()+ " Adalah nama yang benar, serta umurnya adalah : " + p1.getAge());
       }else{
           System.out.println(p1.getName()+ " Adalah nama yang salah, serta umurnya adalah : " + p2.getAge());
       }  
}
}
