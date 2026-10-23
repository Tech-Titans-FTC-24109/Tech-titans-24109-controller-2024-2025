package org.firstinspires.ftc.teamcode.sensor.apriltag;

import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.List;

public interface IAprilTagDetector {

    /**
     * Get the current list of detected april tags
     *
     * @return the current list of detected april tags
     */
    List<AprilTagSingleDetection> getAprilTags();

    /**
     * Get the current list of detected april tag clusters (BIOBUZZ targets)
     *
     * @return the current list of detected april tag clusters
     */
    List<AprilTagClusterDetection> getClusters();

}
