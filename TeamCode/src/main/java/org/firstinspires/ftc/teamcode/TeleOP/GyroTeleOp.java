package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@TeleOp(name = "Gyro Teleop Sensor", group = "Sensor")
public class GyroTeleOp extends OpMode {
    public ModernRoboticsI2cGyro mrGyro;
    public ElapsedTime timer = new ElapsedTime();
    public boolean curState = false;
    public boolean lastState = false;

    @Override
    public void init() {
        mrGyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "mrgyro");

        telemetry.log().add("Gyro is currently calibrating");
        mrGyro.calibrate();

        timer.reset();
        while(mrGyro.isCalibrating()) {
            telemetry.addData("currently calibrating", "%s", Math.round(timer.seconds())%2==0 ? "|.." : "..|");
            telemetry.update();
        }

        telemetry.log().clear();
        telemetry.log().add("Calibrating done");
        telemetry.clear();
        telemetry.update();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        curState = gamepad1.a;
        if(curState != lastState) {
            mrGyro.resetZAxisIntegrator();
        }
        lastState = curState;

        int rawX = mrGyro.rawX();
        int rawY = mrGyro.rawY();
        int rawZ = mrGyro.rawZ();
        int heading = mrGyro.getHeading();
        int integratedZ = mrGyro.getIntegratedZValue();

        AngularVelocity rates = mrGyro.getAngularVelocity(AngleUnit.DEGREES);
        float angleZ = mrGyro.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;

        int offsetZ = mrGyro.getZAxisOffset();
        int scalingCoefficientZ = mrGyro.getZAxisScalingCoefficient();

        telemetry.addLine().addData("dx", rateFormat(rates.xRotationRate))
                .addData("dy", rateFormat(rates.yRotationRate))
                .addData("dz", "%s, deg/s", rateFormat(rates.zRotationRate));
        telemetry.addData("angle", "%s deg", floatFormat(angleZ));
        telemetry.addData("heading", "%3d deg", heading);
        telemetry.addData("integrated Z", "%3d", integratedZ);
        telemetry.addLine().addData("rawX", rawFormat(rawX))
                .addData("rawY", rawFormat(rawY))
                .addData("rawZ", rawFormat(rawZ));
        telemetry.addLine().addData("z offset", offsetZ).addData("z coeff", scalingCoefficientZ);
        telemetry.update();
    }

    @Override
    public void stop() {

    }

    public String rawFormat(int raw) {
        return String.format("%d", raw);
    }

    public String rateFormat(float rate) {
        return String.format("%.3f", rate);
    }

    public String floatFormat(float f) {
        return String.format("%.3f", f);
    }
}
