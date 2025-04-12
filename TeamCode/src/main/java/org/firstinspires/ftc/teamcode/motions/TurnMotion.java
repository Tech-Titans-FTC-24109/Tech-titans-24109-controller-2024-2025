package org.firstinspires.ftc.teamcode.motions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

public class TurnMotion extends AbstractMotion {

    public static final double ANGLE_ERROR = 2; // degrees

    private final MecanumWheelsController wheels;
    private final ImuUtility imuCalculator;
    private final double turnAngle;
    private double targetAngle;
    private final Telemetry telemetry;

    public TurnMotion(ImuUtility imuUtility, double turnAngle,
                      MecanumWheelsController wheels, Telemetry telemetry) {
        super();
        this.imuCalculator = imuUtility;
        this.turnAngle = turnAngle;
        this.targetAngle = 0;
        this.wheels = wheels;
        this.telemetry = telemetry;
    }

    @Override
    protected void initMotion() {
        imuCalculator.reset();
        targetAngle = imuCalculator.getCurrentAngle() + turnAngle;
    }

    @Override
    protected boolean performMove() {
        double currentAngle = imuCalculator.getCurrentAngle();
        double remainingAngle = targetAngle - currentAngle;

        if (Math.abs(remainingAngle) < ANGLE_ERROR) {
            wheels.autoDrive(0, 0, 0, 0);
            return true;
        }
        else {
            double leftPower = imuCalculator.calculatePower(remainingAngle);
            double rightPower = leftPower * -1;
            wheels.autoDrive(leftPower, leftPower, rightPower, rightPower);

            telemetry.addData("current angle!", currentAngle);
            telemetry.addData("remaining angle", remainingAngle);
            telemetry.addData("target. ", targetAngle);
            telemetry.update();

            return false;
        }
    }
}
