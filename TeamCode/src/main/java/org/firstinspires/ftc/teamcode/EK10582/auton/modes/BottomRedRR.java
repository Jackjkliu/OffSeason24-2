package org.firstinspires.ftc.teamcode.EK10582.auton.modes;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.EK10582.auton.AutonBase;
import org.firstinspires.ftc.teamcode.EK10582.auton.action.MecanumDrive.AngleMove;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.cameraPipeline;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.cameraPipeline.SpikePositionsRed;

@Autonomous(name="BottomRedRR")
@Config
public class BottomRedRR extends AutonBase {

    @Override
    public void runOpMode() {

        waitForStart();

        robot.openCV.init(true);
        SpikePositionsRed pos = cameraPipeline.spikePositionR;

        //close opencv and open apriltags
        robot.openCV.stop();
        sleep(1000);



        telemetry.addData("pos: ", pos);
        telemetry.update();
        sleep(1000);

        switch(pos){
            case RIGHT:
                robot.aprilTags.targetAprilTag = 6;
                robot.aprilTags.init(true);
                robot.aprilTags.update(true);
                telemetry.addData("Seetag: ", robot.aprilTags.seeTag);
                telemetry.update();
                //left case

                break;
            case LEFT:
                //right case

                robot.aprilTags.targetAprilTag = 4;
                robot.aprilTags.init(true);
                robot.aprilTags.update(true);
                telemetry.addData("Seetag: ", robot.aprilTags.seeTag);
                telemetry.update();


                break;
            case MIDDLE:
                //middle case
                robot.aprilTags.targetAprilTag = 5;
                robot.aprilTags.init(true);
                robot.aprilTags.update(true);
                telemetry.addData("Seetag: ", robot.aprilTags.seeTag);
                telemetry.update();

                break;
        }

        telemetry.addData("Seetag for " + robot.aprilTags.targetAprilTag + ": ", robot.aprilTags.seeTag);
        telemetry.update();
        sleep(5000);
    }
}
