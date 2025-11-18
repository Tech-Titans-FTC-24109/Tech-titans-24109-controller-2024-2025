package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

/*
📊 Coordinate System (OpenFTC / EasyOpenCV)

From your stream image and tests:

Axis	Meaning	Units (cm or inches depending on config)
X	    Left/Right (positive = right)
Y	    Forward/Backward (distance to tag)
Z	    Up/Down (positive = up)

Distance to april tag (z)
Detections  | Real
---------------------
 40         |  47.5
 60         |  70.5
 80         |  94.5
100         | 114.5
120         | 137

Bearing : Angle to camera view centered on april tag
            Ex: bearing 0 when facing center of april tag
Yaw     : Angle to camera view perpendicular to april tag
            Ex: yaw 0 when camera is perpendicular to the center of the april tag


 */

//@Autonomous
public class AprilTagDataDetection extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        AprilTagProcessor aprilTag = new AprilTagProcessor.Builder()
                .setTagLibrary(AprilTagGameDatabase.getCurrentGameTagLibrary())
                .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                .build();

        VisionPortal visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessor(aprilTag)
                .build();

        waitForStart();
        while (opModeIsActive()) {
            List<AprilTagDetection> currentDetections = aprilTag.getDetections();

            if (!currentDetections.isEmpty()) {
                for (AprilTagDetection detection : currentDetections) {
                    if (detection.id >= 20 && detection.id <= 24) {
                        double angleToTag = Math.toDegrees(Math.atan2(detection.ftcPose.x, detection.ftcPose.y));
                        telemetry.addData("Tag ID", detection.id);
                        telemetry.addData("Tag Pose X", detection.ftcPose.x);
                        telemetry.addData("Tag Pose Y", detection.ftcPose.y);
                        telemetry.addData("Tag Pose Z", detection.ftcPose.z);
                        telemetry.addData("Tag Pose Bearing", detection.ftcPose.bearing);
                        telemetry.addData("Tag Pose Yaw", detection.ftcPose.yaw); //
                        telemetry.addData("Tag Pose Elevation", detection.ftcPose.elevation);
                        telemetry.addData("Tag Pose Pitch", detection.ftcPose.pitch);
                        telemetry.addData("Tag Pose Range", detection.ftcPose.range);
                        telemetry.addData("Tag Pose Roll", detection.ftcPose.roll);
                        if (detection.id == 20) {
                            telemetry.addLine(String.format("turn %s degrees", angleToTag));
                        }
                    } else {
                        telemetry.addLine("Unknown april tag detected");
                    }
                }
            }
            telemetry.update();
        }
    }
}
