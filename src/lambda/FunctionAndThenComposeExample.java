package lambda;


import java.util.function.Function;

public class FunctionAndThenComposeExample {
    public static void main(String[] args) {

        Function<Member, Address> funcA;
        Function<Address, String> funcB;
        Function<Member, String> funcC;

        funcA = (m -> m.getAddress());
        funcB = (a -> a.getCity());
        funcC = funcA.andThen(funcB);


        String city = funcC.apply(new Member("ko", "kose", new Address("korea", "seoul")));

        System.out.println("city = " + city);


    }
}
