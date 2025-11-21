package org.firstinspires.ftc.teamcode.actions;

public class TestAction extends BaseTestAction {

    private final String id;
    private final int numIters;

    private int currentIters = -1;

    public TestAction(int numIters) {
        this("N/A", numIters);
    }

    public TestAction(String id, int numIters) {
        this.id = id;
        this.numIters = numIters;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean doInit() {
        currentIters = 0;
        return true;
    }

    @Override
    public boolean doIterate() {
        currentIters++;
        return !(currentIters >= numIters);
    }

    @Override
    public boolean doStop() {
        currentIters = numIters;
        return true;
    }

    @Override
    public String toString() {
        return "TestAction{" +
                "id='" + id + '\'' +
                ", numIters=" + numIters +
                ", currentIters=" + currentIters +
                '}';
    }
}
