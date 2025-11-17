package org.firstinspires.ftc.teamcode.actions;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ShooterAction implements IAction{

    private final Telemetry telemetry;

    public ShooterAction(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    @Override
    public boolean init() {
        return false;
    }

    @Override
    public boolean iterate() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }
}
