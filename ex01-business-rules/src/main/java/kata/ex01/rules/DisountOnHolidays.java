package kata.ex01.rules;

import kata.ex01.DiscountRule;
import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

import java.util.EnumSet;

public class DisountOnHolidays implements DiscountRule {

    private static EnumSet<VehicleFamily> targetVehicleFamilies = EnumSet.of(VehicleFamily.STANDARD, VehicleFamily.MOTORCYCLE, VehicleFamily.MINI);

    @Override
    public boolean isApplicable(HighwayDrive drive) {
        boolean isHoliday = HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) || HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate());
        return isHoliday && drive.getRouteType() == RouteType.RURAL && targetVehicleFamilies.contains(drive.getVehicleFamily());
    }

    @Override
    public long discountPercentage(HighwayDrive drive) {
        return 30;
    }
}
