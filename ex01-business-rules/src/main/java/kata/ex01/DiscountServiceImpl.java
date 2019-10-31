package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public long calc(HighwayDrive drive) {

        // 深夜判定
        if (drive.isMidnightDrive()) {
            return 30;
        }

        // 平日休日判定
        if (HolidayUtils.isHoliday(drive.getEnteredAt().toLocalDate()) || HolidayUtils.isHoliday(drive.getExitedAt().toLocalDate())) {
            if(drive.isRuralDrive() && drive.getVehicleFamily() != VehicleFamily.OTHER) {
                return 30;
            }
        } else if ((drive.isMorningDrive() || drive.isEveningDrive()) && drive.isRuralDrive()) {
            if (drive.getDriver().getCountPerMonth() >= 5 && drive.getDriver().getCountPerMonth() <= 9) {
                return 30;
            } else if (drive.getDriver().getCountPerMonth() >= 10) {
                return 50;
            } else {
                return 0;
            }
        }

        // 割引なし
        return 0;
    }






}
