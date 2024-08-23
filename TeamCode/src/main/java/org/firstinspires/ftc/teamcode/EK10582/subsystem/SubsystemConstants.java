package org.firstinspires.ftc.teamcode.EK10582.subsystem;

import com.acmerobotics.dashboard.config.Config;

@Config
public class SubsystemConstants {


    public static final double[] servoPos = {0.21, 0.7};

    //MecanumDrive
    public static double SPEED = 0.8;
    public static boolean gyroOn = false;
    public static double targetAngle = 0;

    //Slides
    public static double SLIDES_TICKS_TO_INCHES = 0.010722;
    public static double MAX_SLIDE_HEIGHT = 1632;
    public static double MAX_FEEDFORWARD = 0.2;
    public static double slidesTolerance = 50;
    public enum SlideStates {
        FREE(0), BOTTOM(0), LOW(1115), MEDIUM(1300), ADJUSTABLE(-5);

        public final double position;

        SlideStates(double position) {
            this.position = position;
        }
    }
}
