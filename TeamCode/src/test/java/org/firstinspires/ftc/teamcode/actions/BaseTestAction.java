package org.firstinspires.ftc.teamcode.actions;

public abstract class BaseTestAction implements IAction {

    private boolean isInitialized = false;
    private boolean isFinished = false;
    private boolean isStopped = false;

    public BaseTestAction() {
    }

    public abstract boolean doInit();

    @Override
    public boolean init() {
        if (isInitialized() || isFinished() || isStopped()) {
            throw new IllegalStateException("Test action cannot be initialized twice or when finished or stopped");
        }
        isInitialized = doInit();
        return isInitialized();
    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    public abstract boolean doIterate();

    @Override
    public boolean iterate() {
        if (!isInitialized() || isFinished() || isStopped()) {
            throw new IllegalStateException("Test action has to be initialized before iteration");
        }
        isFinished = !doIterate();
        return !isFinished();
    }

    @Override
    public boolean isFinished() {
        return isFinished || isStopped;
    }

    public abstract boolean doStop();

    @Override
    public boolean stop() {
        isStopped = doStop();
        return isStopped();
    }

    @Override
    public boolean isStopped() {
        return isStopped;
    }

}
