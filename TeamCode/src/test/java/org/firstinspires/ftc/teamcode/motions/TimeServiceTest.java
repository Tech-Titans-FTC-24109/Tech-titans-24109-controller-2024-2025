package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TimeServiceTest {
    @Test
    @DisplayName("WHEN RunOnce EXPECT 0")
    void firstTime() {
        TimeService service = new TimeService();
        assertEquals(0, service.getAsLong());
    }

    @Test
    @DisplayName("WHEN RunForTheSecondTime EXPECT NotZero")
    void secondTime() {
        TimeService service = new TimeService() {
            final MockedTimeService mockedService = new MockedTimeService(0, 10);
            @Override
            protected long getCurrentTime() {
                return mockedService.getAsLong();
            }
        };
        long firstValue = service.getAsLong();
        assertEquals(0, service.getAsLong());
    }

    @Test
    @DisplayName("WHEN RunForTheThirdTime EXPECT Bigger")
    void thirdTime() {
        TimeService service = new TimeService() {
            final MockedTimeService mockedService = new MockedTimeService(0, 10, 20);
            @Override
            protected long getCurrentTime() {
                return mockedService.getAsLong();
            }
        };
        service.getAsLong();
        long secondValue = service.getAsLong();
        assertTrue(service.getAsLong() > secondValue);
    }
}