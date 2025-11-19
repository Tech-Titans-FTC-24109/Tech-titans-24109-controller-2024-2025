package org.firstinspires.ftc.teamcode.actions;

public interface ICompositeAction extends IAction {

    /**
     * Get all the actions that make up this composite action
     *
     * @return all the actions that make up this composite action
     */
    IAction[] getActions();
}
