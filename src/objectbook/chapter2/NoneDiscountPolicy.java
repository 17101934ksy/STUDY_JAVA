package objectbook.chapter2;

public class NoneDiscountPolicy implements DiscountPolicy{

    @Override
    public Money calculateDiscountAmount(ScreenMovie screenMovie) {
        return Money.Zero;
    }
}
