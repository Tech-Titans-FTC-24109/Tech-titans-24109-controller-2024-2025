package org.firstinspires.ftc.teamcode.motions;

public class PidController {

    private final double kp;
    private final double kd;

    public PidController(double kp, double kd) {
        this.kp = kp;
        this.kd = kd;
    }

    public double calculatePower(double error, long time) {
        // TODO: use kd
        return kp * error + kd * 0;

    }
}