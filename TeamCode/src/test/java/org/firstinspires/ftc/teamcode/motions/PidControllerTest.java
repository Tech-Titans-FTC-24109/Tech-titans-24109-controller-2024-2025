package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PidControllerTest {
    private static final double KP_VALUE = 0.03;
    private static final double KD_VALUE = 0.0;
    
    @Test
    void makeWithEnum() {
        PidController controller = new PidController(PidControllerParameters.TURNING);
        assertEquals(PidControllerParameters.TURNING.getKp(), controller.getKp());
        assertEquals(PidControllerParameters.TURNING.getKd(), controller.getKd());
    }

    @Test
    void makeWithBuilder() {
        PidController controller = new PidController.Builder()
                .withKp(KP_VALUE)
                .withKd(KD_VALUE)
                .build();
        assertEquals(KP_VALUE, controller.getKp());
        assertEquals(KD_VALUE, controller.getKd());
    }

    @Test
    void makeWithConstructor() {
        PidController controller = new PidController(KP_VALUE, KD_VALUE);
        assertEquals(KP_VALUE, controller.getKp());
        assertEquals(KD_VALUE, controller.getKd());
    }
}
