package org.firstinspires.ftc.teamcode.Paarth;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Jonathan.ArmController;
import org.firstinspires.ftc.teamcode.Jonathan.ClawController;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;
import org.firstinspires.ftc.teamcode.Jonathan.RPController;

import java.util.function.BooleanSupplier;

//@Disabled
@Autonomous
public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
        ArmController arm = new ArmController(hardwareMap);
        ClawController claw = new ClawController(hardwareMap);
        RPController rP = new RPController(hardwareMap);
        BooleanSupplier stopCondition = () -> opModeIsActive();
        arm.setPitch(271, stopCondition);
        waitForStart();
        rP.changeRP(1);
        sleep(500);
        rP.changeRP(0);
        wheels.applyPower(0.5F,0.5F,0); //move to basket
        sleep(500);
        wheels.applyPower(0,0,0);
        arm.setPitch(700, stopCondition); //pitch up
        arm.setExtension(2600, stopCondition); //extend out
        claw.openClaw(); //dispense sample
        //done phase 1



        terminateOpModeNow();
    }
}
