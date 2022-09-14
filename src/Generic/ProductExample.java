package Generic;

public class ProductExample {
    public static void main(String[] args){
        Product<Tv, String> product1 = new Product<Tv, String>();

        product1.setKind(new Tv());
        product1.setModel("smart Tv");
        Tv tv = product1.getKind();

        String tvModel = product1.getModel();

        System.out.println(tv);
        System.out.println(tvModel);
    }
}
