package org.firstinspires.ftc.teamcode.actions;

// TODO - implement
public class ParallelAction implements ICompositeAction {

    private final IAction[] parallelActions;

    public ParallelAction(IAction... parallelActions) {
        this.parallelActions = parallelActions;
    }

    @Override
    public IAction[] getActions() {
        return parallelActions;
    }

    @Override   // TODO implement
    public boolean init() {
        return false;
    }

    @Override   // TODO implement
    public boolean isInitialized() {
        return true;
    }

    @Override   // TODO implement
    public boolean iterate() {
        return false;
    }

    @Override   // TODO implement
    public boolean isFinished() {
        return false;
    }

    @Override   // TODO implement
    public boolean stop() {
        return false;
    }

    @Override   // TODO implement
    public boolean isStopped() {
        return ICompositeAction.super.isStopped();
    }
}