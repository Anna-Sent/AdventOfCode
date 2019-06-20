package test;

public class FinalTest1 {

    private static class A {

        private final Integer h = 42;
        private final Runnable r = () -> System.out.println(h);

        A(B b) {
            b.test(r);
        }
    }

    private static class B {

        void test(Runnable r) {
            r.run();
        }
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
    }
}
