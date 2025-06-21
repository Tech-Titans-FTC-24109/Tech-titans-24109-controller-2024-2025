package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class ImuUtility {

    private final IMU imu;

    public ImuUtility(IMU imu) {
        this.imu = imu;
        imu.resetYaw();
        imu.initialize(
            new IMU.Parameters(
                new RevHubOrientationOnRobot(
                    RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
            )
        );
    }

    public double getCurrentAngle(){
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        return orientation.getYaw(AngleUnit.DEGREES);
    }

    public void reset() {
        imu.resetYaw();
    }
}