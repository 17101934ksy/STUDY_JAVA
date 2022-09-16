package Generic;

public class UsingLocalVariable {
    void method(int arg) {
        int localVar = 40;

    MyFunctionInterface2 fi = () -> {
        System.out.println("arg: " + arg);
        System.out.println("localVar: " + localVar + "\n");
    };
    fi.method();

    }
}
