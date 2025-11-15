package org.firstinspires.ftc.teamcode.game.decode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;
import org.firstinspires.ftc.teamcode.actions.IAction;
import org.firstinspires.ftc.teamcode.actions.MotorAction;
import org.firstinspires.ftc.teamcode.actions.TelemetryAction;
import org.firstinspires.ftc.teamcode.actions.TurnAction;
import org.firstinspires.ftc.teamcode.game.decode.DecodeRobot;

import java.util.Arrays;
import java.util.List;

@Autonomous(name = "Match 1", group = "Match Opmodes")
public class Match_1_Opmode extends DecodeOpmode {

    @Override
    protected void createMatch() {
        IMU imu = hardwareMap.get(IMU.class, "imu");
        ImuUtility imuCalculator = new ImuUtility(imu);

        DecodeRobot robot = getRobot();
        // create autonomous actions
//        addAutoAction(new TelemetryAction("Floeppy", robot.getTelemetry()));
//        addAutoAction(new TelemetryAction("Doodle", robot.getTelemetry()));
        addAutoAction(new MotorAction(imuCalculator, new MecanumWheelsController(hardwareMap), telemetry, 100));
        addAutoAction(new TurnAction(imuCalculator, -90, new MecanumWheelsController(hardwareMap), telemetry));
        addAutoAction(new MotorAction(imuCalculator, new MecanumWheelsController(hardwareMap), telemetry, 100));
    }
}
