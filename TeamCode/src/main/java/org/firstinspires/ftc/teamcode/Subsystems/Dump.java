package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Dump {
    private static final double MAX_POS = 1.0;
    private static final double MIN_POS = 0.0;
    Servo out;
    public Dump(Servo o) {
        out = o;
        reset();
    }

    public void c(Gamepad p) {
        if(p.x && !p.y) release();
        else if (p.y) reset();
    }

    public void release() {
        out.setPosition(MAX_POS);
    }

    public void reset() {
        out.setPosition(MIN_POS);
    }
}
