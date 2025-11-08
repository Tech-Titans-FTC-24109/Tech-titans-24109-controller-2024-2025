package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.actions.IAction;

import java.util.Iterator;
import java.util.List;

public abstract class ExtendableOpmode extends LinearOpMode {

    protected abstract List<IAction> getAutoActions();

    protected abstract void createGame();

    protected abstract void createRobot();

    protected abstract void createMatch();

    @Override
    public void runOpMode() throws InterruptedException {

        // init

        createGame();

        createRobot();

        createMatch();


        // start
        waitForStart();

        Iterator<IAction> actionIterator = getAutoActions().iterator();

        // loop

        while (opModeIsActive() && actionIterator.hasNext()) {

            IAction action = actionIterator.next();
            action.init();

            while (opModeIsActive() && !action.isFinished()) {
                action.iterate();
            }

        }
    }
}
