package objectbook.chapter2;

public class Reservation {

    private Customer customer;
    private ScreenMovie screenMovie;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, ScreenMovie screenMovie, Money fee, int audienceCount) {
        this.customer = customer;
        this.screenMovie = screenMovie;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
