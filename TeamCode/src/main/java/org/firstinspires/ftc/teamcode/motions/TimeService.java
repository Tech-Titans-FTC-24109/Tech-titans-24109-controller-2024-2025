package org.firstinspires.ftc.teamcode.motions;

/**
 *
 */
public class TimeService implements ElapsedTimeSupplier {
    private long previousTime = 0;

    @Override
    public long getAsLong() {
        long time = getCurrentTime();
        if (previousTime == 0) {
            previousTime = time;
        }
        long calculatedTime = time-previousTime;
        previousTime = time;
        return calculatedTime;
    }

    protected long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
