package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Intake {
    private static final double POWER = 1.0;
    private DcMotor brush;
    public Intake(DcMotor b) {
        brush = b;

        stop();
    }

    public void c(Gamepad p) {
        boolean toggle = true;
        if(p.left_trigger > 0.1) {
            if(toggle) toggle = false;
            else toggle = true;
        }
        if(p.left_bumper && !p.right_bumper) {
            if(toggle) in();
            else out();
        } else if (p.right_bumper && !p.left_bumper && toggle) {
            if(toggle) out();
            else in();
        }
    }

    public void in() {
        brush.setPower(POWER);
    }

    public void out() {
        brush.setPower(-POWER);
    }

    public void stop() {
        brush.setPower(0);
    }
}
