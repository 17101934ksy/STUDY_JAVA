package lambda;

public class Main {
    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = () -> {System.out.println("test");};
        myFunctionalInterface.method();

        MyReturnTypeFunction myReturnTypeFunction = (x, y) -> {return x + y;};
        System.out.println("myReturnTypeFunction = " + myReturnTypeFunction.add(3, 5));


        UsingThis usingThis = new UsingThis();
        UsingThis.Inner inner = usingThis.new Inner();
        inner.method();

        Anonymous anonymous = new Anonymous();
        anonymous.method(0, 10);
    }
}
