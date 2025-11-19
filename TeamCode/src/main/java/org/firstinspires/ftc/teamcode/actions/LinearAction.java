package org.firstinspires.ftc.teamcode.actions;

// TODO - implement
public class LinearAction implements ICompositeAction {

    private final IAction[] linearActions;

    public LinearAction(IAction... linearActions) {
        this.linearActions = linearActions;
    }

    @Override
    public IAction[] getActions() {
        return linearActions;
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
