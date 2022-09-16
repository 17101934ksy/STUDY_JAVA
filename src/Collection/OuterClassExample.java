package Collection;

public class OuterClassExample {
    public static void main(String[] args){

        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        System.out.println(inner.a);



        OuterClass.InnerStaticClass innerStatic = new OuterClass.InnerStaticClass();





    }
}
