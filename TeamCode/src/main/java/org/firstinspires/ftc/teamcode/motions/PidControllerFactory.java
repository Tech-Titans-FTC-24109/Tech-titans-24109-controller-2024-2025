package org.firstinspires.ftc.teamcode.motions;

public class PidControllerFactory {
    public static PidController createWithoutTimeService(double kp, double ki, double kd) {
        return new PidController(kp, ki, kd, new TimeService());
    }

    public static PidController createWithEnumWithoutTimeService(PidControllerParameters parameters) {
        return new PidController(parameters, new TimeService());
    }
}
