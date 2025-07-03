package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PidControllerTest {
    @Test
    void makeWithEnum() {
        PidController controller = new PidController(PidControllerParameters.TURNING);
        assertEquals(5 * 0.03, controller.calculatePower(5, 0));
    }

    @Test
    void makeWithBuilder() {
        PidController controller = new PidController.Builder()
                .withKp(0.03)
                .withKd(0)
                .build();
        assertEquals(5 * 0.03, controller.calculatePower(5, 0));
    }
}