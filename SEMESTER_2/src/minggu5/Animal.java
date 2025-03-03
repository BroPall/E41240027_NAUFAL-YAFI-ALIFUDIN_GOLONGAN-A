package minggu5;

public class Animal {
    public void makeNoise() {
        System.out.println("Talk");
    }
}

class Dog extends Animal {
    public void makeNoise() {
        System.out.println("Bark");
        
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeNoise();
        
        Dog dog = new Dog();
        dog.makeNoise();

        Animal animaldog = new Dog();
        animaldog.makeNoise();

        if (animal instanceof Animal) {
            System.out.println("animal is Animal");
        }
        if (dog instanceof Animal) {
            System.out.println("dog is Animal");
        }
        if (animaldog instanceof Animal) {
            System.out.println("animal dog is Animal");
        }
        if (animal instanceof Dog) {
            System.out.println("animal is Dog");
        } else {
            System.out.println("animal is NOT Dog");
        }
    }
}

