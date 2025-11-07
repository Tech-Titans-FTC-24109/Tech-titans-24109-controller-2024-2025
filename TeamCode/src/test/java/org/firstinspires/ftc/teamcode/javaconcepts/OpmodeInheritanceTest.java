package org.firstinspires.ftc.teamcode.javaconcepts;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

public class OpmodeInheritanceTest {


    @Test
    @DisplayName("WHEN getting overwritten field EXPECT field value of original field")
    void WHEN_gettingOverwrittenField_EXPECT_fieldValueOfOriginalField() {
        ExtendableOpmode opmode = new MatchOpmode();

        // TODO - which assert is correct
        // a) base class and declared type of variable opmode (ExpendableOpMode)
        assertThat(opmode.getExtendableField(), is("Extendable"));
        // b) actual type of variable opmode (MatchOpmode)
        // assertThat(opmode.getExtendableField(), is(100));
    }

    @Test
    @DisplayName("WHEN getting overwritten field through overridden method EXPECT field value of actual type")
    void WHEN_gettingOverwrittenFieldThroughOverriddenMethod_EXPECT_fieldValueOfActualType() {
        ExtendableOpmode opmode = new MatchOpmode();

        // TODO - which assert is correct
        // a) base class and declared type of variable opmode (ExpendableOpMode)
        // assertThat(opmode.getExtendableField2(), is("Extendable"));
        // b) actual type of variable opmode (MatchOpmode)
         assertThat(opmode.getExtendableField2(), is(100));
    }

    public static class ExtendableOpmode {

        private String extendableField = "Extendable";

        public Object getExtendableField() {
            return extendableField;
        }

        public Object getExtendableField2() {
            return extendableField;
        }
    }

    public static class GameOpmode extends ExtendableOpmode {

        private Boolean extendableField = true;

        @Override
        public Object getExtendableField2() {
            return extendableField;
        }
    }

    public static class MatchOpmode extends GameOpmode {

        private Integer extendableField = Integer.valueOf(100);

        @Override
        public Object getExtendableField2() {
            return extendableField;
        }
    }
}
