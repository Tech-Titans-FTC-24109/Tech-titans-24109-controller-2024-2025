package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RPController {
    private static final float motorPower = 1;
    private DcMotor RPRight;
    private DcMotor RPLeft;

    public RPController(HardwareMap hardwareMap) {
        RPLeft = hardwareMap.get(DcMotor.class, "RPleft");
        RPRight = hardwareMap.get(DcMotor.class, "RPright");

        RPLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        RPRight.setDirection(DcMotorSimple.Direction.REVERSE);

        RPLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RPRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RPLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RPRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        RPLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RPRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void changeRP(float power) {
        RPRight.setPower(power);
        RPLeft.setPower(power);
    }
}