package org.firstinspires.ftc.teamcode.motions;

import androidx.annotation.NonNull;

public class PidController {

    private final double kp;
    private final double kd;

    /**
     * Construct a {@code PidController} instance with the given kp and kd values
     *
     * @param kp The kp value to be used by the controller
     * @param kd The kd value to be used by the controller
     */
    public PidController(double kp, double kd) {
        this.kp = kp;
        this.kd = kd;
    }

    /**
     * Construct a {@code PidController} instance from a
     * {@link PidControllerParameters}
     *
     * @param values The given enum to be used to preset the kp and kd values
     */
    public PidController(@NonNull PidControllerParameters values) {
        this.kp = values.getKp();
        this.kd = values.getKd();
    }

    /**
     * Builder for the {@code PidController} class that follows the builder pattern
     */
    public static class Builder {
        private double kp;
        private double kd;

        public Builder withKp(double kp) {
            this.kp = kp;
            return this;
        }

        public Builder withKd(double kd) {
            this.kd = kd;
            return this;
        }

        public PidController build() {
            if (kp == 0 && kd == 0) {
                throw new IllegalStateException("Missing either kp or kd");
            }
            return new PidController(kp, kd);
        }
    }

    /**
     * Calculate the power with the kp and kd values set in the object
     *
     * @param error the error to be used in the calculation
     * @param time  the time difference to be used in the calculation
     * @return the calculated power with the given error and time
     */
    public double calculatePower(double error, long time) {
        // TODO: use kd
        return kp * error + kd * 0;
    }

    public double getKp() {
        return kp;
    }

    public double getKd() {
        return kd;
    }
}
