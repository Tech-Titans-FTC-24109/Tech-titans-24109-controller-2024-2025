package org.firstinspires.ftc.teamcode.robot.component;

import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class YawMeter {

    private final IMU imu;
    private final AngleUnit angleUnit;

    public YawMeter(IMU imu, AngleUnit angleUnit) {
        this.imu = imu;
        this.angleUnit = angleUnit;
    }

    public double getYaw(){
        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        return orientation.getYaw(this.angleUnit);
    }

    public void reset() {
        imu.resetYaw();
    }

}
