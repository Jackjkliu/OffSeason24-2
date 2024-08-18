//package org.firstinspires.ftc.teamcode.EK10582.auton.modes;
//
//import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.roadrunner.geometry.Pose2d;
//import com.acmerobotics.roadrunner.geometry.Vector2d;
//import com.acmerobotics.roadrunner.trajectory.Trajectory;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//import org.firstinspires.ftc.teamcode.EK10582.auton.AutonBase;
//import org.firstinspires.ftc.teamcode.EK10582.auton.action.Housing.Dump;
//import org.firstinspires.ftc.teamcode.EK10582.auton.action.MecanumDrive.AngleMove;
//import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;
//import org.firstinspires.ftc.teamcode.EK10582.subsystem.SpikePipeline;
//import org.firstinspires.ftc.teamcode.EK10582.subsystem.SubsystemConstants;
//import org.firstinspires.ftc.teamcode.RoadRunner.trajectorysequence.TrajectorySequence;
//
//@Autonomous(name="RedBottom")
//@Config
//public class RedBottom extends AutonBase {
//
//    @Override
//    public void runOpMode() {
//
//        Pose2d startPos = new Pose2d(-36,-63, Math.toRadians(-90));
//
//        waitForStart();
//        SpikePipeline.SpikePositionsRed pos = SpikePipeline.spikePositionR;
//        robot.openCV.stop();
//        telemetry.addData("pos: ", pos);
//        telemetry.update();
//        robot.aprilTags.init(true);
//        sleep(500);
//        robot.roadRunner.setPoseEstimate(startPos);
//
//        TrajectorySequence traj_pushPixel = robot.roadRunner.trajectorySequenceBuilder(startPos).forward(1).build();
//        TrajectorySequence traj_toBackboard = robot.roadRunner.trajectorySequenceBuilder(startPos).forward(1).build();
//        TrajectorySequence traj_placePixel = robot.roadRunner.trajectorySequenceBuilder(startPos).forward(1).build();
//        TrajectorySequence traj_park = robot.roadRunner.trajectorySequenceBuilder(startPos).forward(1).build();
//        TrajectorySequence traj_altPark = robot.roadRunner.trajectorySequenceBuilder(startPos).forward(1).build();
//        switch (pos) {
//            case LEFT:
//                robot.aprilTags.targetAprilTag = 4;
//                traj_pushPixel = robot.roadRunner.trajectorySequenceBuilder(startPos)
//                        //push pixel
//                        .lineTo(new Vector2d(-50,-38))
//                        .forward(17)
//                        .build();
//                traj_toBackboard = robot.roadRunner.trajectorySequenceBuilder(traj_pushPixel.end())
//                        //under truss
//                        .strafeLeft(16)
//                        .lineTo(new Vector2d(-38,-6))
//                        .lineToConstantHeading(new Vector2d(30,-6))
//
//                        //toBackboard
//                        .splineToLinearHeading(new Pose2d(38,-29, Math.toRadians(180)), Math.toRadians(0))
//                        .build();
//                traj_placePixel = robot.roadRunner.trajectorySequenceBuilder(traj_toBackboard.end())
//                        //place pixel
//                        .lineToSplineHeading(new Pose2d(52, -29, Math.toRadians(180)))
//                        .build();
//                traj_park = robot.roadRunner.trajectorySequenceBuilder(traj_placePixel.end())
//                        .forward(9)
//                        .strafeRight(16)
//                        .back(9)
//                        .build();
//                break;
//            case RIGHT:
//                robot.aprilTags.targetAprilTag = 6;
//                traj_pushPixel = robot.roadRunner.trajectorySequenceBuilder(startPos)
//                        .lineToLinearHeading(new Pose2d(-36,-33, Math.toRadians(180)))
//                        .back(6)
//                        .forward(15)
//                        .build();
//                traj_toBackboard = robot.roadRunner.trajectorySequenceBuilder(traj_pushPixel.end())
//                        //under truss
//                        .lineToLinearHeading(new Pose2d(-30,-6, Math.toRadians(180)))
//                        .lineToLinearHeading(new Pose2d(30,-6, Math.toRadians(180)))
//
//                        //toBoard
//                        .splineToLinearHeading(new Pose2d(45,-42, Math.toRadians(180)), Math.toRadians(0))
//                        .build();
//                traj_placePixel = robot.roadRunner.trajectorySequenceBuilder(traj_toBackboard.end())
//                        .lineToLinearHeading(new Pose2d(52, -42, Math.toRadians(180)))
//                        .build();
//                traj_park = robot.roadRunner.trajectorySequenceBuilder(traj_placePixel.end())
//                        .forward(9)
//                        .strafeRight(30)
//                        .back(11)
//                        .build();
//                break;
//            case MIDDLE:
//                robot.aprilTags.targetAprilTag = 5;
//                traj_pushPixel = robot.roadRunner.trajectorySequenceBuilder(startPos)
//                        .back(32)
//                        .forward(14)
//
//                        .build();
//                traj_toBackboard = robot.roadRunner.trajectorySequenceBuilder(traj_pushPixel.end())
//                        //under truss
//                        .splineToConstantHeading(new Vector2d(-54,-16),Math.toRadians(90))
//                        .splineToLinearHeading(new Pose2d(-30,-8, Math.toRadians(-90)),Math.toRadians(0))
//                        .lineToConstantHeading(new Vector2d(30,-8))
//
//                        //to board
//                        .splineToLinearHeading(new Pose2d(42,-36, Math.toRadians(180)), Math.toRadians(0))
//                        .build();
//                traj_placePixel = robot.roadRunner.trajectorySequenceBuilder(traj_toBackboard.end())
//                        .lineToLinearHeading(new Pose2d(52, -36, Math.toRadians(180)))
//                        .build();
//                traj_park = robot.roadRunner.trajectorySequenceBuilder(traj_placePixel.end())
//                        .forward(9)
//                        .strafeRight(24)
//                        .back(9)
//                        .build();
//                break;
//        }
//
//
//        robot.roadRunner.followTrajectorySequence(traj_pushPixel);
//        sleep(5000);
//        robot.roadRunner.followTrajectorySequence(traj_toBackboard);
//        sleep(50);
//
//        telemetry.addData("poseError", robot.roadRunner.getPoseError(traj_toBackboard.end()));
//        telemetry.update();
//        if(robot.roadRunner.getPoseError(traj_toBackboard.end()) > 3) {
//            traj_altPark = robot.roadRunner.trajectorySequenceBuilder(robot.roadRunner.getPoseEstimate())
//                    .lineToLinearHeading(new Pose2d(38, -16, Math.toRadians(180)))
//                    .lineTo(new Vector2d(56, -16))
//                    .build();
//            robot.roadRunner.followTrajectorySequence(traj_altPark);
//            sleep(50);
//            return;
//        }
//
//        robot.housing.pixelHolderState = SubsystemConstants.PixelHolderStates.DOWN;
//        robot.update();
//        robot.roadRunner.setPoseEstimate(robot.aprilTags.relocalize());
//        telemetry.addData("currentY: ", robot.roadRunner.getPoseEstimate().getY());
//        telemetry.update();
//        sleep(1000);
//
//        robot.roadRunner.followTrajectorySequence(traj_placePixel);
//        sleep(50);
//
//        runAction(new Dump(SubsystemConstants.SlideStates.MEDIUM));
//        sleep(50);
//
//        robot.roadRunner.followTrajectorySequence(traj_park);
//    }
//}