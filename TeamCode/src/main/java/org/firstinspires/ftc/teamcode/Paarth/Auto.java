package org.firstinspires.ftc.teamcode.Paarth;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Jonathan.ArmController;
import org.firstinspires.ftc.teamcode.Jonathan.IntakeMechanismController;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;
import org.firstinspires.ftc.teamcode.Jonathan.RPController;

//@Disabled
@Autonomous

public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RPController rP = new RPController(hardwareMap);
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
         ArmController arm = new ArmController(hardwareMap);
        IntakeMechanismController intake = new IntakeMechanismController(hardwareMap);
        arm.setPitch(375);
        waitForStart();
        arm.setPitch(700);
        arm.setExtension(2600);
        intake.applyPower(-1);
        sleep(300);


        terminateOpModeNow();
    }
}
