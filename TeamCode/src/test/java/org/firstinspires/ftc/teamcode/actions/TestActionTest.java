package org.firstinspires.ftc.teamcode.actions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestActionTest {

    @Test
    @DisplayName("WHEN created EXPECT not initialized/finished/stopped")
    void WHEN_created_EXPECT_notInitializedFinishedStopped() {
        IAction action = new TestAction(1);

        assertFalse(action.isInitialized());
        assertFalse(action.isFinished());
        assertFalse(action.isStopped());
    }

    @Test
    @DisplayName("WHEN initialized EXPECT initialized, not finished/stopped")
    void WHEN_initialized_EXPECT_initializedNotFinishedStopped() {
        IAction action = new TestAction(1);
        assertTrue(action.init());

        assertTrue(action.isInitialized());
        assertFalse(action.isFinished());
        assertFalse(action.isStopped());
    }

    @Test
    @DisplayName("WHEN initialize twice EXPECT IllegalStateException")
    void WHEN_initializeTwice_EXPECT_illegalStateException() {
        IAction action = new TestAction(1);
        action.init();

        assertThrows(IllegalStateException.class, action::init);
    }

    @Test
    @DisplayName("WHEN iterate before initialized EXPECT IllegalStateException")
    void WHEN_iterateBeforeInitialized_EXPECT_illegalStateException() {
        IAction action = new TestAction(1);
        assertThrows(IllegalStateException.class, action::iterate);
    }
    
    @Test
    @DisplayName("WHEN iterate EXPECT not finished/stopped")
    void WHEN_iterate_EXPECT_notFinishedStopped() {
        IAction action = new TestAction(2);
        action.init();

        assertTrue(action.iterate());
        assertFalse(action.isFinished());
        assertFalse(action.isStopped());
    }
    
    @Test
    @DisplayName("WHEN iterate(2) EXPECT finished/stopped")
    void WHEN_iterate2_EXPECT_finishedStopped() {
        IAction action = new TestAction(2);
        action.init();
        action.iterate();

        assertFalse(action.iterate());
        assertTrue(action.isFinished());
        assertTrue(action.isStopped());
    }

    @Test
    @DisplayName("WHEN init while finished EXPECT IllegalStateException")
    void WHEN_initWhileFinished_EXPECT_illegalStateException() {
        IAction action = new TestAction(1);
        action.init();
        assertFalse(action.iterate());

        assertThrows(IllegalStateException.class, action::init);
    }

    @Test
    @DisplayName("WHEN iterate while finished EXPECT IllegalStateException")
    void WHEN_iterateWhileFinished_EXPECT_IllegalStateException() {
        IAction action = new TestAction(1);
        action.init();
        assertFalse(action.iterate());

        assertThrows(IllegalStateException.class, action::iterate);
    }

    @Test
    @DisplayName("WHEN stopping while not finished EXPECT stopped")
    void WHEN_stoppingWhileNotFinished_EXPECT_stopped() {
        IAction action = new TestAction(2);
        action.init();
        action.iterate();

        assertFalse(action.isStopped());
        assertTrue(action.stop());
        assertTrue(action.isStopped());
    }

    @Test
    @DisplayName("WHEN iterate while stopped EXPECT IllegalStateException")
    void WHEN_iterateWhileStopped_EXPECT_illegalStateException() {
        IAction action = new TestAction(2);
        action.init();
        action.iterate();
        action.stop();

        assertThrows(IllegalStateException.class, action::iterate);
    }
}
