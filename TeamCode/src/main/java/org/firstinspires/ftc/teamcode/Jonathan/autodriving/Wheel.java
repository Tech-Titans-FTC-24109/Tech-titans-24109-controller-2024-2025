package org.firstinspires.ftc.teamcode.Jonathan.autodriving;

public class Wheel {
    private double circumference;

    public Wheel(double diameter) {
        this.circumference = Math.PI * diameter;
    }

    public double getCircumference() {
        return circumference;
    }
}
