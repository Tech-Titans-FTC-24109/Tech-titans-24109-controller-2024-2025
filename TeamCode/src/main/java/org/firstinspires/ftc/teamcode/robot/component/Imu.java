package org.firstinspires.ftc.teamcode.robot.component;

import com.qualcomm.robotcore.hardware.IMU;

public class Imu {
    private IMU imu;

    public Imu(IMU imu) {
        this.imu = imu;
    }

    public IMU createProxy() {
        // TODO create a real proxy
        return imu;
    }
}
