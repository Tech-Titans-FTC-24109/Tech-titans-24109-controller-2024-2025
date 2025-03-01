package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

@Autonomous(name="myTest")
//@Disabled
public class ImuTest extends LinearOpMode {

    public static final double ANGLE_ERROR = 5; // degrees

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

        double turnAngle = 90;// degrees
        double startAngle = imuCalculator.getCurrentAngle();
        double targetAngle = startAngle + turnAngle;

        while (opModeIsActive()) {
            double currentAngle = imuCalculator.getCurrentAngle();
            double remainingAngle = targetAngle - currentAngle;
            if (Math.abs(remainingAngle) < ANGLE_ERROR) {
                wheels.autoDrive(0, 0, 0, 0);
                terminateOpModeNow();
            }

            double leftPower = imuCalculator.calculatePower(remainingAngle);
            double rightPower = leftPower * -1;
            wheels.autoDrive(leftPower, leftPower, rightPower, rightPower);
        }
    }
}