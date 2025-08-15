package org.firstinspires.ftc.teamcode.motions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

public class MoveMotion extends AbstractMotion{

    private final MecanumWheelsController wheels;
    private final Telemetry telemetry;
    private final double targetDistance;
    private final PidController pidController;

    public MoveMotion(ImuUtility imuUtility, MecanumWheelsController wheels, Telemetry telemetry, double distance) {

        super();
        this.wheels = wheels;
        this.telemetry = telemetry;
        this.targetDistance = distance;
        this.pidController = new PidController(0.03, 0, 0, new TimeService());
    }

    @Override
    protected void initMotion() {
        wheels.resetEncoders();
    }

    @Override
    protected boolean performMove() {
        double currentDist =
        return false;
    }


}