package org.firstinspires.ftc.teamcode.actions;

public class TestAction implements IAction {

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
    public boolean init() {
        if (isInitialized() || isFinished() || isStopped()) {
            throw new IllegalStateException("Test action cannot be initialized twice or when finished or stopped");
        }
        currentIters = 0;
        return true;
    }

    @Override
    public boolean isInitialized() {
        return currentIters >= 0;
    }

    @Override
    public boolean iterate() {
        if (!isInitialized() || isFinished()) {
            throw new IllegalStateException("Test action has to be initialized before iteration");
        }
        if (!isFinished()) {
            currentIters++;
        }
        return !isFinished();
    }

    @Override
    public boolean isFinished() {
        return currentIters >= numIters;
    }

    @Override
    public boolean stop() {
        currentIters = numIters;
        return true;
    }

    @Override
    public boolean isStopped() {
        return currentIters >= numIters;
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
