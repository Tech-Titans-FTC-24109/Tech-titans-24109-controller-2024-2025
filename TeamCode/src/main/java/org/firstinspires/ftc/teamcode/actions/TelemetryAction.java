package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TelemetryAction implements IAction{
    private Telemetry telemetry;
    private int iteration = 0;

    @Override
    public boolean init(LinearOpMode opMode) {
        telemetry = opMode.telemetry;
        return true;
    }

    @Override
    public boolean iterate() {
        telemetry.addLine(String.valueOf(iteration));
        telemetry.update();
        iteration++;
        return true;
    }

    @Override
    public boolean isFinished() {
        return iteration == 100;
    }

    @Override
    public boolean stop() {
        return true;
    }
}
