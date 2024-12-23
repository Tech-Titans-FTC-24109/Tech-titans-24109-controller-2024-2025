package org.firstinspires.ftc.teamcode.Paarth;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Jonathan.ArmController;
import org.firstinspires.ftc.teamcode.Jonathan.ClawController;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

//@Disabled
@Autonomous

public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        ClawController claw = new ClawController(hardwareMap);
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
        ArmController arm = new ArmController(hardwareMap);
        waitForStart();
        claw.closeClaw();
        sleep(500);
        arm.setPitch(650);
        sleep(500);
        arm.setExtension(9200);
        sleep(500);
        wheels.applyPower(0.2F,0,0);
        sleep(100);
        wheels.applyPower(0,0,0);
        claw.openClaw();
        sleep(500);
        arm.setExtension(0);
        sleep(500);
        //arm.setPitch(0);
        //sleep(2000);

        terminateOpModeNow();
    }
}
