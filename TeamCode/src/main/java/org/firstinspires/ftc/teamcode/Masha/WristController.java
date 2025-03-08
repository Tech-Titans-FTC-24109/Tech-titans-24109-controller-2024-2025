package org.firstinspires.ftc.teamcode.Masha;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class WristController {
    private static final double WRIST_START = 0.5;
    public static final double MOVEMENT_POWER = 0.001;

    private Servo servo;

    public WristController(HardwareMap hardwareMap) {
        servo = hardwareMap.get(Servo.class, "Wrist");
        servo.setDirection(Servo.Direction.FORWARD);
        servo.setPosition(WRIST_START);
    }

    public void rotateLeft() {
        if (servo.getPosition()<=0) return;
        servo.setPosition(servo.getPosition()- MOVEMENT_POWER);
    }

    public void rotateRight() {
        if (servo.getPosition()>=1) return;
        servo.setPosition(servo.getPosition()+MOVEMENT_POWER);
    }

    public void reset() {
        servo.setPosition(0);
    }
}
