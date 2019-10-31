package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.rules.DiscountAtMidnight;
import kata.ex01.rules.DiscountInMorningOrEvening;
import kata.ex01.rules.DisountOnHolidays;
import kata.ex01.util.HolidayUtils;

import java.time.*;
import java.util.*;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    List<DiscountRule> discountRules;

    public DiscountServiceImpl() {
        discountRules = Arrays.asList(
                new DiscountInMorningOrEvening(),
                new DiscountAtMidnight(),
                new DisountOnHolidays()
        );
    }

    @Override
    public long calc(HighwayDrive drive) {
        return discountRules.stream()
                .filter(rule -> rule.isApplicable(drive))
                .map(rule -> rule.discountPercentage(drive))
                .max(Comparator.naturalOrder())
                .orElse(0L);
    }
}
