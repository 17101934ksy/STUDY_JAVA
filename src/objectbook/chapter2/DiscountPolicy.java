package objectbook.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DiscountPolicy {

    Money calculateDiscountAmount(ScreenMovie screenMovie);

}
