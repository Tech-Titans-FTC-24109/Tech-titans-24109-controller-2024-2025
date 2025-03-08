package org.firstinspires.ftc.teamcode.Masha;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class WristTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        WristController wrist = new WristController(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.left_bumper) {
                wrist.rotateLeft();
            } else if (gamepad1.right_bumper) {
                wrist.rotateRight();
            }
            if (gamepad1.a) {
                wrist.reset();
            }
        }
    }
}
