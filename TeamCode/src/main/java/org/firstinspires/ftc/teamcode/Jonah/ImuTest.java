package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Jonathan.MecanumWheelsController;
import org.firstinspires.ftc.teamcode.motions.AbstractMotion;
import org.firstinspires.ftc.teamcode.motions.MoveMotion;
import org.firstinspires.ftc.teamcode.motions.SleepMotion;
import org.firstinspires.ftc.teamcode.motions.TurnMotion;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Autonomous(name="imuTest")
//@Disabled
public class ImuTest extends LinearOpMode {

    public static final double ANGLE_ERROR = 2; // degrees

    public IMU imu;

    private ImuUtility imuCalculator;

    private MecanumWheelsController wheels;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new MecanumWheelsController(hardwareMap);
        imu = hardwareMap.get(IMU.class, "imu");
        imuCalculator = new ImuUtility(imu);

        //RIGHT HAND RULE - +90 degrees = left, -90 degrees = right

        waitForStart();

        int motionsIndex = 0;
        List<AbstractMotion> motions = new ArrayList<AbstractMotion>();

        motions.add(createDrive(100));
        motions.add(createSleep(1500));


        while (opModeIsActive() && (motionsIndex < motions.size())) {

            AbstractMotion motion = motions.get(motionsIndex);
            if (!motion.isInitialized()) {
                telemetry.addLine(motion.toString());
                motion.init();
                telemetry.addLine("completed init");
                telemetry.update();
            }
            if (motion.move()) {
                motionsIndex++;
            }
        }
    }

    public TurnMotion createTurn(int angle) {
        return new TurnMotion(imuCalculator, angle, wheels, telemetry);
    }

    public TurnMotion createLeftTurn(int angle) {
        return createTurn(angle);
    }

    public TurnMotion createRightTurn(int angle) {
        return createTurn(-angle);
    }

    public SleepMotion createSleep(int timeSleeping) {
        return new SleepMotion(imuCalculator, timeSleeping, telemetry);
    }
    /**
     * TODO - J & P - provide JavaDoc
     * 
     */
    public MoveMotion createDrive(double distance) {
        return new MoveMotion(imuCalculator, wheels, telemetry, distance);
    }

}

















// =)