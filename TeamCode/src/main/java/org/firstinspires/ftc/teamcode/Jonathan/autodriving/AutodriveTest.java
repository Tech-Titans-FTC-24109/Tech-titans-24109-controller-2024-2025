package org.firstinspires.ftc.teamcode.Jonathan.autodriving;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class AutodriveTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumWheelsAutoDrive auto = new MecanumWheelsAutoDrive(hardwareMap);
        telemetry.addLine("waiting for start");
        telemetry.update();
        waitForStart();
        telemetry.addLine("starting");
        telemetry.update();
        auto.testPulsesPerCM(62, telemetry);

    }
}
