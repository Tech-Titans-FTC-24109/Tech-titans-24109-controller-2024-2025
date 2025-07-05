package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PidControllerTest {
    private static final double KP_VALUE_TO_TEST = 0.03;
    private static final double KD_VALUE_TO_TEST = 0.0;
    
    @Test
    void makeWithEnum() {
        PidController controller = new PidController(PidControllerParameters.TURNING);
        assertEquals(PidControllerParameters.TURNING.getKp(), controller.getKp());
        assertEquals(PidControllerParameters.TURNING.getKd(), controller.getKd());
    }

    @Test
    void makeWithBuilder() {
        PidController controller = new PidController.Builder()
                .withKp(KP_VALUE_TO_TEST)
                .withKd(KD_VALUE_TO_TEST)
                .build();
        assertEquals(KP_VALUE_TO_TEST, controller.getKp());
        assertEquals(KD_VALUE_TO_TEST, controller.getKd());
    }

    @Test
    void makeWithConstructor() {
        PidController controller = new PidController(KP_VALUE_TO_TEST, KD_VALUE_TO_TEST);
        assertEquals(KP_VALUE_TO_TEST, controller.getKp());
        assertEquals(KD_VALUE_TO_TEST, controller.getKd());
    }
}
