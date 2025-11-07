package org.firstinspires.ftc.teamcode.game.decode.opmodes;

import org.firstinspires.ftc.teamcode.ExtendableOpmode;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.actions.IAction;
import org.firstinspires.ftc.teamcode.game.Game;
import org.firstinspires.ftc.teamcode.game.decode.DecodeGame;
import org.firstinspires.ftc.teamcode.game.decode.DecodeRobot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class DecodeOpmode extends ExtendableOpmode {
    Robot robot = new DecodeRobot();
    Game game = new DecodeGame();

    public void addAutoAction(IAction action) {
        actions.add(action);
    }

    private List<IAction> actions = new ArrayList<IAction>();

    @Override
    protected List<IAction> getAutoActions() {
        return actions;
    }
}
