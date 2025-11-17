package org.firstinspires.ftc.teamcode.robot.component;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.qualcomm.robotcore.hardware.IMU;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ImuProxyTest {

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
}
