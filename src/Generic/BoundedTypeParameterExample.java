package Generic;

public class BoundedTypeParameterExample {
    public static void main(String[] args){
        double v1 = 102.2;
        double v2 = 103.3;

        int result1 = Util.compare(v1, v2);
        int result2 = Util.compare(v1, v2);
        
        System.out.println(result1 + result2);
    }
}
