package org.firstinspires.ftc.teamcode.EK10582.subsystem;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//child class of subsystem
public class Claw extends Subsystem{

    public double openPosLeft;
    public double closePosLeft;
    public double openPosRight;
    public double closePosRight;

    public boolean clawOpen;
    public boolean moveClaw;

    @Override
    public void init(boolean auton){

    }

    @Override
    public void update(boolean auton){
        if (auton) {
            return;
        }
        if(moveClaw){
            if(clawOpen){
                //set servo positions to close from open
                Robot.getInstance().leftClaw.setPosition();
                Robot.getInstance().rightClaw.setPosition();
                clawOpen = false;
            }
            else {
                //set servo positions to open from closed
                Robot.getInstance().leftClaw.setPosition();
                Robot.getInstance().rightClaw.setPosition();
                clawOpen = true;
            }
            moveClaw = false;
        }



    }

    @Override
    public void stop(){

    }

    @Override
    public void printToTelemetry(Telemetry telemetry){
        telemetry.addData("Claw Open: ", clawOpen);

    }

}
