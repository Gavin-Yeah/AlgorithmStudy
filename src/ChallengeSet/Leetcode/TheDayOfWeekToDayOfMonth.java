package ChallengeSet.Leetcode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
/**
 * 每年十月份的第二个星期二被认为是XXX节，给你年份，要求返回XXX节是当年十月的第几天
 * @author jiadaye
 *
 */
public class TheDayOfWeekToDayOfMonth {
	
	
	public int date(int year) {
        LocalDate start = LocalDate.of(year, 10, 1);

        if (start.getDayOfWeek() == DayOfWeek.TUESDAY)
                return start.plusWeeks(1).getDayOfMonth();

        return start.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).plusWeeks(1).getDayOfMonth();
}
}
