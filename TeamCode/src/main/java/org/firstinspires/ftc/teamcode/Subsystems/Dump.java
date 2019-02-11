package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Dump {
    private static final double MAX_POS = 1.0;
    private static final double MIN_POS = 0.0;
    Servo out;
    Servo out1;
    public Dump(Servo o, Servo a) {
        out = o;
        this.out1 = o;
        reset();
    }

    public void c(Gamepad p) {
        if(p.x) release();
        else if (p.y) reset();
    }

    public void release() {
        servoPuff(out, MAX_POS);
        servoPuff(out1, MAX_POS);
    }

    public void reset() {
        servoPuff(out, MIN_POS);
        servoPuff(out1, MIN_POS);
    }
    public void servoPuff(Servo s, double pos) {
        s.setPosition(pos);
        while(s.getPosition() != pos) {

        }
    }
}
