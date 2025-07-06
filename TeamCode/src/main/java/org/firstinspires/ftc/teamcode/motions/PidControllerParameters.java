package org.firstinspires.ftc.teamcode.motions;

/**
 * An enum that can be used to create a {@link PidController} with preset values
 * for kp and kd
 */
public enum PidControllerParameters {
    TURNING(0.03, 0);

    /**
     * The kp value to be used in the {@link PidController}
     */
    private final double kp;
    /**
     * The kd value to be used in the {@link PidController}
     */
    private final double kd;

    PidControllerParameters(double kp, double kd) {
        this.kp = kp;
        this.kd = kd;
    }

    public double getKp() {
        return kp;
    }

    public double getKd() {
        return kd;
    }
}
