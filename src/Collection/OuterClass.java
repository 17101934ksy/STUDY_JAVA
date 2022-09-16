package Collection;

public class OuterClass {
    int a = 10;
    int b = 11;

    public void method1(){
        System.out.println("outer class");
    }

    public int method2() {
        return this.a;
    }

    public int method3(int a, int b) {
        return a + b;
    }

    public int method4(int a, int b) {
        return this.a + this.b;
    }

    class InnerClass {
        int a = 10;
        int b = 11;

        public void method1(){
            OuterClass.this.method2();
        }

    }

    static class InnerStaticClass {
        int a = 12;
        int b = 13;

    }
}
