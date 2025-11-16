package org.firstinspires.ftc.teamcode.robot;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.game.Alliance;

public class Robot {
    private Pose2D startPosition = new Pose2D(DistanceUnit.CM, 0, 0, AngleUnit.DEGREES, 0);
    private Pose2D currentLocation = this.startPosition;
    private Alliance alliance = Alliance.RED;

    public Pose2D getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Pose2D startPosition) {
        this.startPosition = startPosition;
        currentLocation = startPosition;
    }

    public Pose2D getCurrentLocation() {
        return currentLocation;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
