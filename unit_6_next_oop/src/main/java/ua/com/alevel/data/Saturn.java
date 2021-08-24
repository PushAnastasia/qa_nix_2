package ua.com.alevel.data;

import ua.com.alevel.service.PlanetImpl;

import java.math.BigDecimal;

public class Saturn extends SolarSystem {

    private final CountFromSun countFromSun = CountFromSun.SIXTH;
    private final BigDecimal weight = BigDecimal.valueOf(5.7E26);
    private final BigDecimal diameter = BigDecimal.valueOf(120_536_000);

    public CountFromSun getCountFromSun() {
        return countFromSun;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public BigDecimal getAccelerationOfGravity() {
        PlanetImpl impl = new PlanetImpl();
        BigDecimal accelerationOfGravity = impl.accelerationOfGravity(this.getWeight(), this.getDiameter());
        return accelerationOfGravity;
    }
}
