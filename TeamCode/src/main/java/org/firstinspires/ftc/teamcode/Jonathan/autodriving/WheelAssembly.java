package org.firstinspires.ftc.teamcode.Jonathan.autodriving;

public class WheelAssembly {
    private Wheel wheel;
    private Motor motor;

    public WheelAssembly(Wheel wheel, Motor motor) {
        this.wheel = wheel;
        this.motor = motor;
    }

    public double pulsesPerCM() {
        return 1 / (wheel.getCircumference() / motor.getGearedPulsesPerRevolution());
    }
}
