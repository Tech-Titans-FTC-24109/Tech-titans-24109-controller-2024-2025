package org.firstinspires.ftc.teamcode.robot.component;

import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.ImuOrientationOnRobot;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class TestIMU implements IMU {

    public static final IMU.Parameters DEFAULT_PARAMETERS =
            new IMU.Parameters(
                    new ImuOrientationOnRobot() {
                        @Override
                        public Quaternion imuCoordinateSystemOrientationFromPerspectiveOfRobot() {
                            return Quaternion.identityQuaternion();
                        }

                        @Override
                        public Quaternion imuRotationOffset() {
                            return Quaternion.identityQuaternion();
                        }

                        @Override
                        public Quaternion angularVelocityTransform() {
                            return Quaternion.identityQuaternion();
                        }
                    });

    public static final Manufacturer MANUFACTURER = Manufacturer.Other;
    public static final String DEVICE_NAME = "Test IMU";
    public static final String CONNECTION_INFO = "Connection";
    public static final int VERSION = 24109;

    public static final YawPitchRollAngles DEFAULT_YPR_ANGLES = new YawPitchRollAngles(
            AngleUnit.DEGREES,
            0.0d, 0.0d, 0.0d,
            0L
    );

    private final YawPitchRollAngles[] yprAngles;

    private int indexYpr = 0;

    public static TestIMU createIMU() {
        return new TestIMU();
    }

    public static TestIMU createIMU(AngleUnit angleUnit, double... yaws) {
        YawPitchRollAngles[] yawPitchRollAngles = new YawPitchRollAngles[yaws.length];
        for (int i = 0; i < yaws.length; i++) {
            yawPitchRollAngles[i] = new YawPitchRollAngles(
                    angleUnit,
                    yaws[i], 0.0d, 0.0d,
                    i * 1000L
            );
        }
        return new TestIMU(yawPitchRollAngles);
    }

    private TestIMU() {
        this(DEFAULT_YPR_ANGLES);
    }

    private TestIMU(YawPitchRollAngles... yawPitchRollAngles) {
        this.yprAngles = yawPitchRollAngles;
    }

    @Override
    public boolean initialize(Parameters parameters) {
        return true;
    }

    @Override
    public void resetYaw() {
    }

    @Override
    public YawPitchRollAngles getRobotYawPitchRollAngles() {
        return this.yprAngles[indexYpr];
    }

    public boolean nextYawPitchRollAngles() {
        if (this.indexYpr < (this.yprAngles.length - 1)) {
            this.indexYpr++;
            return true;
        }
        return false;
    }

    @Override
    public Orientation getRobotOrientation(AxesReference reference, AxesOrder order, AngleUnit angleUnit) {
        return null;
    }

    @Override
    public Quaternion getRobotOrientationAsQuaternion() {
        return null;
    }

    @Override
    public AngularVelocity getRobotAngularVelocity(AngleUnit angleUnit) {
        return null;
    }

    @Override
    public Manufacturer getManufacturer() {
        return MANUFACTURER;
    }

    @Override
    public String getDeviceName() {
        return DEVICE_NAME;
    }

    @Override
    public String getConnectionInfo() {
        return CONNECTION_INFO;
    }

    @Override
    public int getVersion() {
        return VERSION;
    }

    @Override
    public void resetDeviceConfigurationForOpMode() {
    }

    @Override
    public void close() {
    }
}
