package objectbook.chapter2;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

public class PeriodCondition implements DiscountCondition{

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(ScreenMovie screenMovie) {
        return Objects.equals(screenMovie.getStartTime().getDayOfMonth(), dayOfWeek) &&
                startTime.compareTo(screenMovie.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screenMovie.getStartTime().toLocalTime()) >= 0;

    }
}
