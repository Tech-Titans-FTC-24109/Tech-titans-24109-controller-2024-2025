package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TelemetryAction implements IAction{
    private final Telemetry telemetry;
    private int iteration = 0;

    private String dataName;

    public TelemetryAction(String dataName, Telemetry telemetry) {
        this.dataName = dataName;
        this.telemetry = telemetry;
    }

    @Override
    public boolean init() {
        return isInitialized();
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    @Override
    public boolean iterate() {
        telemetry.addData(dataName, Integer.valueOf(iteration));
        telemetry.update();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        iteration++;
        return true;
    }

    @Override
    public boolean isFinished() {
        return iteration == 50;
    }

    @Override
    public boolean stop() {
        // TODO - implement
        return true;
    }

    @Override
    public boolean isStopped() {
        // TODO - implement
        return false;
    }
}
