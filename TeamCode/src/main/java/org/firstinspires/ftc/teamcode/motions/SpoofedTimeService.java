package org.firstinspires.ftc.teamcode.motions;

import java.util.function.DoubleSupplier;

public class SpoofedTimeService implements DoubleSupplier {
    private boolean hasRun = false;
    private final double timeToSpoof;

    public SpoofedTimeService(double timeToSpoof) {
        this.timeToSpoof = timeToSpoof;
    }

    @Override
    public double getAsDouble() {
        if (hasRun) return timeToSpoof;
        else {
            hasRun = true;
            return 0;
        }
    }
}
