package org.firstinspires.ftc.teamcode.game.decode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;
import org.firstinspires.ftc.teamcode.actions.MotorAction;
import org.firstinspires.ftc.teamcode.actions.TelemetryAction;
import org.firstinspires.ftc.teamcode.actions.TurnAction;

@Autonomous(name = "Auto test Match 2", group = "Match Opmodes")
public class AutoTest_2_OpMode extends DecodeOpmode {

    @Override
    protected void createMatch() {
        IMU imu = hardwareMap.get(IMU.class, "imu");
        ImuUtility imuCalculator = new ImuUtility(imu);

        addAutoAction(new MotorAction(imuCalculator, new MecanumWheelsController(hardwareMap), telemetry, 106.5));
        addAutoAction(new TurnAction(imuCalculator, 45, new MecanumWheelsController(hardwareMap), telemetry));
        addAutoAction(new MotorAction(imuCalculator, new MecanumWheelsController(hardwareMap), telemetry, 10));
        addAutoAction(new TelemetryAction("I'm shooting", telemetry));
    }
}
