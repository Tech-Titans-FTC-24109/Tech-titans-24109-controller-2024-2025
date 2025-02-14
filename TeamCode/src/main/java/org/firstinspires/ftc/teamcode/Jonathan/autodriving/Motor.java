package org.firstinspires.ftc.teamcode.Jonathan.autodriving;

public class Motor {
    private double gearRatio;
    private int pulsesPerRevolution;

    public Motor(double gearRatio, int PulsesPerRevolution) {
        this.gearRatio = gearRatio;
        this.pulsesPerRevolution = PulsesPerRevolution;
    }

    public double getGearRatio() {
        return gearRatio;
    }

    /**
     * @return the number of pulses per revolution after the gear ratio has been applied
     */
    public double getGearedPulsesPerRevolution() {
        return pulsesPerRevolution * gearRatio;
    }
}
