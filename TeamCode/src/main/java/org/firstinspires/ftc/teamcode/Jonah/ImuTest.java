package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

import java.security.KeyPairGenerator;

@Autonomous(name="myTest")
//@Disabled
public class ImuTest extends LinearOpMode {
    public IMU imu;

    @Override
    public void runOpMode() throws InterruptedException {
        imu = hardwareMap.get(IMU.class, "imu");
        imu.resetYaw();

        while (!isStarted()) {

            IMU.Parameters myIMUparameters;

            // Initialize IMU directly

            imu.initialize(
                    new IMU.Parameters(
                            new RevHubOrientationOnRobot(
                                    RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                            )
                    )
            );

            YawPitchRollAngles orientation;
            orientation = imu.getRobotYawPitchRollAngles();

            double Yaw = orientation.getYaw(AngleUnit.DEGREES);
            double Pitch = orientation.getPitch(AngleUnit.DEGREES);
            double Roll = orientation.getRoll(AngleUnit.DEGREES);

            telemetry.addData("Yaw (IMU)", Yaw);
            telemetry.addData("Pitch (IMU)", Pitch);
            telemetry.addData("Roll (IMU)", Roll);
            telemetry.update();


        }
        waitForStart();
        while (opModeIsActive()) {


        }
    }
    public void turnAngle(int angle) {
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
        double powerLeft;
        double powerRight;
        if (angle > 0){
            powerLeft  = -0.2;
            powerRight = 0.2;
        }
        else {
            powerLeft  = 0.2;
            powerRight = -0.2;
        }
        // while imu yaw <(if target is positive) or >(if target is negative) target angle keep driving
        wheels.autoDrive(powerLeft, powerLeft, powerRight, powerRight);
        //when done, stop motors

    }
}