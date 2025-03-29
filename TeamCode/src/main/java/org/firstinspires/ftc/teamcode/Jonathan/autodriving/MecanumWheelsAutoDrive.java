package org.firstinspires.ftc.teamcode.Jonathan.autodriving;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumWheelsAutoDrive {
    public static final double POWER = 0.2;
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    private WheelAssembly mecanumWheelAssembly;

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
        Motor driveMotor = new Motor(40.0, 7);
        mecanumWheelAssembly = new WheelAssembly(mecanumWheel, driveMotor);
        leftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        leftBack = hardwareMap.get(DcMotor.class, "LeftBack");
        rightFront = hardwareMap.get(DcMotor.class, "RightFront");
        rightBack = hardwareMap.get(DcMotor.class, "RightBack");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        resetEncoders();
    }

    /**
     * @param targetDistance is the distance in CM that the robot will, hopefully, run
     */
    public void testPulsesPerCM(double targetDistance, Telemetry telemetry) throws InterruptedException {

        int pulsesToGo = (int) (Math.round(targetDistance * mecanumWheelAssembly.pulsesPerCM()));

        telemetry.addData("ppCM",Math.round( mecanumWheelAssembly.pulsesPerCM()));

        telemetry.addData("pulses to go", pulsesToGo);

        telemetry.addData("leftFront", leftFront.getCurrentPosition());
        telemetry.addData("leftBack", leftBack.getCurrentPosition());
        telemetry.addData("rightFront", rightFront.getCurrentPosition());
        telemetry.addData("rightBack", rightBack.getCurrentPosition());

        telemetry.update();

        Thread.sleep(5000);
        while (
                leftFront.getCurrentPosition() < pulsesToGo &&
                        leftBack.getCurrentPosition() < pulsesToGo &&
                        rightFront.getCurrentPosition() < pulsesToGo &&
                        rightBack.getCurrentPosition() < pulsesToGo
        ) {
            leftFront.setPower(POWER);
            leftBack.setPower(POWER);
            rightFront.setPower(POWER);
            rightBack.setPower(POWER);
        }
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
        resetEncoders();
    }
}
