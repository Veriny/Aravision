package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeArm {
    public static final double MAX_POS = 1.0;
    public static final double MIN_POS = 0;
    public static final double ROTATION_PERCENTAGE = .75;
    public static final double TICKS_PER_ROTATION = 1440;
    public static final double TICKS = ROTATION_PERCENTAGE * TICKS_PER_ROTATION;
    public static final double POWER = 1;
    public DcMotor PseudoServo;
    public Servo s;
    public IntakeArm(DcMotor x, Servo y) {
        this.PseudoServo = x;
        this.s = y;
        PseudoServo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void c(Gamepad p) {

    }

    public void yeet(){
        if (!PseudoServo.isBusy()){
            PseudoServo.setTargetPosition((int) TICKS);
            PseudoServo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            PseudoServo.setPower(POWER);
        }
    }
    public void yoink(){
        if (!PseudoServo.isBusy()){
            PseudoServo.setTargetPosition((int) TICKS);
            PseudoServo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            PseudoServo.setPower(-POWER);
        }
    }
    public void boi(){
        s.setPosition(MAX_POS);
    }
    public void buddy(){
        s.setPosition(MIN_POS);
    }

    public void resetEncoders(){
        PseudoServo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
