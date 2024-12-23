package org.firstinspires.ftc.teamcode.Jonathan;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeMechanismController {
    private CRServo leftServo;
    private CRServo rightServo;

    public IntakeMechanismController(@NonNull HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");

        leftServo.setDirection(DcMotorSimple.Direction.FORWARD);
        rightServo.setDirection(DcMotorSimple.Direction.REVERSE);

        leftServo.setPower(0);
        rightServo.setPower(0);
    }

    public void applyPower(double power) {
        leftServo.setPower(power);
        rightServo.setPower(power);
    }


}
