package org.firstinspires.ftc.teamcode.Jonathan.autodriving;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumWheelsAutoDrive {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    private void resetEncoders() {
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public MecanumWheelsAutoDrive(HardwareMap hardwareMap) {
        Wheel mecanumWheel = new Wheel(10.0);
        Motor driveMotor = new Motor(1.0 / 40.0, 7);
        WheelAssembly mecanumWheelAssembly = new WheelAssembly(mecanumWheel, driveMotor);
        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");

        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        resetEncoders();
    }

    public void testPulsesPerCM(double targetDistance, WheelAssembly wheelAssembly) {
        int pulsesToGo = (int) (targetDistance * wheelAssembly.pulsesPerCM());
        while (
                leftFront.getCurrentPosition() < pulsesToGo &&
                        leftBack.getCurrentPosition() < pulsesToGo &&
                        rightFront.getCurrentPosition() < pulsesToGo &&
                        rightBack.getCurrentPosition() < pulsesToGo
        ) {
            leftFront.setPower(0.5);
            leftBack.setPower(0.5);
            rightFront.setPower(0.5);
            rightBack.setPower(0.5);
        }
        resetEncoders();
    }
}
