package org.firstinspires.ftc.teamcode.Subsystems;

import org.corningrobotics.enderbots.endercv.OpenCVPipeline;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Vision extends OpenCVPipeline{
    //Declare the Mats
    private Mat yuv = new Mat();
    private Mat binImg = new Mat();
    public Mat processFrame(Mat rgba, Mat gray) {
        //Convert the image to YUV in order to detect gold better
        Imgproc.cvtColor(rgba, yuv, Imgproc.COLOR_RGB2YUV);
        //Create a binary image in which white is the colors that we want and black is where the color we want does not exist
        Core.inRange(yuv, new Scalar(0, 0, 180), new Scalar(0, 80, 255), binImg);
        //Create a structuring element
        Mat strucElement = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5,5), new Point(3,3));
        //Erode and dialate
        Imgproc.erode(binImg, binImg, strucElement);
        Imgproc.dilate(binImg, binImg, strucElement);
        
        return rgba;
    }
}
