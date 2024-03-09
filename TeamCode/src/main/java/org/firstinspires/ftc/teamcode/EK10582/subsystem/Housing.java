package org.firstinspires.ftc.teamcode.EK10582.subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot.robot;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Housing extends Subsystem {
    public boolean PixelCondition = false;
    public double curPos = 0;
    public double motorPower;
    public int override = 2;

    public SubsystemConstants.DumperStates dumperState = SubsystemConstants.DumperStates.PRESET;
    public SubsystemConstants.PixelHolderStates pixelHolderState = SubsystemConstants.PixelHolderStates.RIGHT;

    @Override
    public void init(boolean auton) {
        curPos = Robot.getInstance().dSens.getDistance(DistanceUnit.INCH);
        motorPower = Robot.getInstance().intakeSpin.getPower();
    }

    //
    @Override
    public void update(boolean auton) {
        if(Robot.getInstance().dSens.getDistance(DistanceUnit.INCH) + 1 < curPos){
            PixelCondition = true;

            if(auton){
                Robot.getInstance().intakeSpin.setDirection(DcMotorSimple.Direction.REVERSE);
                Robot.getInstance().intakeSpin.setPower(0.1);
            }

            else{
                if(gamepad1.dpad_down && override == 2){
                    override = 1;
                }
                if(gamepad1.dpad_down && override == 1){
                    override = 2;
                }

                if(override == 2){
                    robot.intake.intakeSpeed = 0;
                }
            }

        }

        if(Robot.getInstance().dSens.getDistance(DistanceUnit.INCH) - 1 > curPos){
            PixelCondition = false;

            if(auton){
                Robot.getInstance().intakeSpin.setDirection(DcMotorSimple.Direction.FORWARD);
                Robot.getInstance().intakeSpin.setPower(motorPower);
            }

        }

        Robot.getInstance().dumper.setPosition(dumperState.position);
        Robot.getInstance().pixelHolder.setPosition(pixelHolderState.position);
    }

    @Override
    public void stop() {

    }

    @Override
    public void printToTelemetry(Telemetry telemetry) {
        telemetry.addData("ClawPos: ", Robot.getInstance().pixelHolder.getPosition());
        telemetry.addData("Dumper: ", Robot.getInstance().dumper.getPosition());
        telemetry.addData("Pixel in housing", PixelCondition);
    }
    
}


