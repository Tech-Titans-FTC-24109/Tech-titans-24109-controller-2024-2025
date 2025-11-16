package org.firstinspires.ftc.teamcode.game.decode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MotifTest {

    @Test
    @DisplayName("WHEN comparing all Motifs EXPECT them to have different april tag IDs")
    void WHEN_comparingAllMotifs_EXPECT_themToHaveDifferentAprilTagIDs() {
        Map<Integer, Motif> aprilTagIdToMotif = new HashMap<>();
        for (Motif motif : Motif.values()) {
            if (aprilTagIdToMotif.containsKey(motif.getAprilTagId())) {
                int aprilTagId = motif.getAprilTagId();
                fail(motif + " has same april tag ID " + aprilTagId + " as " + aprilTagIdToMotif.get(aprilTagId));
            }
            else {
                aprilTagIdToMotif.put(motif.getAprilTagId(), motif);
            }
        }
        assertThat("Implemented", is("Implemented"));
    }

    @Test
    @DisplayName("WHEN inspecting all known Motifs EXPECT april tag ID != 0")
    void WHEN_inspectingAllMotifs_EXPECT_aprilTagId() {
        for (Motif motif : Motif.values()) {
            if (motif != Motif.Unknown) {
                assertThat(motif.getAprilTagId(), is(not(0)));
            }
        }
    }

    @Test
    @DisplayName("WHEN inspecting Motif Unknown EXPECT april tag ID zero")
    void WHEN_inspectingMotifUnknown_EXPECT_aprilTagIdZero() {
        assertThat(Motif.Unknown.getAprilTagId(), is(0));
    }

    @Test
    @DisplayName("WHEN retrieving Motif by april tag ID EXPECT correct Motif returned")
    void WHEN_retrievingMotifByAprilTagId_EXPECT_correctMotifReturned() {
        for (Motif motif : Motif.values()) {
            assertThat(Motif.getByAprilTagId(motif.getAprilTagId()), is(motif));
        }
    }
}
