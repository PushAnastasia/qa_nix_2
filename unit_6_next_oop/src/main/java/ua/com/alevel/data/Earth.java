package ua.com.alevel.data;

import ua.com.alevel.service.PlanetImpl;

import java.math.BigDecimal;

public class Earth extends SolarSystem {

    private final CountFromSun countFromSun = CountFromSun.THIRD;
    private final BigDecimal weight = BigDecimal.valueOf(5.97E24);
    private final BigDecimal diameter = BigDecimal.valueOf(12_742_000);

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
