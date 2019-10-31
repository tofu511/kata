package kata.ex01.model;

import java.io.Serializable;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author kawasima
 */
public class HighwayDrive implements Serializable {
    private LocalDateTime enteredAt;
    private LocalDateTime exitedAt;
    private VehicleFamily vehicleFamily;
    private RouteType routeType;

    private Driver driver;

    public HighwayDrive() {
    }

    public LocalDateTime getEnteredAt() {
        return this.enteredAt;
    }

    public LocalDateTime getExitedAt() {
        return this.exitedAt;
    }

    public VehicleFamily getVehicleFamily() {
        return this.vehicleFamily;
    }

    public RouteType getRouteType() {
        return this.routeType;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setEnteredAt(LocalDateTime enteredAt) {
        this.enteredAt = enteredAt;
    }

    public void setExitedAt(LocalDateTime exitedAt) {
        this.exitedAt = exitedAt;
    }

    public void setVehicleFamily(VehicleFamily vehicleFamily) {
        this.vehicleFamily = vehicleFamily;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String toString() {
        return "HighwayDrive(enteredAt=" + this.getEnteredAt() + ", exitedAt=" + this.getExitedAt() + ", vehicleFamily=" + this.getVehicleFamily() + ", routeType=" + this.getRouteType() + ", driver=" + this.getDriver() + ")";
    }

    public boolean isMorningDrive() {
        if (enteredAt.getDayOfMonth() != exitedAt.getDayOfMonth()) {
            return this.enteredAt.getHour() <= AM_NINE.getHour() || this.exitedAt.getHour() >= AM_SIX.getHour();
        }
        return this.enteredAt.getHour() <= AM_NINE.getHour() && this.exitedAt.getHour() >= AM_SIX.getHour();
    }

    public boolean isEveningDrive() {
        if (enteredAt.getDayOfMonth() != exitedAt.getDayOfMonth()) {
            return this.enteredAt.getHour() <= PM_EIGHT.getHour() || this.exitedAt.getHour() >= PM_FIVE.getHour();
        }
        return this.enteredAt.getHour() <= PM_EIGHT.getHour() && this.exitedAt.getHour() >= PM_FIVE.getHour();
    }

    public boolean isMidnightDrive() {
        return this.enteredAt.getHour() <= AM_FOUR.getHour() && this.exitedAt.getHour() >= AM_ZERO.getHour();
    }

    public boolean isRuralDrive() {
        return this.getRouteType() == RouteType.RURAL;
    }

    // TODO enum?
    private static final LocalTime AM_ZERO = LocalTime.of(0, 0);
    private static final LocalTime AM_FOUR = LocalTime.of(4, 0);
    private static final LocalTime AM_SIX = LocalTime.of(6, 0);
    private static final LocalTime AM_NINE = LocalTime.of(9, 0);
    private static final LocalTime PM_FIVE = LocalTime.of(17, 0);
    private static final LocalTime PM_EIGHT = LocalTime.of(20, 0);
}
