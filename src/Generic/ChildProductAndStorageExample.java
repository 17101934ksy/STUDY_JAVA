package Generic;

public class ChildProductAndStorageExample {
    public static void main(String[] args) {
        ChildProductGeneric<Tv, String, String> product = new ChildProductGeneric<Tv, String, String>();
        product.setKind(new Tv());
        product.setModel("smart Tv");
        product.setCompany("samgsung");

        Storage<Tv> storage = new StroageImpl<Tv>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);
    }
}
