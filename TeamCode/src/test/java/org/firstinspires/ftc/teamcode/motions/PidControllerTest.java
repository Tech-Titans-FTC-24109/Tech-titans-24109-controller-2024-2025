package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PidControllerTest {
    private final double kpValue = 0.03;
    private final double kdValue = 0.0;
    
    @Test
    void makeWithEnum() {
        PidController controller = new PidController(PidControllerParameters.TURNING);
        assertEquals(kpValue, controller.getKp());
        assertEquals(kdValue, controller.getKd());
    }

    @Test
    void makeWithBuilder() {
        PidController controller = new PidController.Builder()
                .withKp(kpValue)
                .withKd(kdValue)
                .build();
        assertEquals(kpValue, controller.getKp());
        assertEquals(kdValue, controller.getKd());
    }
}
