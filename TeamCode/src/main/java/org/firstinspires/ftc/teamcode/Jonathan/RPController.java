package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RPController {
    private static final float motorPower = 1;
    private DcMotor rPRight;
    private DcMotor rPLeft;

    public RPController(HardwareMap hardwareMap) {
        rPLeft = hardwareMap.get(DcMotor.class, "RPleft");
        rPRight = hardwareMap.get(DcMotor.class, "RPright");

        rPLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        rPRight.setDirection(DcMotorSimple.Direction.REVERSE);

        rPLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rPRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rPLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rPRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rPLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rPRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void changeRP(float power) {
        rPRight.setPower(power);
        rPLeft.setPower(power);
    }

    public void individualPower(float leftMotorPower, float rightMotorPower) {
        rPRight.setPower(rightMotorPower);
        rPLeft.setPower(leftMotorPower);
    }

    public int getRPRightPosition() {
        return rPRight.getCurrentPosition();
    }

    public int getRPLeftPosition() {
        return rPLeft.getCurrentPosition();
    }
}