package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;
import org.firstinspires.ftc.teamcode.motions.TurnMotion;

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

        TurnMotion turnLeft = new TurnMotion(imuCalculator, 90.0, wheels, telemetry);
        TurnMotion turnRight = new TurnMotion(imuCalculator, -90.0, wheels, telemetry);
//        while (!isStarted()) {
//
//        }
        waitForStart();

        int maxSteps = 3;
        int stepNumber = 1;

        //RIGHT HAND RULE - +90 degrees = left, -90 degrees = right
        double turnAngle;
        double startAngle = 0;
        double targetAngle = 0;

        while (opModeIsActive() && (stepNumber <= maxSteps)) {
            if (stepNumber == 1) {

                if (!turnLeft.isInitialized()) {
                    turnLeft.init();
                }
                if (turnLeft.move()) {
                    stepNumber++;
                }
            } else if (stepNumber == 2) {
                stepNumber++;
                sleep(2000);
            } else if (stepNumber == 3) {
                if (!turnRight.isInitialized()) {
                    turnRight.init();
                }
                if (turnRight.move()) {
                    stepNumber++;
                }
            }
        }
    }
}