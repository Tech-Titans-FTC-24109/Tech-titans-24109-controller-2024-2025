package org.firstinspires.ftc.teamcode.actions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public interface IAction {
    boolean init();
    boolean iterate();
    boolean isFinished();
    boolean stop();
}
