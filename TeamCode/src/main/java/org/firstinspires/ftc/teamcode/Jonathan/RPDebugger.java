package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class RPDebugger extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RPController rpController = new RPController(hardwareMap);
        waitForStart();
        boolean justPressed = false;
        float power = 0.25F;
        while (opModeIsActive()) {

            if (gamepad1.left_bumper && !justPressed && power > 0.05F) {
                justPressed = true;
                power -= 0.05F;
            } else if (gamepad1.right_bumper && !justPressed && power < 1F) {
                justPressed = true;
                power += 0.05F;
            } else {
                justPressed = false;
            }

            float leftPower;
            if (gamepad1.dpad_up) {
                leftPower = power;
            } else if (gamepad1.dpad_down) {
                leftPower = -power;
            } else {
                leftPower = 0;
            }

            float rightPower;
            if (gamepad1.y) {
                rightPower = power;
            } else if (gamepad1.a) {
                rightPower = -power;
            } else {
                rightPower = 0;
            }

            rpController.individualPower(leftPower,rightPower);
        }
    }
}
