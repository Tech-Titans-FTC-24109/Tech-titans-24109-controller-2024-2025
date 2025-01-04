package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Driver control", group = "Driver control")
public class RobotController extends LinearOpMode {
    private boolean raisedArm = false;

    private static final int START_PITCH = 375; //public --> auto?

    @Override
    public void runOpMode() throws InterruptedException {
        IntakeMechanismController intake = new IntakeMechanismController(hardwareMap);
        MecanumWheelsController wheels = new MecanumWheelsController(hardwareMap);
        ArmController arm = new ArmController(hardwareMap);
        RPController rP = new RPController(hardwareMap);
        arm.setPitch(START_PITCH);
        waitForStart();
        while (opModeIsActive()) {
            twoDrivers(intake, wheels, arm, rP);
        }
    }

    private void twoDrivers(IntakeMechanismController intake, MecanumWheelsController wheels, ArmController arm, RPController rP) {
        double servoState;

        if (gamepad2.left_bumper) {
            intake.applyPower(1);
        } else if (gamepad2.right_bumper) {
            intake.applyPower(-1);
        } else {
            intake.applyPower(0);
        }

        if (gamepad2.dpad_up) {
            rP.changeRP(1);
        } else if (gamepad2.dpad_down) {
            rP.changeRP(-1);
        } else {
            rP.changeRP(0);
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

        float armFineControlValue;
        if (gamepad2.right_trigger > 0 && gamepad2.left_trigger > 0) {
            armFineControlValue = 0.25F;
        } else if (gamepad2.right_trigger > 0) {
            armFineControlValue = 0.5F;
        } else if (gamepad2.left_trigger > 0) {
            armFineControlValue = 0.75F;
        } else {
            armFineControlValue = 1;
        }
//        arm.pitchPower(Math.round(gamepad2.left_stick_y * 50));
//        arm.rawExtensionPower(gamepad2.right_stick_y * 150);

            arm.changePitch(Math.round(gamepad2.left_stick_y * (160 * armFineControlValue)));
//            telemetry.addData("Gpad2, LY", Math.round(gamepad2.left_stick_y * 200));


        arm.rawExtensionPower(gamepad2.right_stick_y * armFineControlValue);
//            telemetry.addData("Gpad2, RY", Math.round(gamepad2.right_stick_y * 200));
            telemetry.update();

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

        telemetry.update();

    }
}
