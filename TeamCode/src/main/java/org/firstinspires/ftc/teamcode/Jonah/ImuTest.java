package org.firstinspires.ftc.teamcode.Jonah;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

import java.security.KeyPairGenerator;

@Autonomous(name="myTest")
//@Disabled
public class ImuTest extends LinearOpMode {
    public IMU imu;

    @Override
    public void runOpMode() throws InterruptedException {
        initHardware();
        while (!isStarted()) {

            imu.resetYaw();

            IMU.Parameters myIMUparameters;

            myIMUparameters = new IMU.Parameters(
                    new RevHubOrientationOnRobot(
                            new Orientation(
                                    AxesReference.INTRINSIC,
                                    AxesOrder.ZYX,
                                    AngleUnit.DEGREES,
                                    0,
                                    0,
                                    -90,
                                    0  // acquisitionTime, not used
                            )
                    )
            );

            // Initialize IMU directly

            imu.initialize(
                    new IMU.Parameters(
                            new RevHubOrientationOnRobot(
                                    RevHubOrientationOnRobot.LogoFacingDirection.UP,
                                    RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                            )
                    )
            );

            YawPitchRollAngles orientation;
            orientation = imu.getRobotYawPitchRollAngles();

            double Yaw = orientation.getYaw(AngleUnit.DEGREES);
            double Pitch = orientation.getPitch(AngleUnit.DEGREES);
            double Roll = orientation.getRoll(AngleUnit.DEGREES);

            telemetry.addData("Yaw (IMU)", Yaw);
            telemetry.addData("Pitch (IMU)", Pitch);
            telemetry.addData("Roll (IMU)", Roll);


        }
        waitForStart();
        while (opModeIsActive()) {
        }
    }

    public void initHardware() {

    }
    public int lineCount = 125; //useless
    //(but secretly useful...shhhhh! {:]=|=<  0:::|;;;;;;;;;;;;>  };|)::I::|<)
}

//we
//have
//83
//lines
//of
//code










//94....










//do you see this....

















//the winning lottery number is 119835