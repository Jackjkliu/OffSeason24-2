package org.firstinspires.ftc.teamcode.EK10582.test;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.EK10582.EKLinear;
import org.firstinspires.ftc.teamcode.EK10582.auton.AutonBase;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Housing;


@Autonomous(name = "ditanceSensor Test")
public class distanceSensorTest extends AutonBase {

    @Override
    public void runOpMode(){
        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Distance Sensor Reading", Robot.getInstance().dSens.getDistance(DistanceUnit.INCH));
            telemetry.addData("Distance Sensor Pixel in housing conidition", Robot.getInstance().housing.PixelCondition);
        }
    }
}
