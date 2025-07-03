package org.firstinspires.ftc.teamcode.motions;


/**
 * The enum that is used to create a {@link PidController} with preset values
 */
public enum PidControllerParameters {
    TURNING(0.03,0);

    private final double kp;
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
