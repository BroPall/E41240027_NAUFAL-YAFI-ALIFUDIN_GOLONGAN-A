package Pewarisan;

    class A {

        void callthis() {
            System.out.println("Inside Class A's Method!! ");
        }
    }

    class B extends A {

        void callthis() {
            System.out.println("Inside Class B's Method!! ");
        }
    }

    class C extends A {

        void callthis() {
            System.out.println("Inside Class C's Method!! ");
        }
    }

     class DynamicDispath {

        public static void main(String[] args) {
            A a = new A();
            B b = new B();
            C c = new C();
            A ref;

            ref = b;
            ref.callthis();

            ref = c;
            ref.callthis();

            ref = a;
            ref.callthis();
        }
    }

