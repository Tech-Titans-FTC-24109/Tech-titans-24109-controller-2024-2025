package org.firstinspires.ftc.teamcode.motions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;

public class SleepMotion extends AbstractMotion {

    private final ImuUtility imuCalculator;
    private final long sleepTime;
    private final Telemetry telemetry;
    private long startTime;

    public SleepMotion(ImuUtility imuCalculator, long sleepTime, Telemetry telemetry) {
        this.imuCalculator = imuCalculator;
        this.sleepTime = sleepTime;
        this.telemetry = telemetry;
    }

    @Override
    public void initMotion() {
        imuCalculator.reset();
        startTime = System.currentTimeMillis();
    }

    @Override
    public boolean performMove() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime < sleepTime) {
            telemetry.addData("Sleep Time Remaining", sleepTime - (currentTime - startTime));
            telemetry.update();
            return false;
        }
        telemetry.addLine("Sleep Time Finished");
        telemetry.update();
        return true;
    }
}
