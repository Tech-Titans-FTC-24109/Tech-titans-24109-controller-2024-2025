package org.firstinspires.ftc.teamcode.game.decode.opmodes;

import org.firstinspires.ftc.teamcode.ExtendableOpmode;
import org.firstinspires.ftc.teamcode.actions.IAction;
import org.firstinspires.ftc.teamcode.game.Game;
import org.firstinspires.ftc.teamcode.game.decode.DecodeGame;
import org.firstinspires.ftc.teamcode.game.decode.DecodeRobot;

import java.util.ArrayList;
import java.util.List;

public abstract class DecodeOpmode extends ExtendableOpmode {

    private DecodeRobot robot;

    private Game game;

    // TODO - should this move to Game? Or Robot as it is the auto strategy?
    private List<IAction> actions = new ArrayList<IAction>();

    protected void addAutoAction(IAction action) {
        actions.add(action);
    }

    @Override
    protected List<IAction> getAutoActions() {
        return actions;
    }

    @Override
    protected void createGame() {
        this.game = new DecodeGame();
    }

    @Override
    protected void createRobot() {
        this.robot = new DecodeRobot(this.hardwareMap, this.telemetry);
    }

    public DecodeRobot getRobot() {
        return robot;
    }
}
