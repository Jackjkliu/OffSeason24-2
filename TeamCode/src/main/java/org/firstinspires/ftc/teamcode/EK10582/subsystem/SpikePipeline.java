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
        ORANGE, GREEN, PURPLE, NA
    }


    public static SleeveColors sleeveColor = SleeveColors.NA; //setting the default color to NA


    double[] targetOrangeRGB = {127, 227, 235}; //change this
    double[] targetGreenRGB = {252, 220, 8}; //change this
    double[] targetPurpleRGB = {235, 162, 216}; //change this
    double[] replacementColor = {0, 255, 0, 1}; //4th value is a, a is transparency

    double percentErrorOrange = 0.5;
    double percentErrorGreen = 0.6;
    double percentErrorPurple = 0.6;


    Mat output = new Mat();

    @Override
    public Mat processFrame(Mat input) {

        Size dimensions = input.size();
        double height = dimensions.height;
        double width = dimensions.width;



        output = input.clone();


        Rect line1 = new Rect(new Point(width / 3, 0),new Point(2 * width / 3, height));
        Imgproc.rectangle(output, line1, new Scalar(4,233,78),3,8);


        int countersOrange = 0;
        int countersGreen = 0;
        int countersPurple = 0;

        for (int i = 0; i < 3; i++) { //boxes
            for(int j = 0; j < height; j++){ //height (all rows)
                for(int k = (int) (width * i / 3); k < (width * (i + 1) / 3); k++){ //width (column)
                    double[] currentColor = output.get(j,k); //color of each pixel, checks the color of each individual pixel
                    if(compareColor(targetOrangeRGB, currentColor, percentErrorOrange)){
                        output.put(j,k, replacementColor); //if color is target color, change color
                        countersOrange++;
                    }
                    if(compareColor(targetGreenRGB, currentColor,percentErrorGreen)){
                        output.put(j,k, replacementColor); //if color is target color, change color
                        countersGreen++;
                    }
                    if(compareColor(targetPurpleRGB, currentColor, percentErrorPurple)){
                        output.put(j,k, replacementColor); //if color is target color, change color
                        countersPurple++;

                    }
                }
            }
        }
        if(countersOrange > countersGreen && countersOrange > countersPurple){
            sleeveColor = SleeveColors.ORANGE;
        }
        else if(countersGreen > countersPurple && countersGreen > countersOrange){
            sleeveColor = SleeveColors.GREEN;
        }
        else if(countersPurple > countersGreen && countersPurple > countersOrange){
            sleeveColor = SleeveColors.PURPLE;
        }

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
