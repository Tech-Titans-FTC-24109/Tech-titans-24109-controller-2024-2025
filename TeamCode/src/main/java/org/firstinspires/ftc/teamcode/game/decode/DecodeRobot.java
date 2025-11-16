package org.firstinspires.ftc.teamcode.game.decode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.component.Imu;

public class DecodeRobot extends Robot {

    // Hardware

    // - Wheels
    // - IMU
    // - Telemetry

    private final Telemetry telemetry;
    private final Imu imu;

    public DecodeRobot(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.imu = new Imu(hwMap.get(IMU.class, "imu"));
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public IMU getImu() {
        return imu.createProxy();
    }


}
