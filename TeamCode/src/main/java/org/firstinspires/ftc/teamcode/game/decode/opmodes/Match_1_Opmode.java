package org.firstinspires.ftc.teamcode.game.decode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.actions.IAction;
import org.firstinspires.ftc.teamcode.actions.TelemetryAction;

import java.util.Arrays;
import java.util.List;

@Autonomous(name = "Match 1", group = "Match Opmodes")
public class Match_1_Opmode extends DecodeOpmode {

    @Override
    protected void createAutoActions() {
        addAutoAction(new TelemetryAction());
    }
}
