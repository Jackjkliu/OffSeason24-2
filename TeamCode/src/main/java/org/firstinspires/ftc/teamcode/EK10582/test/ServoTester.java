package org.firstinspires.ftc.teamcode.EK10582.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.EK10582.EKLinear;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;

@TeleOp(name="Servo Tester (intakez arm port)")
public class ServoTester extends EKLinear {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        Servo stopper = hardwareMap.get(Servo.class, "stopper");
        double servoPosition = 0.5;
        while (opModeIsActive()) {

            if (gamepad1.left_trigger > .2) {
                servoPosition += .0002;
            }
            else if(gamepad1.right_trigger > .2) {
                servoPosition -= 0.0002;
            }
            if (servoPosition >= 1) {
                servoPosition = 1;
            }
            else if (servoPosition <= 0) {
                servoPosition = 0;
            }
            stopper.setPosition(servoPosition);
            telemetry.addData("Servo Position", servoPosition);
            telemetry.update();
        }



        //robot.update();
    }
}
