package ua.com.alevel.data;

import ua.com.alevel.service.PlanetImpl;

import java.math.BigDecimal;

public class Jupiter extends SolarSystem {

    private final CountFromSun countFromSun = CountFromSun.FIFTH;
    private final BigDecimal weight = BigDecimal.valueOf(1.9E27);
    private final BigDecimal diameter = BigDecimal.valueOf(142_984_000);

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
