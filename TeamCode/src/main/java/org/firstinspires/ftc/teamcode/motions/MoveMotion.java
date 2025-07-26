package org.firstinspires.ftc.teamcode.motions;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Jonah.ImuUtility;
import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;

public class MoveMotion extends AbstractMotion{

    private final MecanumWheelsController wheels;
    private final Telemetry telemetry;

    public MoveMotion(MecanumWheelsController wheels, Telemetry telemetry) {

        super();
        this.wheels = wheels;
        this.telemetry = telemetry;
    }

    @Override
    protected void initMotion() {
        //idk wat ima do here
    }

    @Override
    protected boolean performMove() {
        return false;
    }


}
