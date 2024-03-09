//package org.firstinspires.ftc.teamcode.EK10582.subsystem;
//
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
//import static org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot.robot;
//
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.Gamepad;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//import org.firstinspires.ftc.teamcode.EK10582.teleop.DriverStation;
//
//public class housingDistanceSensor extends Subsystem{
//    public boolean PixelCondition = false;
//    public double curPos = 0;
//    public double motorPower;
//    public int override = 2;
//
//    @Override
//    public void init(boolean auton){
//        curPos = Robot.getInstance().dSens.getDistance(DistanceUnit.INCH);
//        motorPower = Robot.getInstance().intakeSpin.getPower();
//    }
//
//    public void update(boolean auton){
//        if(Robot.getInstance().dSens.getDistance(DistanceUnit.INCH) + 1 < curPos){
//            PixelCondition = true;
//
//            if(auton){
//                Robot.getInstance().intakeSpin.setDirection(DcMotorSimple.Direction.REVERSE);
//                Robot.getInstance().intakeSpin.setPower(0.1);
//            }
//
//            else{
//                if(gamepad1.dpad_down && override == 2){
//                    override = 1;
//                }
//                if(gamepad1.dpad_down && override == 1){
//                    override = 2;
//                }
//
//                if(override == 2){
//                    robot.intake.intakeSpeed = 0;
//                }
//            }
//
//        }
//
//        if(Robot.getInstance().dSens.getDistance(DistanceUnit.INCH) - 1 > curPos){
//            PixelCondition = false;
//
//            if(auton){
//                Robot.getInstance().intakeSpin.setDirection(DcMotorSimple.Direction.FORWARD);
//                Robot.getInstance().intakeSpin.setPower(motorPower);
//            }
//
//        }
//    }
//
//    @Override
//    public  void stop(){
//
//    }
//
//
//    public void printToTelemetry(Telemetry telemetry){
//        telemetry.addData("Pixel in housing", PixelCondition);
//    }
//
//}
