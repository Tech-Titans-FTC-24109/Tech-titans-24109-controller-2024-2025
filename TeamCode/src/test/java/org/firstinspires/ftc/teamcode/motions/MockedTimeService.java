package org.firstinspires.ftc.teamcode.motions;

public class MockedTimeService implements ElapsedTimeSupplier {
    private final long[] timesToSpoof;
    private int index = 0;

    public MockedTimeService(long... timesToSpoof) {
        this.timesToSpoof = timesToSpoof;
    }

    @Override
    public long getAsLong() {
        if (timesToSpoof.length <= index) {
            return timesToSpoof[timesToSpoof.length-1];
        }
        index++;
        return timesToSpoof[index-1];
    }
}
