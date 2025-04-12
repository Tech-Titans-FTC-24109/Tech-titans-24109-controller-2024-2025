package org.firstinspires.ftc.teamcode.motions;

/**
 * Abstract base class for all Motion classes, e.g. TurnMotion.
 *
 * A concrete derived class (subclass) should implement the two
 * abstract template methods. These two methods have to be implemented
 * in a motion specific way to initialize the motion and perform a move.
 * {@link #initMotion()} should be called exactly once before performing a
 * move by calling {@link #performMove()}.
 */
public abstract class AbstractMotion {

    private boolean isInit = false;
    private boolean motionComplete = false;

    /**
     * Template method for initializing the concrete motion
     * To be implemented by subclass
     */
    protected abstract void initMotion();

    /**
     * Template method for performing one step/iteration of the concrete motion
     * To be implemented by subclass
     *
     * @return true if the move is complete, otherwise return false
     */
    protected abstract boolean performMove();

    /**
     * Test whether the motion is initialized
     *
     * @return true when the motion is initialize, false otherwise
     */
    public boolean isInitialized() {
        return isInit;
    }

    /**
     * Test whether the motion has completed
     *
     * @return true when the motion has completed, false otherwise
     */
    public boolean isCompleted() {
        return motionComplete;
    }

    /**
     * Initialization of the motion. This method should be called exactly once.
     * When calling a second time a {@link IllegalStateException} is thrown
     * indicating that the motion is already initialized.
     * <p>
     * When called, this method will call the {@link #initMotion()} template
     * method implemented by the concrete subclass.
     *
     * @throws IllegalStateException when the motion is already initialized
     */
    public void init() {
        if (!isInit) {
            initMotion();
            isInit = true;
        } else {
            throw new IllegalStateException("Already initialized. you are a bad boy...");
        }
    }

    /**
     * Perform a single step/iteration of the motion. Typically, called
     * repeatedly in the {@code while} loop of the opMode until the motion is
     * complete.
     * <p>
     * When called, this method will check whether the motion is initialized
     * before calling the {@link #performMove()} template method implemented
     * by the concrete subclass.
     * <p>
     * When {@link #move()} is called on an already completed motion, the
     * {@link #performMove()} will not be called
     *
     * @return true when the motion completed when performing the move or when
     *      the motion was already completed. Otherwise false.
     * @throws IllegalStateException when the motion is not initialized
     */
    public boolean move() {
        if (!isInit) {
            throw new IllegalStateException("cannot move without initialization you bababoy");
        }
        if (!motionComplete) {
            motionComplete = performMove();
        }

        return motionComplete;
    }
}
