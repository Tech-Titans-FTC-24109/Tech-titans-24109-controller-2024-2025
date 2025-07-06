package org.firstinspires.ftc.teamcode.motions;

import androidx.annotation.NonNull;

public class PidController {

    private final double kp;
    private final double ki;
    private final double kd;

    private double integral;
    private double previousError;

    /**
     * Construct a {@code PidController} instance with the given kp and kd values
     *
     * @param kp The kp value to be used by the controller
     * @param kd The kd value to be used by the controller
     */
    public PidController(double kp, double ki, double kd) {
        this.kp = kp;
        this.kd = kd;
        this.ki = ki;
    }

    /**
     * Construct a {@code PidController} instance from a
     * {@link PidControllerParameters}
     *
     * @param values The given enum to be used to preset the kp and kd values
     */
    public PidController(@NonNull PidControllerParameters values) {
        this.kp = values.getKp();
        this.ki = values.getKi();
        this.kd = values.getKd();
    }

    /**
     * Builder for the {@code PidController} class that follows the builder pattern
     */
    public static class Builder {
        private double kp;
        private double ki;
        private double kd;

        public Builder withKp(double kp) {
            this.kp = kp;
            return this;
        }

        public Builder withKi(double ki) {
            this.ki = ki;
            return this;
        }

        public Builder withKd(double kd) {
            this.kd = kd;
            return this;
        }

        public PidController build() {
            if (kp == 0 && kd == 0 && ki == 0) {
                throw new IllegalStateException("Missing either kp, ki, or kd");
            }
            return new PidController(kp, ki, kd);
        }
    }

    /**
     * Calculate the power with the kp and kd values set in the object
     *
     * @param error the error to be used in the calculation
     * @param dt  the loop interval time to be used in the calculation
     * @return the calculated power with the given error and dt
     */
    public double calculatePower(double error, long dt) {
        double proportional = error;
        integral += error * dt;
        double derivative = (error - previousError) / dt;
        double output = kp * proportional + ki * integral + kd * derivative;
        previousError = error;
        return output;
    }

    public double getKp() {
        return kp;
    }

    public double getKd() {
        return kd;
    }

    public double getKi() {
        return ki;
    }
}
