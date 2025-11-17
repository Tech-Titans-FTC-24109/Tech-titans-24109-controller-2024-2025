package org.firstinspires.ftc.teamcode.robot.component;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ImuTest {

    @Test
    @DisplayName("WHEN Imu created to useProxy EXPECT a proxy for createProxy")
    void WHEN_imuCreatedToUseProxy_EXPECT_aProxyForCreateProxy() {
        Imu imu = new Imu(TestIMU.createIMU(), true);

        // we cannot call initialize() on a proxy, only on a real IMU
        assertThrows(UnsupportedOperationException.class, () ->
                imu.createProxy().initialize(TestIMU.DEFAULT_PARAMETERS));
    }

    @Test
    @DisplayName("WHEN Imu created to not useProxy EXPECT actual IMU")
    void WHEN_imuCreatedToNotUseProxy_EXPECT_actualImu() {
        Imu imu = new Imu(TestIMU.createIMU(), false);

        // we can call initialize() on a real IMU
        assertTrue(imu.createProxy().initialize(TestIMU.DEFAULT_PARAMETERS));
    }
}
