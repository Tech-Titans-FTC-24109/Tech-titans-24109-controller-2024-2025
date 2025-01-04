package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class IntakeTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        IntakeMechanismController intake = new IntakeMechanismController(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad2.left_bumper) {
                intake.applyPower(0.3);
            } else if (gamepad2.right_bumper) {
                intake.applyPower(-0.3);
            } else {
                intake.applyPower(0);
            }
        }
    }
}
