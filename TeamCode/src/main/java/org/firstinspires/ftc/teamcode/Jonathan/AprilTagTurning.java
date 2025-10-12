package org.firstinspires.ftc.teamcode.Jonathan;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@Autonomous
public class AprilTagTurning extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        AprilTagProcessor aprilTag = new AprilTagProcessor.Builder().setTagLibrary(AprilTagGameDatabase.getCurrentGameTagLibrary()).build();

        VisionPortal visionPortal = new VisionPortal.Builder().setCamera(hardwareMap.get(WebcamName.class, "Webcam 1")).addProcessor(aprilTag).build();

        waitForStart();
        while (opModeIsActive()) {
            List<AprilTagDetection> currentDetections = aprilTag.getDetections();

            if (!currentDetections.isEmpty()) {
                for (AprilTagDetection detection : currentDetections) {
                    if (detection.id >= 20 && detection.id <= 24) {
                        telemetry.addData("Tag ID", detection.id);
                        telemetry.addData("Tag Pose X", detection.ftcPose.x);
                        telemetry.addData("Tag Pose Y", detection.ftcPose.y);
                        telemetry.addData("Tag Pose Z", detection.ftcPose.z);
                    } else {
                        telemetry.addLine("Unknown april tag detected");
                    }
                }
            }
            telemetry.update();
        }
    }
}
