package org.firstinspires.ftc.teamcode.game.decode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.component.Imu;
import org.firstinspires.ftc.teamcode.robot.component.YawMeter;

public class DecodeRobot extends Robot {

    // Hardware constants

    public final static AngleUnit ANGLE_UNIT = AngleUnit.DEGREES;

    // - Wheels

    // - IMU
    IMU.Parameters IMU_PARAMS = new IMU.Parameters(
            new RevHubOrientationOnRobot(
                    RevHubOrientationOnRobot.LogoFacingDirection.UP,
                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));

    private final Telemetry telemetry;
    private final Imu imu;

    public DecodeRobot(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        this.imu = new Imu(hwMap.get(IMU.class, "imu"));
        this.imu.initialize(IMU_PARAMS);
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public IMU getImu() {
        return imu.createProxy();
    }

    public YawMeter getYawMeter() {
        return new YawMeter(getImu(), ANGLE_UNIT);
    }
}
