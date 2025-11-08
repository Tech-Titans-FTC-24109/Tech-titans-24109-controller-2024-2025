package org.firstinspires.ftc.teamcode.game.decode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;

public class DecodeRobot extends Robot {

    // Hardware

    // - Wheels
    // - IMU
    // - Telemetry

    private final Telemetry telemetry;

    public DecodeRobot(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }
}
