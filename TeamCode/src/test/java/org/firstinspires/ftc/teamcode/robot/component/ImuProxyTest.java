package org.firstinspires.ftc.teamcode.robot.component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ImuProxyTest {

    @Nested
    @DisplayName("Proxy behavior")
    public class ProxyBehavior {

        @Test
        @DisplayName("WHEN created EXPECT proxy values from actual IMU")
        void WHEN_created_EXPECT_proxyValuesFromActualImu() {
            TestIMU actualIMU = TestIMU.createIMU(AngleUnit.DEGREES, 0.0d, 45.0d, 90.d);
            IMU imu = new Imu.ImuProxy(actualIMU);

            // test 0.0
            assertThat(imu.getRobotYawPitchRollAngles(), is(actualIMU.getRobotYawPitchRollAngles()));
            assertTrue(actualIMU.nextYawPitchRollAngles());
            // test 45.0
            assertThat(imu.getRobotYawPitchRollAngles(), is(actualIMU.getRobotYawPitchRollAngles()));
            assertTrue(actualIMU.nextYawPitchRollAngles());
            // test 90.0
            assertThat(imu.getRobotYawPitchRollAngles(), is(actualIMU.getRobotYawPitchRollAngles()));
            // don't have another value
            assertFalse(actualIMU.nextYawPitchRollAngles());
        }
    }

    @Nested
    @DisplayName("Unsupported methods")
    public class UnsupportedMethods {

        @Test
        @DisplayName("WHEN proxy EXPECT cannot call initialize")
        void WHEN_proxy_EXPECT_cannotCallInitialize() {
            IMU imu = new Imu.ImuProxy(TestIMU.createIMU());

            assertThrows(UnsupportedOperationException.class, () ->
                    imu.initialize(TestIMU.DEFAULT_PARAMETERS));
        }

        @Test
        @DisplayName("WHEN proxy EXPECT cannot call resetDeviceConfigurationForOpMode")
        void WHEN_proxy_EXPECT_cannotCallResetDeviceConfigurationForOpMode() {
            IMU imu = new Imu.ImuProxy(TestIMU.createIMU());

            assertThrows(UnsupportedOperationException.class, imu::resetDeviceConfigurationForOpMode);
        }

        @Test
        @DisplayName("WHEN proxy EXPECT cannot call close")
        void WHEN_proxy_EXPECT_cannotCallClose() {
            IMU imu = new Imu.ImuProxy(TestIMU.createIMU());

            assertThrows(UnsupportedOperationException.class, imu::close);
        }
    }

    @Nested
    @DisplayName("Delegated methods")
    public class DelegatedMethods {

        @Test
        @DisplayName("WHEN proxy EXPECT delegate to real IMU for static values")
        void WHEN_proxy_EXPECT_delegateToRealImuForStaticValues() {
            IMU imu = new Imu.ImuProxy(TestIMU.createIMU());

            assertThat(imu.getManufacturer(), is(TestIMU.MANUFACTURER));
            assertThat(imu.getDeviceName(), is(TestIMU.DEVICE_NAME));
            assertThat(imu.getConnectionInfo(), is(TestIMU.CONNECTION_INFO));
            assertThat(imu.getVersion(), is(TestIMU.VERSION));
        }
    }
}
