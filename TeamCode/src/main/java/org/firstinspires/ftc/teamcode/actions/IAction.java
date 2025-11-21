package org.firstinspires.ftc.teamcode.actions;

/**
 * Specification for an Action
 */
public interface IAction {

    /**
     * Initialize the action. Should return true when the initialization
     * completes successfully. The state of the intialization can be
     * checked by calling {@link #isInitialized()}.
     *
     * When the initialization fails it should be possible to call
     * {@link #init()} again on the action. In all other cases {@link #init()}
     * should not be called again as this could throw a
     * {@link java.lang.IllegalStateException}.
     *
     * @return true when initialization completed successfully, otherwise false
     */
    boolean init();

    /**
     * Test whether the action is initialized
     *
     * @return true when initialized, otherwise false
     */
    boolean isInitialized();

    /**
     * Perform one iteration of the actions. Returns true when the action has
     * not finished and can be iterated again, otherwise false.
     *
     * This operation cannot be performed when the action is not initialized,
     * has finished or has been stopped. Calling {@link #iterate()} when the
     * action is in these states could throw a {@link java.lang.IllegalStateException}.
     *
     * @return true when the action has not finished and can be iterated again,
     *      otherwise false
     */
    boolean iterate();

    /**
     * Test whether the action has finished. When the action is finished, it
     * cannot be initialized again or iterated any further.
     *
     * @return true when finished, otherwise false
     */
    boolean isFinished();

    /**
     * Stop the action. The action should power down all the resources that
     * it was using, e.g. motors. After the action is stopped, it cannot be
     * initialized again or iterated any further. Performing any of these
     * operations could throw a {@link java.lang.IllegalStateException}.
     *
     * @return true when already stopped or stop was successful, otherwise false
     */
    boolean stop();

    /**
     * Test whether the action has stopped and powered down any used resources,
     * e.g. motors. When the action is stopped, it cannot be initialized again
     * or iterated any further.
     *
     * @return true when stopped, otherwise false
     */
    boolean isStopped();
}
