package org.firstinspires.ftc.teamcode;

public interface Stoppable {

    /**
     * Stop a stoppable
     *
     * @return true when stop was successful, otherwise false
     */
    boolean stop();

    /**
     * Check whether Stoppable is stopped
     *
     * @return true when stopped, otherwise false
     */
    boolean isStopped();
}
