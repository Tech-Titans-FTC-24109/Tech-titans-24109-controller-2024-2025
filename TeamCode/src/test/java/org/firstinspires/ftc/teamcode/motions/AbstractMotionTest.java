package org.firstinspires.ftc.teamcode.motions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbstractMotionTest {

    @Test
    @DisplayName("WHEN initializing motion EXPECT motion initialized")
    void WHEN_initializingMotion_EXPECT_motionInitialized() {
        AbstractMotion motion = new TestMotion();

        motion.init();

        assertTrue(motion.isInitialized());
    }

    @Test
    @DisplayName("WHEN initializing motion EXPECT concrete motion initialized")
    void WHEN_initializingMotion_EXPECT_concreteMotionInitialized() {
        AbstractMotion motion = spy(new TestMotion());

        motion.init();

        verify(motion, times(1)).initMotion();
    }

    @Test
    @DisplayName("WHEN initializing motion multiple times EXPECT IllegalStateException")
    void WHEN_initializingMotionMultipleTimes_EXPECT_illegalStateException() {
        AbstractMotion motion = new TestMotion();
        motion.init();

        // init again
        assertThrows(IllegalStateException.class, motion::init);
    }

    @Test
    @DisplayName("WHEN perform move on uninitialized motion EXPECT IllegalStateException")
    void WHEN_performMoveOnUninitializedMotion_EXPECT_illegalStateException() {
        AbstractMotion motion = new TestMotion();

        // start moving
        assertThrows(IllegalStateException.class, motion::move);
    }

    @Test
    @DisplayName("WHEN move does not complete motion EXPECT motion is not complete")
    void WHEN_moveDoesNotCompleteMotion_EXPECT_motionIsNotComplete() {
        AbstractMotion motion = new TestMotion(false);
        motion.init();

        assertFalse(motion.move());
        assertFalse(motion.isCompleted());
    }

    @Test
    @DisplayName("WHEN move completes motion EXPECT motion is completed")
    void WHEN_moveCompletesMotion_EXPECT_motionIsCompleted() {
        AbstractMotion motion = new TestMotion(true);
        motion.init();

        assertTrue(motion.move());
        assertTrue(motion.isCompleted());
    }

    @Test
    @DisplayName("WHEN moving after motion is completed EXPECT motion is completed")
    void WHEN_movingAfterMotionIsCompleted_EXPECT_motionIsCompleted() {
        AbstractMotion motion = new TestMotion(true);
        motion.init();

        motion.move();
        assertTrue(motion.move());
        assertTrue(motion.isCompleted());
    }

    @Test
    @DisplayName("WHEN motion not complete and move called EXPECT performMove called")
    void WHEN_motionNotCompleteAndMoveCalled_EXPECT_performMoveCalled() {
        // It is the concrete subclass (the actual motion) that has to be called
        // to determine whether the motion is complete. It does not really matter
        // what value (true/false) performMove() returns, it just has to be called
        AbstractMotion motion = spy(new TestMotion(true));
        motion.init();
        assertFalse(motion.isCompleted());

        motion.move();

        verify(motion, times(1)).performMove();
    }

    @Test
    @DisplayName("WHEN motion is complete and move called EXPECT performMove never called")
    void WHEN_motionIsCompleteAndMoveCalled_EXPECT_performMoveNeverCalled() {
        AbstractMotion motion = spy(new TestMotion(true));
        motion.init();
        motion.move();
        assertTrue(motion.isCompleted());
        reset(motion);

        // move again
        motion.move();
        verify(motion, never()).performMove();
    }

    public static class TestMotion extends AbstractMotion {

        private final boolean moveResult;

        public TestMotion() {
            this(false);
        }

        public TestMotion(boolean moveResult) {
            this.moveResult = moveResult;
        }

        @Override
        protected void initMotion() {

        }

        @Override
        protected boolean performMove() {
            return this.moveResult;
        }
    }
}

