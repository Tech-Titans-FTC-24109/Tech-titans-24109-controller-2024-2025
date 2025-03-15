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

        int maxSteps = 4;
        int stepNumber = 1;

        //RIGHT HAND RULE - +90 degrees = left, -90 degrees = right
        double turnAngle;
        double startAngle = 0;
        double targetAngle = 0;

        while (opModeIsActive() && (stepNumber <= maxSteps)) {
            if (stepNumber == 1) {
                turnAngle = 90;// degrees
                startAngle = imuCalculator.getCurrentAngle();
                targetAngle = startAngle + turnAngle;
                stepNumber++;
            } else if (stepNumber == 2) {
                double currentAngle = imuCalculator.getCurrentAngle();
                double remainingAngle = targetAngle - currentAngle;

                if (Math.abs(remainingAngle) < ANGLE_ERROR) {
                    wheels.autoDrive(0, 0, 0, 0);
                    stepNumber++;
                    //reset IMU
                    imuCalculator.reset();
                }
                else {
                    double leftPower = imuCalculator.calculatePower(remainingAngle);
                    double rightPower = leftPower * -1;
                    wheels.autoDrive(leftPower, leftPower, rightPower, rightPower);
                }

                telemetry.addData("current angle!", currentAngle);
                telemetry.addData("remaining angle", remainingAngle);
                telemetry.addData("target. ", targetAngle);
                telemetry.addData("start angle. ", startAngle);
                telemetry.update();
            } else if (stepNumber == 3) {
                stepNumber++;
                sleep(2000);
            } else if (stepNumber == 4) {
                imuCalculator.reset();
                turnAngle = -90;// degrees
                startAngle = imuCalculator.getCurrentAngle();
                targetAngle = startAngle + turnAngle;
                stepNumber++;
            } else if (stepNumber == 5) {
                double currentAngle = imuCalculator.getCurrentAngle();
                double remainingAngle = targetAngle - currentAngle;

                if (Math.abs(remainingAngle) < ANGLE_ERROR) {
                    wheels.autoDrive(0, 0, 0, 0);
                    stepNumber++;
                    //reset IMU
                    imuCalculator.reset();
                }
                else {
                    double leftPower = imuCalculator.calculatePower(remainingAngle);
                    double rightPower = leftPower * -1;
                    wheels.autoDrive(leftPower, leftPower, rightPower, rightPower);
                }

                telemetry.addData("current angle!", currentAngle);
                telemetry.addData("remaining angle", remainingAngle);
                telemetry.addData("target. ", targetAngle);
                telemetry.addData("start angle. ", startAngle);
                telemetry.update();
            }

        }
    }
}