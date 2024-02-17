package com.example.meepmeeptesting;

import static java.lang.Thread.sleep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.util.Vector;

public class BlueBottomMeepMeep {

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        RoadRunnerBotEntity myBot = null;

        myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-36,-60, Math.toRadians(90)))
                             /* BBM   .back(25)
                                .forward(10)
                                .splineToConstantHeading(new Vector2d(-54,24),Math.toRadians(-90))
                                .splineToLinearHeading(new Pose2d(-30,8, Math.toRadians(90)),Math.toRadians(0))
                                .turn(Math.toRadians(-90))
                                .lineToConstantHeading(new Vector2d(15,8))
                                .splineToLinearHeading(new Pose2d(40,36,Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(52, 36, Math.toRadians(180)))
                                .forward(6)
                                .lineTo(new Vector2d(46, 60))
                                .lineTo(new Vector2d(60, 60)) */

                              /* RBM  .forward(25)
                                .back(10)
                                .splineToConstantHeading(new Vector2d(-54,-24),Math.toRadians(90))
                                .splineToLinearHeading(new Pose2d(-30,-8, Math.toRadians(90)),Math.toRadians(180))
                                .turn(Math.toRadians(-90))
                                .lineToConstantHeading(new Vector2d(15,-8))
                                .splineToLinearHeading(new Pose2d(40,-36,Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(52, -36, Math.toRadians(180)))
                                .forward(6)
                                .lineTo(new Vector2d(46, -60))
                                .lineTo(new Vector2d(60, -60)) */

                               /* BBR .lineToLinearHeading(new Pose2d(-36,34, Math.toRadians(90)))
                                .turn(Math.toRadians(90))
                                .back(4)
                                .forward(10)
                                .lineToLinearHeading(new Pose2d(-36,8, Math.toRadians(0)))
                                .lineToConstantHeading(new Vector2d(15,8))
                                .splineToLinearHeading(new Pose2d(40,36,Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(52, 30, Math.toRadians(180)))
                                .forward(6)
                                .lineTo(new Vector2d(46, 60))
                                .lineTo(new Vector2d(60, 60))
                                */

                                /* RBR   .lineToLinearHeading(new Pose2d(-36,-34, Math.toRadians(90)))
                                .turn(Math.toRadians(90))
                                .back(4)
                                .forward(10)
                                .lineToLinearHeading(new Pose2d(-36,-8, Math.toRadians(0)))
                                .lineToConstantHeading(new Vector2d(15,-8))
                                .splineToLinearHeading(new Pose2d(40,-36,Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(52, -42, Math.toRadians(180)))
                                .forward(6)
                                .lineTo(new Vector2d(46, -60))
                                .lineTo(new Vector2d(60, -60))*/





                               /*BBL  .strafeLeft(10)
                                .lineToLinearHeading(new Pose2d(-46,38, Math.toRadians(90)))
                                .forward(10)
                                .strafeRight(10)
                                .lineToLinearHeading(new Pose2d(-36,8, Math.toRadians(0)))
                                .lineToConstantHeading(new Vector2d(15,8))
                                .splineToLinearHeading(new Pose2d(40,36,Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(52, 42, Math.toRadians(180)))
                                .forward(6)
                                .lineTo(new Vector2d(46, 60))
                                .lineTo(new Vector2d(60, 60)) */

                             /* RBL   .strafeLeft(10)
                                .lineToLinearHeading(new Pose2d(-46,-38, Math.toRadians(90)))
                                .forward(10)
                                .strafeRight(10)
                                .lineToLinearHeading(new Pose2d(-36,-8, Math.toRadians(0)))
                                .lineToConstantHeading(new Vector2d(15,-8))
                                .splineToLinearHeading(new Pose2d(40,-36,Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(52, -30, Math.toRadians(180)))
                                .forward(6)
                                .lineTo(new Vector2d(46, -60))
                                .lineTo(new Vector2d(60, -60))*/




                                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }

}