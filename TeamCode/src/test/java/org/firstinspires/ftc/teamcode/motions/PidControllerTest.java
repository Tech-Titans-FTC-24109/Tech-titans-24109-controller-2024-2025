package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import static java.lang.Thread.sleep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PidControllerTest {
    private static final double KP_VALUE = 0.03;
    private static final double KI_VALUE = 0.1;
    private static final double KD_VALUE = 0.1;
    private static final int ERROR = 2;

    @Test
    @DisplayName("WHEN_PidControllerCreatedWithEnum_EXPECT_ValuesToBeSetInTheController")
    void makeWithEnum() {
        PidController controller = new PidController(PidControllerParameters.TURNING);
        assertEquals(PidControllerParameters.TURNING.getKp(), controller.getKp());
        assertEquals(PidControllerParameters.TURNING.getKi(), controller.getKi());
        assertEquals(PidControllerParameters.TURNING.getKd(), controller.getKd());
    }

    @Test
    @DisplayName("WHEN_PidControllerCreatedWithBuilder_EXPECT_ValuesToBeSetInTheController")
    void makeWithBuilder() {
        PidController controller = new PidController.Builder()
                .withKp(KP_VALUE)
                .withKi(KI_VALUE)
                .withKd(KD_VALUE)
                .build();
        assertEquals(KP_VALUE, controller.getKp());
        assertEquals(KI_VALUE, controller.getKi());
        assertEquals(KD_VALUE, controller.getKd());
    }

    @Test
    @DisplayName("WHEN_PidControllerCreatedWithAllArgsConstructor_EXPECT_ValuesToBeSetInTheController")
    void makeWithConstructor() {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE);
        assertEquals(KP_VALUE, controller.getKp());
        assertEquals(KI_VALUE, controller.getKi());
        assertEquals(KD_VALUE, controller.getKd());
    }

    @Test
    @DisplayName("WHEN_CalculatePowerCalculatedAfterInterval_EXPECT_NewerValueToBeBigger")
    void calculatePower() throws InterruptedException {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE);
        double value = controller.calculatePower(1);
        sleep(250);
        assertTrue(value < controller.calculatePower(1));
    }

    @Test
    @DisplayName("WHEN_TestingKp_EXPECT_ValueToBeRight")
    void testKp() {
        PidController controller = new PidController(KP_VALUE, 0, 0);
        assertEquals(controller.calculatePower(ERROR), KP_VALUE * ERROR);
    }

    @Test
    @DisplayName("WHEN_TestingKi_EXPECT_ValueToBeRight")
    void testKi() throws InterruptedException {
        PidController controller = new PidController(0, KI_VALUE, 0);
        double value = controller.calculatePower(ERROR);
        sleep(500);
        assertTrue(value < controller.calculatePower(ERROR));
    }

    @Test
    @DisplayName("WHEN_TestingKd_EXPECT_ValueToBeRight")
    void testKd() throws InterruptedException {
        PidController controller = new PidController(0, 0, KD_VALUE);
        double value = controller.calculatePower(1);
        sleep(500);
        assertTrue(value > controller.calculatePower(2));
    }
}
