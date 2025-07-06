package org.firstinspires.ftc.teamcode.motions;

/**
 * An enum that can be used to create a {@link PidController} with preset values
 * for kp, ki, and kd
 */
public enum PidControllerParameters {
    TURNING(0.03, 0, 0);

    /**
     * The kp value to be used in the {@link PidController}
     */
    private final double kp;
    /**
     * The ki value to be used in the {@link PidController}
     */
    private final double ki;
    /**
     * The kd value to be used in the {@link PidController}
     */
    private final double kd;

    PidControllerParameters(double kp, double ki, double kd) {
        this.kp = kp;
        this.kd = kd;
        this.ki = ki;
    }

    public double getKp() {
        return kp;
    }

    public double getKi() {
        return ki;
    }

    public double getKd() {
        return kd;
    }
}
