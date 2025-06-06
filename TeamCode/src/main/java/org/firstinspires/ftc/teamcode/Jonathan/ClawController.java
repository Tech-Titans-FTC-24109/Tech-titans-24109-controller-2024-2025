package org.firstinspires.ftc.teamcode.Jonathan;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private static final double clawOpen = 0.85;
    private static final double clawClosed = 0.6;
    
    private Servo claw;
    private Servo wrist;

    public ClawController(@NonNull HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "Claw");
        claw.setDirection(Servo.Direction.FORWARD);
        claw.setPosition(clawClosed);

        wrist = hardwareMap.get(Servo.class, "Wrist");
        wrist.setDirection(Servo.Direction.FORWARD);
        wrist.setPosition(0.5);
    }

    public void closeClaw() {
        claw.setPosition(clawClosed);
    }

    public void openClaw() {
        claw.setPosition(clawOpen);
    }

    public double getClawPosition() {
        return claw.getPosition();
    }

    public void toggleClaw() {
        if (claw.getPosition() == clawClosed) {
            claw.setPosition(clawOpen);
        } else {
            claw.setPosition(clawClosed);
        }
    }

    public void moveWristLeft() {
        wrist.setPosition(wrist.getPosition() - 0.05);
    }

    public void moveWristRight() {
        wrist.setPosition(wrist.getPosition() + 0.05);
    }
}
