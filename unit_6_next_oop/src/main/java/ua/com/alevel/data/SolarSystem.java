package ua.com.alevel.data;

import java.math.BigDecimal;

public abstract class SolarSystem {

    private CountFromSun countFromSun;

    public CountFromSun getCountFromSun() {
        return countFromSun;
    }

    public abstract BigDecimal getAccelerationOfGravity();
}
