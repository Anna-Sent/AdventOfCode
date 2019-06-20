package test;

public class FinalTest2 {

    private static class A {

        A() {
            m();
        }

        protected void m() {
        }
    }

    private static class B extends A {

        private final Integer h = 42;

        B() {
        }

        @Override
        protected void m() {
            System.out.println(h);
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
    }
}
