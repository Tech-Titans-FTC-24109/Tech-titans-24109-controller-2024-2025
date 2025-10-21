package org.firstinspires.ftc.teamcode.game.decode;

public enum Motif {

    PPG(23),
    PGP(22),
    GPP(21),
    Unknown(0);

    private final int aprilTagId = 0;

    // Values for the aprilTagIds can be found at
    // https://ftc-resources.firstinspires.org/ftc/field/apriltag-art
    private Motif(int aprilTagId) {
        // TODO store the aprilTagId
    }

    public int getAprilTagId() {
        // TODO implement
        return 0;
    }

    /**
     * Get a Motif that corresponds to the aprilTagId provided.
     * When the aprilTagId is not used by one of the Motifs return
     * the Unknown Motif
     *
     * @param aprilTagId the aprilTagId for which to get the Motif for
     * @return the Motif that corresponds to the aprilTagId provided, or the
     *      Unknown Motif, when such a Motif does not exist
     */
    public static Motif getByAprilTagId(int aprilTagId) {
        // TODO implement
        // hints:
        //      Motif.values() returns an array Motif[]
        //      you can iterate over an array using a for loop or foreach
        return Unknown;
    }
}
