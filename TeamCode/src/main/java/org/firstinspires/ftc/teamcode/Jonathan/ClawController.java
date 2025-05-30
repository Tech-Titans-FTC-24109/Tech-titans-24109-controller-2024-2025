package org.firstinspires.ftc.teamcode.Jonathan;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private static final double servoOpen = 0.85;
    private static final double servoClosed = 0.2;
    
    private Servo claw;
    private Servo wrist;

    public ClawController(@NonNull HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "Claw");
        claw.setDirection(Servo.Direction.FORWARD);
        claw.setPosition(servoClosed);

        wrist = hardwareMap.get(Servo.class, "Wrist");
        wrist.setDirection(Servo.Direction.FORWARD);
        wrist.setPosition(0.0);
    }

    public void closeClaw() {
        claw.setPosition(servoClosed);
    }

    public void openClaw() {
        claw.setPosition(servoOpen);
    }

    public double getClawPosition() {
        return claw.getPosition();
    }

    public void toggleClaw() {
        if (claw.getPosition() == servoClosed) {
            claw.setPosition(servoOpen);
        } else {
            claw.setPosition(servoClosed);
        }
    }

    public void turnWrist(double valueToSetTo) {
        wrist.setPosition(valueToSetTo);
    }

}
