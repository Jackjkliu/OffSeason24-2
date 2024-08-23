package org.firstinspires.ftc.teamcode.EK10582.subsystem;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class SpikePipeline extends OpenCvPipeline {

    public enum SleeveColors{
        ORANGE, GREEN, PURPLE
    }


    public static SpikePositionsBlue spikePositionB = SpikePositionsBlue.NA;
    public static SpikePositionsRed spikePositionR = SpikePositionsRed.NA;

    double[] targetBlueRGB = {127, 227, 235};
    double[] targetYellowRGB = {252, 220, 8};
    double[] targetPinkRGB = {235, 162, 216};
    double[] replacementColor = {0, 255, 0, 1};

    double percentErrorBlue = 0.5;
    double percentErrorYellow = 0.6;
    double percentErrorPink = 0;


    public static int maxBlue = 0;
    public static int maxYellow = 0;
    public static int maxPink = 0;

    Mat output = new Mat();

    @Override
    public Mat processFrame(Mat input) {

        Size dimensions = input.size();
        double height = dimensions.height;
        double width = dimensions.width;



        output = input.clone();


        Rect line1 = new Rect(new Point(width / 3, 0),new Point(2 * width / 3, height));
        Imgproc.rectangle(output, line1, new Scalar(4,233,78),3,8);


        int[] countersBlue = new int[3];
        int[] countersRed = new int[3];

        for (int i = 0; i < 3; i++) { //boxes
            for(int j = 0; j < height; j++){ //height (all rows)
                for(int k = (int) (width * i / 3); k < (width * (i + 1) / 3); k++){ //width (column)
                    double[] currentColor = output.get(j,k); //color of each pixel
                    if(compareColor(targetBlueRGB, currentColor, percentErrorBlue)){
                        output.put(j,k, replacementColor); //if color is target color, change color
                        countersBlue[i]++;
                    }
                    if(compareColor(targetYellowRGB, currentColor,percentErrorYellow)){
                        output.put(j,k, replacementColor); //if color is target color, change color
                        countersRed[i]++;
                    }
                }
            }
        }

        maxPink = 0;
        maxBlue = 0;
        maxYellow = 0;
        for (int i = 1; i < 3; i++) {
            if (countersBlue[i] > countersBlue[maxBlue])
                maxBlue = i;
            if (countersPink[i] > countersRed[maxPink]) //make variables for countersPink and countersYellow
                maxPink = i;
            if()
        }

        switch(maxBlue){ //remember to change the following section of code because theres only one case for each color
            case 0: spikePositionB = SpikePositionsBlue.LEFT;
                break;
            case 1: spikePositionB = SpikePositionsBlue.MIDDLE;
                break;
            case 2: spikePositionB = SpikePositionsBlue.RIGHT;
                break;
        }

        switch(maxYellow){
            case 0: spikePositionR = SpikePositionsRed.LEFT;
                break;
            case 1: spikePositionR = SpikePositionsRed.MIDDLE;
                break;
            case 2: spikePositionR = SpikePositionsRed.RIGHT;
                break;
        }
        switch(maxPink){

        }

        return output;

    }

    public boolean compareColor(double[] targ, double[] cur, double percentError){
        if (Math.abs(targ[0] - cur[0]) < percentError * targ[0] && Math.abs(targ[1] - cur[1]) < percentError*targ[1] && Math.abs(targ[2] - cur[2]) < percentError*targ[2]){
            return true;
        }
        return false;
    }

}
