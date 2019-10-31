package kata.ex01;

import kata.ex01.model.HighwayDrive;

public interface DiscountRule {
    boolean isApplicable(HighwayDrive drive);
    long discountPercentage(HighwayDrive drive);
}
