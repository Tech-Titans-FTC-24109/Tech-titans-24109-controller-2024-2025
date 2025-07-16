package org.firstinspires.ftc.teamcode.motions;

import java.util.function.DoubleSupplier;

public class NormalTimeService implements DoubleSupplier {
    private long previousTime = 0;

    @Override
    public double getAsDouble() {
        long time = System.currentTimeMillis();
        if (previousTime == 0) {
            previousTime = time;
        }
        long calculatedTime = time-previousTime;
        previousTime = time;
        return calculatedTime;
    }
}
