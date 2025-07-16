package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PidControllerTest {
    private static final double KP_VALUE = 0.03;
    private static final double KI_VALUE = 0.1;
    private static final double KD_VALUE = 0.1;
    private static final int ERROR = 2;

    @Test
    @DisplayName("WHEN PidControllerCreatedWithEnum EXPECT ValuesToBeSetInTheController")
    void makeWithEnum() {
        PidController controller = new PidController(PidControllerParameters.TURNING);
        assertEquals(PidControllerParameters.TURNING.getKp(), controller.getKp());
        assertEquals(PidControllerParameters.TURNING.getKi(), controller.getKi());
        assertEquals(PidControllerParameters.TURNING.getKd(), controller.getKd());
    }

    @Test
    @DisplayName("WHEN PidControllerCreatedWithBuilder EXPECT ValuesToBeSetInTheController")
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
    @DisplayName("WHEN PidControllerCreatedWithAllArgsConstructor EXPECT ValuesToBeSetInTheController")
    void makeWithConstructor() {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE, new SpoofedTimeService(500));
        assertEquals(KP_VALUE, controller.getKp());
        assertEquals(KI_VALUE, controller.getKi());
        assertEquals(KD_VALUE, controller.getKd());
    }

    @Test
    @DisplayName("WHEN CalculatePowerCalculatedAfterInterval EXPECT NewerValueToBeBigger")
    void calculatePower() {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE, new SpoofedTimeService(500));
        double value = controller.calculatePower(1);
        assertTrue(value < controller.calculatePower(2));
    }

    @Test
    @DisplayName("WHEN TestingKp EXPECT ValueToBeRight")
    void testKp() {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE, new SpoofedTimeService(500));
        assertEquals(controller.calculatePower(ERROR), KP_VALUE * ERROR);
    }

    @Test
    @DisplayName("WHEN TestingKi EXPECT ValueToBeRight")
    void testKi() {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE, new SpoofedTimeService(500));
        double value = controller.calculatePower(ERROR);
        assertTrue(value < controller.calculatePower(ERROR));
    }

    @Test
    @DisplayName("WHEN TestingKd EXPECT ValueToBeRight")
    void testKd() {
        PidController controller = new PidController(KP_VALUE, KI_VALUE, KD_VALUE, new SpoofedTimeService(500));
        double value = controller.calculatePower(1);
        assertTrue(value < controller.calculatePower(2));
    }
}
