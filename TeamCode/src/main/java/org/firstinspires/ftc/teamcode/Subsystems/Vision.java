package org.firstinspires.ftc.teamcode.Subsystems;

import org.corningrobotics.enderbots.endercv.OpenCVPipeline;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Vision extends OpenCVPipeline{
    public Mat processFrame(Mat rgba, Mat gray) {
        Mat yuv = new Mat();
        Imgproc.cvtcolor(rgba, yuv, Imgproc.RGB);
    }
}
