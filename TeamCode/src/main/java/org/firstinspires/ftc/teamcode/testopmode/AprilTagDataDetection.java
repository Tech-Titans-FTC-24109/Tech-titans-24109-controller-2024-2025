package org.firstinspires.ftc.teamcode.testopmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.sensor.apriltag.AprilTagDetector;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;

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

@Autonomous
public class AprilTagDataDetection extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        CameraName cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");
        AprilTagDetector detector = new AprilTagDetector(cameraName);

        waitForStart();
        while (opModeIsActive()) {
//            if (detector.isStopped()) {
//                detector.start();
//            }
            List<AprilTagClusterDetection> clusters = detector.getClusters();

            for (AprilTagClusterDetection cluster : clusters) {
                double angleToTarget = Math.toDegrees(Math.atan2(cluster.ftcPose.x, cluster.ftcPose.y));
                telemetry.addData("Cluster", cluster.metadata.name);
                telemetry.addData("Cluster Found %", cluster.percentClusterFound);
                telemetry.addData("Pose X", cluster.ftcPose.x);
                telemetry.addData("Pose Y", cluster.ftcPose.y);
                telemetry.addData("Pose Z", cluster.ftcPose.z);
                telemetry.addData("Pose Bearing", cluster.ftcPose.bearing);
                telemetry.addData("Pose Yaw", cluster.ftcPose.yaw);
                telemetry.addData("Pose Elevation", cluster.ftcPose.elevation);
                telemetry.addData("Pose Pitch", cluster.ftcPose.pitch);
                telemetry.addData("Pose Range", cluster.ftcPose.range);
                telemetry.addData("Pose Roll", cluster.ftcPose.roll);
                telemetry.addLine(String.format("turn %s degrees", angleToTarget));
            }
            telemetry.update();
        }

//        detector.stop();
    }
}
