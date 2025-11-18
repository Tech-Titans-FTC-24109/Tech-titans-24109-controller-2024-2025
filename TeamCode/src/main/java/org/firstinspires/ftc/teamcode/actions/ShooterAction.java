package org.firstinspires.ftc.teamcode.actions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.controllers.ShooterWheelController;

public class ShooterAction implements IAction{
    int iterates = 0;
    private final ShooterWheelController shooterWheelController;
    private final Telemetry telemetry;
    private final double power;


    public ShooterAction(Telemetry telemetry, ShooterWheelController shooterWheelController, double power) {
        this.telemetry = telemetry;
        this.shooterWheelController = shooterWheelController;
        this.power = power;
    }

    @Override
    public boolean init() {
        return true;
    }

    @Override
    public boolean iterate() {
        shooterWheelController.spinWheel(power);
        iterates++;
        return true;
    }

    @Override
    public boolean isFinished() {
        if (iterates >= 100) {
            shooterWheelController.spinWheel(0);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean stop() {
        return false;
    }
}
