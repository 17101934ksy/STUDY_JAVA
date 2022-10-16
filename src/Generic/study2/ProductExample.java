package Generic.study2;

public class ProductExample {

    public static void main(String[] args){

        Product<String, Car> bmw1 = new Product<String, Car>();
        Product<String, Car> benz1 = new Product<String, Car>();

        Car bmw = new Car();
        Car benz = new Car();

        bmw1.setT("BMW");
        bmw1.setM(bmw);

        benz1.setT("BENZ");
        benz1.setM(benz);

        String nameBmw = bmw1.getT();
        String nameBenz = benz1.getT();

        System.out.println(nameBmw);
        System.out.println(nameBenz);
    }
}
