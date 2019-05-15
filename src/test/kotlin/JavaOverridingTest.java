package test.kotlin;

public class JavaOverridingTest {

    private static class Parent {

        private final int foo = 1;

        public int getFoo() {
            return foo;
        }

        public Parent() {
            System.out.println(getFoo());
        }
    }

    private static class Child extends Parent {

        private final int foo = 2;

        @Override
        public int getFoo() {
            return foo;
        }
    }

    public static void main(String[] args) {
        new Parent();
        new Child();
    }
}
