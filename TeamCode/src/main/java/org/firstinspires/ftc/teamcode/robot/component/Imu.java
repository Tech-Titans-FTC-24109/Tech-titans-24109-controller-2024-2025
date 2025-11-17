package org.firstinspires.ftc.teamcode.robot.component;

import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Imu {

    private final IMU imu;
    private final boolean useProxies;

    public Imu(IMU imu) {
        this(imu, false);
    }

    public Imu(IMU imu, boolean useProxies) {
        this.imu = imu;
        this.useProxies = useProxies;
    }

    public IMU createProxy() {
        if (useProxies) {
            return new ImuProxy(this.imu);
        }
        return imu;
    }

    /**
     * Method to initialize the actual IMU. Should only be called once.
     * Does not reset the IMU.
     *
     * @param imuParams parameters to use for initializing the IMU
     */
    public void initialize(IMU.Parameters imuParams) {
        this.imu.initialize(imuParams);
    }

    public static class ImuProxy implements IMU {

        private final IMU imu;

        public ImuProxy(IMU imu) {
            this.imu = imu;
        }

        @Override
        public boolean initialize(Parameters parameters) {
            // not delegating as we would be affecting all proxies
            throw new UnsupportedOperationException("Cannot initialize() ImuProxy object - instead call initialize on the real IMU or Imu instance");
        }

        @Override
        public void resetYaw() {
            // TODO - implement this should only affect this proxy instance
        }

        @Override
        public YawPitchRollAngles getRobotYawPitchRollAngles() {
            // TODO - implement
            YawPitchRollAngles yprAngles = this.imu.getRobotYawPitchRollAngles();
            //orientation.getYaw()
            return yprAngles;
        }

        @Override
        public Orientation getRobotOrientation(AxesReference reference, AxesOrder order, AngleUnit angleUnit) {
            // TODO - implement - not used
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public Quaternion getRobotOrientationAsQuaternion() {
            // TODO - implement - not used
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public AngularVelocity getRobotAngularVelocity(AngleUnit angleUnit) {
            // TODO - implement - not used
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public void resetDeviceConfigurationForOpMode() {
            // not delegating as we would be affecting all proxies
            throw new UnsupportedOperationException("Cannot resetDeviceConfigurationForOpMode() ImuProxy object");
        }

        @Override
        public void close() {
            // not delegating as we are not sure whether we are the last proxy
            throw new UnsupportedOperationException("Cannot close() ImuProxy object");
        }

        @Override
        public Manufacturer getManufacturer() {
            return this.imu.getManufacturer();
        }

        @Override
        public String getDeviceName() {
            return this.imu.getDeviceName();
        }

        @Override
        public String getConnectionInfo() {
            return this.imu.getConnectionInfo();
        }

        @Override
        public int getVersion() {
            return this.imu.getVersion();
        }
    }
}
