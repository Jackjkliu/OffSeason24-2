package org.firstinspires.ftc.teamcode.EK10582.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.EK10582.subsystem.Claw;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;
//driver station is only for getting buttons on the gamepad
@Config
class JoystickConstants {
    public static double DEADZONE = 0.01;
    public static double minJoystick = 0.1;
    public static double maxJoystick = 1;
}

public class DriverStation {
    Gamepad gamepad1, gamepad2;

    public DriverStation(Gamepad gamepad1, Gamepad gamepad2) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }

    //-----------------------first controller------------------------------
 
    public double getYVel() {
        return -filterJoystick(gamepad1.left_stick_y);
    }

    public double getXVel() {
        return filterJoystick(gamepad1.left_stick_x);
    }

    public double getRotVel() {
        return filterJoystick(gamepad1.right_stick_x);
    }


    boolean lateRightBump = false;
    public boolean slowMode(){
        boolean out;
        out = gamepad1.right_bumper && !lateRightBump;
        lateRightBump = gamepad1.right_bumper;
        return out;
    }

    //-----------------------second controller-----------------------------

    boolean lateA2 = false;
    public boolean getGamepad2A(){
        boolean out;
        out = gamepad2.a && !lateA2;
        lateA2 = gamepad2.a;
        return out;
    }

    public double getSlidePower(){
        return -filterJoystick(gamepad2.left_stick_y);
    }

    ElapsedTime droneButtonDown = new ElapsedTime();
    boolean droneButtonLate = false;
    boolean droneRelease = false;
    boolean droneReleaseLate = false;
    public boolean getDroneDown() {
        if(gamepad1.y && !droneButtonLate) {
            droneButtonDown.reset();
        }
        if(!gamepad1.y) {
            droneButtonDown.reset();
        }
        droneButtonLate = gamepad1.y;

        if(droneButtonDown.milliseconds() > 1000) {
            droneRelease = true;
        } else {
            droneRelease = false;
        }
        boolean out = droneRelease && !droneReleaseLate;
        droneReleaseLate = droneRelease;
        return out;
    }

    public double filterJoystick(double input) {
        //implements both deadzone and scaled drive
        if(Math.abs(input) < JoystickConstants.DEADZONE) return 0;
        if(input > 0) {
            return JoystickConstants.minJoystick * Math.pow((JoystickConstants.maxJoystick / JoystickConstants.minJoystick), input);
        } else {
            input *= -1;
            return -JoystickConstants.minJoystick * Math.pow((JoystickConstants.maxJoystick / JoystickConstants.minJoystick), input);
        }
    }
}
