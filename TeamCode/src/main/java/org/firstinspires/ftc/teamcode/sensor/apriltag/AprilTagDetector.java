package org.firstinspires.ftc.teamcode.sensor.apriltag;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.ArrayList;
import java.util.List;

public class AprilTagDetector implements IAprilTagDetector {

    private final VisionPortal visionPortal;
    private final AprilTagProcessor aprilTagProcessor;

    public AprilTagDetector(CameraName camera) {
        this.aprilTagProcessor = new AprilTagProcessor.Builder()
                .setTagLibrary(AprilTagGameDatabase.getCurrentGameTagLibrary())
                .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                .build();
        this.visionPortal = new VisionPortal.Builder()
                .setCamera(camera)
                .addProcessor(aprilTagProcessor)
                .build();
    }

    /**
     * Only single-tag detections are returned. Tag clusters have no tag id,
     * so they are filtered out here.
     */
    @Override
    public List<AprilTagSingleDetection> getAprilTags() {
        List<AprilTagSingleDetection> singleTags = new ArrayList<>();
        for (AprilTagDetection detection : aprilTagProcessor.getDetections()) {
            if (detection instanceof AprilTagSingleDetection) {
                singleTags.add((AprilTagSingleDetection) detection);
            }
        }
        return singleTags;
    }
}
