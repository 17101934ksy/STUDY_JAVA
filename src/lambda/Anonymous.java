package lambda;

public class Anonymous {
    private int field;


    /**
     * 익명객체는 실제 클래스처럼 힙 메모리에서 관리되므로 로컬 변수는 사라지더라도 익명 객체 내부에서 사용한 로컬 변수는 효력이 있음
     * 따라서, 변수의 값의 동일성이 깨지는 상황을 방지하기 위해 final 변수를 사용하여 처리하도록 해야함 (자바8 이상부터는 final을 붙이지 않아도 final 특성을 지님)
     */
    public void method(final int arg1, int arg2) {
        final int var1 = 0;
        int var2 = 0;
        field = 10;

        Calculator calculator = new Calculator() {
            @Override
            public int sum() {
                return field + arg1 + arg1 + var1 + var2;
            }
        };

        System.out.println("calculator.sum() = " + calculator.sum());
    }

}
