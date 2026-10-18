package org.firstinspires.ftc.teamcode.sensor.apriltag;

import org.firstinspires.ftc.teamcode.game.Alliance;
import org.firstinspires.ftc.teamcode.game.decode.Motif;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.List;

public class DecodeAprilTagDetector implements IDecodeAprilTagDetector {

    public static final int RED_GOAL_APRIL_TAG_ID = 24;
    public static final int BLUE_GOAL_APRIL_TAG_ID = 20;

    private final IAprilTagDetector aprilTagDetector;

    public DecodeAprilTagDetector(IAprilTagDetector aprilTagDetector) {
        this.aprilTagDetector = aprilTagDetector;
    }

    @Override
    public boolean isRedGoalDetected() {
        List<AprilTagSingleDetection> aprilTags = aprilTagDetector.getAprilTags();
        for (AprilTagSingleDetection aprilTag : aprilTags) {
            if (aprilTag.id == RED_GOAL_APRIL_TAG_ID) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBlueGoalDetected() {
        List<AprilTagSingleDetection> aprilTags = aprilTagDetector.getAprilTags();
        for (AprilTagSingleDetection aprilTag : aprilTags) {
            if (aprilTag.id == BLUE_GOAL_APRIL_TAG_ID) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isMotifDetected() {
        List<AprilTagSingleDetection> aprilTags = aprilTagDetector.getAprilTags();
        for (AprilTagSingleDetection aprilTag : aprilTags) {
            if (aprilTag.id >= 21 && aprilTag.id <= 23) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Motif getMotif() {
        List<AprilTagSingleDetection> aprilTags = aprilTagDetector.getAprilTags();
        for (AprilTagSingleDetection aprilTag : aprilTags) {
            if (Motif.getByAprilTagId(aprilTag.id) != Motif.Unknown) {
                return Motif.getByAprilTagId(aprilTag.id);
            }
        }
        return Motif.Unknown;
    }

    @Override
    public boolean isGoalDetected(Alliance alliance) {
        return (alliance == Alliance.RED && isRedGoalDetected())
                || (alliance == Alliance.BLUE && isBlueGoalDetected());
    }

    @Override
    public double getDistance() {
        List<AprilTagSingleDetection> aprilTags = aprilTagDetector.getAprilTags();
        for (AprilTagSingleDetection aprilTag : aprilTags) {
            return aprilTag.ftcPose.range;
        }
        return 0;
    }
}
