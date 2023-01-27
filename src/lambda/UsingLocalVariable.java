package lambda;

public class UsingLocalVariable {

    /**
     * 매개 변수 또는 로컬 변수를 람다식에서 읽는 것은 허용
     * 람다식 내부 또는 외부에서 변경 불가
     */
    void method(int arg) {
        int localVar = 40;
        MyLocalFunction fi = () -> {
            System.out.println("arg:" + arg);
            System.out.println("localVAr:" + localVar);
        };
        fi.method();
    }
}
