package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.actions.IAction;
import org.firstinspires.ftc.teamcode.game.Game;

import java.util.List;

public abstract class ExtendableOpmode extends LinearOpMode {
    protected abstract List<IAction> getAutoActions();
    protected abstract void createAutoActions();
    @Override
    public void runOpMode() throws InterruptedException {
        createAutoActions();
        waitForStart();
        for (IAction action: getAutoActions()) {
            if (!action.isFinished()) {
                action.iterate();
            }
        }
    }
}
