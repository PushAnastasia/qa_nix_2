package ua.com.alevel.data;

import ua.com.alevel.service.PlanetImpl;

import java.math.BigDecimal;

public class Mars extends SolarSystem {

    private final CountFromSun countFromSun = CountFromSun.FOURTH;
    private final BigDecimal weight = BigDecimal.valueOf(6.4E23);
    private final BigDecimal diameter = BigDecimal.valueOf(6_794_000);

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
