package objectbook.chapter2;

public class PercentDiscountPolicy extends DefaultDiscountPolicy{

    private double percent;


    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(ScreenMovie screenMovie) {
        return null;
    }
}
