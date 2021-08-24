package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.MathContext;

public class PlanetImpl implements Planet {

    private final BigDecimal GRAVITATIONALCONSTANT = BigDecimal.valueOf(6.67E-11);

    @Override
    public BigDecimal accelerationOfGravity(BigDecimal weight, BigDecimal diameter) {
        BigDecimal radius = diameter.divide(BigDecimal.valueOf(2));
        MathContext mc = new MathContext(5);
        BigDecimal accelerationOfGravity = GRAVITATIONALCONSTANT.multiply(weight.divide(radius.pow(2), mc));
        return accelerationOfGravity;
    }
}
