package objectbook.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    List<DiscountCondition> conditions = new ArrayList<>();


    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(ScreenMovie screenMovie) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screenMovie)) {
                return getDiscountAmount(screenMovie);
            }
        }

        return Money.Zero;
    }

    abstract protected Money getDiscountAmount(ScreenMovie screenMovie);


}
