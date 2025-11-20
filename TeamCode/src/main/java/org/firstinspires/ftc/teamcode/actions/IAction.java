package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

// TODO update the Javadoc so we know what to return when
public interface IAction {

    /**
     * Initialize the action. Returns true when TODO, otherwise false
     *
     * @return TODO
     */
    boolean init();

    /**
     * Test whether the action is initialized
     *
     * @return true when initialized, otherwise false
     */
    boolean isInitialized();

    /**
     * Perform one iteration of the actions. Returns true when TODO, otherwise false
     *
     * @return TODO
     */
    boolean iterate();

    /**
     * TODO
     *
     * @return TODO
     */
    boolean isFinished();

    /**
     * Stop the action. The action should power down all the resources that
     * it was using, e.g. motors.
     *
     * @return true when already stopped or stop was successful, otherwise false
     */
    boolean stop();

    /**
     * Test whether the action has stopped and powered down any used resources,
     * e.g. motors
     *
     * @return true when stopped, otherwise false
     */
    boolean isStopped();
}
