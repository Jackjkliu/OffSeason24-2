package org.firstinspires.ftc.teamcode.EK10582.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.EK10582.EKLinear;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;

@TeleOp(name="Servo Tester (intake arm port)")
public class ServoTester extends EKLinear {

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        double targetPos1 = 0.5;
        double targetPos2 = 0.5;
        while(opModeIsActive()) {


            targetPos1 += gamepad1.right_stick_y * 0.0001;
            Robot.getInstance().leftClaw.setPosition(targetPos1);


            telemetry.addData("Servo Position", targetPos1);
            telemetry.addData("Servo Position",targetPos2);
            telemetry.update();
            //robot.update();
        }
    }
}
