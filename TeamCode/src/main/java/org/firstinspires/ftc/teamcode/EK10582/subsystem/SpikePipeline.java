package org.firstinspires.ftc.teamcode.EK10582.subsystem;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class SpikePipeline extends OpenCvPipeline {

    double[] targetBlueRGB = {12, 135, 176};
    double[] targetRedRGB = {156,30,33};


    @Override
    public Mat processFrame(Mat input) {

        Size dimensions = input.size();
        double height = dimensions.height;
        double width = dimensions.width;

        Mat output = input.clone();

        Rect leftRect = new Rect();

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                double[] pixel = output.get(i, j);
                double[] changeColor = {52, 171, 41};
                pixel = compareColor(pixel, targetBlueRGB,changeColor);

                double[] finalPixel = {pixel[0],pixel[1],pixel[2],1};
                output.put(i,j,finalPixel);
            }
        }
        return output;
    }

    public double[] compareColor(double[] cur, double[] targetColor, double[] changeColor) {
        int iterate = 0;
        while (targetColor[iterate] * .8 < cur[iterate] && cur[iterate] < targetColor[iterate] * 1.2) {
            iterate++;
        }
        if(iterate == 2){
            return changeColor;
        }
        return cur;
    }
}


