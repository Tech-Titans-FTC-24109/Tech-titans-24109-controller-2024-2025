package org.firstinspires.ftc.teamcode.actions;

import static org.mockito.Mockito.times;

import org.mockito.Mockito;

public class IActionVerifier {

    public static MethodVerifier verifyNonGetterInteraction(IAction action) {
        return new MethodVerifier(action);
    }

    public static class MethodVerifier {

        private final IAction action;
        private boolean initVerified = false;
        private boolean iterateVerified = false;
        private boolean stopVerified = false;
        public MethodVerifier(IAction action) {
            this.action = action;
        }

        public MethodVerifier init(int wantedNumberOfInvocations) {
            initVerified = true;
            Mockito.verify(action, times(wantedNumberOfInvocations)).init();
            return this;
        }

        public MethodVerifier iterate(int wantedNumberOfInvocations) {
            iterateVerified = true;
            Mockito.verify(action, times(wantedNumberOfInvocations)).iterate();
            return this;
        }

        public MethodVerifier stop(int wantedNumberOfInvocations) {
            stopVerified = true;
            Mockito.verify(action, times(wantedNumberOfInvocations)).stop();
            return this;
        }

        public void noOtherInteractions() {
            if (!initVerified) {
                init(0);
            }
            if (!iterateVerified) {
                iterate(0);
            }
            if (!stopVerified) {
                stop(0);
            }
        }
    }
}
