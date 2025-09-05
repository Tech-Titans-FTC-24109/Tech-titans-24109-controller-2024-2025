package org.firstinspires.ftc.teamcode.motions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

public class MoveMotion extends AbstractMotion {

    public static final double MOVEMENT_ERROR = 2;

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
        wheels.runWithEncoders();
    }

    @Override
    protected boolean performMove() {
        boolean isComplete;
        double currentDistance = wheels.getDistance();
        double remainingDistance = targetDistance - currentDistance;

        if (Math.abs(remainingDistance) < MOVEMENT_ERROR) {
            wheels.autoDrive(0, 0, 0, 0);
            telemetry.addLine("stopped");
            isComplete = true;
        }
        else {
            //implement PID in this :D
            //powers must be negative to move forward
//            double powerValue = pidController.calculatePower(remainingDistance);
            wheels.autoDrive(-0.75, -0.75, -0.75, -0.75);
            telemetry.addData("current distance", currentDistance);
            telemetry.addData("remaining distance", remainingDistance);
            isComplete = false;
        }
        telemetry.update();
        return isComplete;
    }

    @Override
    public String toString() {
        return "MoveMotion{" +
                "targetDistance=" + targetDistance +
                '}';
    }
}