package org.firstinspires.ftc.teamcode;

public interface Startable {

    /**
     * Start a Startable
     *
     * @return true when start was successful, otherwise false
     */
    boolean start();

    /**
     * Check whether startable has started
     *
     * @return true when started, otherwise false
     */
    boolean isStarted();
}
