package org.firstinspires.ftc.teamcode.EK10582.auton.action.Housing;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.EK10582.auton.action.Action;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.Robot;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.SubsystemConstants;

public class highDump extends Action {
    ElapsedTime timer = new ElapsedTime();
    @Override
    public void start() {
        timer.reset();
    }
    @Override
    public void update() {
        //structure: raise servo to halfway, switch servo pos, raise servo all the way


        //TODO: Write the actual method; this is the code for dump()
        if(timer.milliseconds() >= SubsystemConstants.timingsForHighDump[2]) {
            isComplete = true;
        }
        else if(timer.milliseconds() >= SubsystemConstants.timingsForHighDump[1]) {
            Robot.getInstance().housing.dumperState = SubsystemConstants.DumperStates.HIGH;
        }
        else if(timer.milliseconds() >= SubsystemConstants.timingsForHighDump[0]) {
            Robot.getInstance().housing.pixelHolderState = SubsystemConstants.PixelHolderStates.UP;
        }
        else if (timer.milliseconds() >= 0) {
            Robot.getInstance().housing.dumperState = SubsystemConstants.DumperStates.MIDDUMP;                                                                     ;
        }
    }
    @Override
    public void end() {

    }
}
