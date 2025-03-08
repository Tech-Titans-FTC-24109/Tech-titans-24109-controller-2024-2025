package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

@Autonomous(name="myTest")
//@Disabled
public class ImuTest extends LinearOpMode {

    public static final double ANGLE_ERROR = 2; // degrees

    public IMU imu;

    private ImuUtility imuCalculator;

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
        imu = hardwareMap.get(IMU.class, "imu");
        imuCalculator = new ImuUtility(imu);


        while (!isStarted()) {

        }
        waitForStart();

        int maxSteps = 1;
        int stepNumber = 1;
        double turnAngle = 190;// degrees
        double startAngle = imuCalculator.getCurrentAngle();
        double targetAngle = startAngle + turnAngle;

        while (opModeIsActive() && (stepNumber <= maxSteps)) {
            if (stepNumber == 1) {
                double currentAngle = imuCalculator.getCurrentAngle();
                double remainingAngle = targetAngle - currentAngle;
                if (Math.abs(remainingAngle) < ANGLE_ERROR) {
                    wheels.autoDrive(0, 0, 0, 0);
                    telemetry.addLine("yes i am in the loop");
                    telemetry.update();
                    stepNumber++;
                }

                double rightPower = imuCalculator.calculatePower(remainingAngle);
                double leftPower = rightPower * -1;
                wheels.autoDrive(leftPower, leftPower, rightPower, rightPower);

                telemetry.addData("current angle", currentAngle);
                telemetry.addData("remaining angle", remainingAngle);
                telemetry.addData("target. ", targetAngle);
                telemetry.addData("start angle. ", startAngle);
                telemetry.update();
            }
        }
    }
}