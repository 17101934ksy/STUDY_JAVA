package objectbook.chapter2;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(ScreenMovie screenMovie) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screenMovie));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }

}
