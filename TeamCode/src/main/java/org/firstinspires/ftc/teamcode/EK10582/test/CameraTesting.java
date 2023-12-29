package org.firstinspires.ftc.teamcode.EK10582.test;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.EK10582.auton.AutonBase;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.SpikePipeline;
import org.firstinspires.ftc.teamcode.EK10582.subsystem.SpikePipeline.SpikePositionsBlue;

@Autonomous(name="Camera Testing")
@Config
public class CameraTesting extends AutonBase {

    @Override
    public void runOpMode() {

        waitForStart();


        SpikePositionsBlue pos = SpikePipeline.spikePositionB;

    }
}
