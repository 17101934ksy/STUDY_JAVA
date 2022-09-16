package Generic;

public class myFunctionalInterfaceExample {
    public static void main(String[] args){
        MyFunctionalInterface fi;

        fi = (x, y) -> {
            System.out.println(x + y);
            return x + y;
        };
        fi.method(10, 15);

        fi = (x, y) -> x + y;
        int test1 = fi.method(26, 27);
        System.out.println(test1);

        fi = (x, y) -> {
            System.out.println(x * x);
            return x * y;
        };
        fi.method(35, 10);
    }
}
