package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.function.BooleanSupplier;

@TeleOp(name = "Driver control", group = "Driver control")
public class RobotController extends LinearOpMode {
    private boolean raisedArm = false;

    private static final int START_PITCH = 271; //public --> auto?

    private boolean inFineControls = false;

    @Override
    public void runOpMode() throws InterruptedException {
        ClawController claw = new ClawController(hardwareMap);
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
        ArmController arm = new ArmController(hardwareMap);
        RPController rP = new RPController(hardwareMap);
        BooleanSupplier stopCondition = () -> opModeIsActive();
        arm.setPitch(START_PITCH, stopCondition);
        waitForStart();
        while (opModeIsActive()) {
            twoDrivers(claw, wheels, arm, rP);
        }
    }

    private void twoDrivers(ClawController claw, MecanumWheelsController wheels, ArmController arm, RPController rP) {
        double servoState;

        if (gamepad2.left_bumper) {
            claw.closeClaw();
        } else if (gamepad2.right_bumper) {
            claw.openClaw();
        }


        //How to use fine control:
        //dpad left to turn on, dpad right to turn off
        //same controls as RPDebugger
        if (gamepad2.dpad_left) {
            inFineControls = true;
        } else if (gamepad2.dpad_right) {
            inFineControls = false;
        }

        if (inFineControls) {
            float leftPower;
            if (gamepad2.dpad_up) {
                leftPower = 0.25F;
            } else if (gamepad2.dpad_down) {
                leftPower = -0.25F;
            } else {
                leftPower = 0;
            }

            float rightPower;
            if (gamepad2.y) {
                rightPower = 0.25F;
            } else if (gamepad2.a) {
                rightPower = -0.25F;
            } else {
                rightPower = 0;
            }

            rP.individualPower(leftPower,rightPower);
        } else {
            if (gamepad2.dpad_up) {
                rP.changeRP(1);
            } else if (gamepad2.dpad_down) {
                rP.changeRP(-1);
            } else {
                rP.changeRP(0);
            }
        }




        float wheelsFineControlValue;
        if (gamepad2.right_trigger > 0 && gamepad2.left_trigger > 0) {
            wheelsFineControlValue = 0.25F;
        } else if (gamepad2.right_trigger > 0) {
            wheelsFineControlValue = 0.5F;
        } else if (gamepad2.left_trigger > 0) {
            wheelsFineControlValue = 0.75F;
        } else {
            wheelsFineControlValue = 1;
        }
        wheels.applyPower(gamepad1.left_stick_x * wheelsFineControlValue, gamepad1.left_stick_y * wheelsFineControlValue, gamepad1.right_stick_x * wheelsFineControlValue);

        float extensionFineControlValue;
        if (gamepad2.right_trigger > 0 && gamepad2.left_trigger > 0) {
            extensionFineControlValue = 0.25F;
        } else if (gamepad2.right_trigger > 0) {
            extensionFineControlValue = 0.5F;
        } else if (gamepad2.left_trigger > 0) {
            extensionFineControlValue = 0.75F;
        } else {
            extensionFineControlValue = 1;
        }
        arm.rawExtensionPower(gamepad2.right_stick_y * extensionFineControlValue);

        float pitchFineControlValue;
        if (gamepad2.right_trigger > 0 && gamepad2.left_trigger > 0) {
            pitchFineControlValue = 10;
        } else if (gamepad2.right_trigger > 0) {
            pitchFineControlValue = 35;
        } else if (gamepad2.left_trigger > 0) {
            pitchFineControlValue = 50;
        } else {
            pitchFineControlValue = 25;
        }

        arm.changePitch(Math.round(gamepad2.left_stick_y * pitchFineControlValue));

//            telemetry.addData("Gpad2, RY", Math.round(gamepad2.right_stick_y * 200));
        telemetry.update();
//        arm.pitchPower(Math.round(gamepad2.left_stick_y * 50));
//        arm.rawExtensionPower(gamepad2.right_stick_y * 150);


//            telemetry.addData("Gpad2, LY", Math.round(gamepad2.left_stick_y * 200));




//        if (gamepad2.a) {
//            raisedArm=true;
//            arm.setPitch(600); //-1000
//            arm.setExtension(7500); //-8870
//        }
//        if (gamepad2.b) {
//            arm.setExtension(0);
//            arm.setPitch(75);
//            raisedArm=false;
//        }


        telemetry.addData("Pitch position", arm.getPitchPosition());
        telemetry.addData("Extension position", arm.getExtensionPosition());

        telemetry.addData("lY", Math.round(gamepad2.left_stick_y * 50));
        telemetry.addData("rY", gamepad2.right_stick_y);
        telemetry.addData("max", arm.getMaxExtension(arm.getPitchPosition()));

        telemetry.addData("rPLeft", rP.getRPLeftPosition());
        telemetry.addData("rPRight", rP.getRPRightPosition());

        telemetry.addData("inFineControls", inFineControls);

        telemetry.update();

    }
}
