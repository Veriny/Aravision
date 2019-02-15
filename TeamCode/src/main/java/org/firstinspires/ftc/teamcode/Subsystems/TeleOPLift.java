package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class TeleOPLift {
    public DcMotor lyft;
    public Servo servo;
    public DcMotor uber;
    public static final int LIFT_POWER = 1;
    public static final double MIN_POS = 1;
    public static final double MAX_POS = 0;
    public static final double SHHHHHHH_GOODNIGHT_SWEET_PRINCE = 0;
    public TeleOPLift(DcMotor lift, DcMotor lift2, Servo hooker) {
        this.lyft = lift;
        this.uber = lift2;
        this.servo = hooker;

        stop();
    }
    public void c(Gamepad p){
        if(p.dpad_up){up();}
        else if(p.dpad_down){down();}
        else{off();}
        if(p.a){
            if (servo.getPosition() != MAX_POS){
                maxPos();
            }
            else{
                mixPos();
            }
        }
    }
    public void up(){ lyft.setPower(-LIFT_POWER);
    uber.setPower(LIFT_POWER);}
    public void down() { lyft.setPower(LIFT_POWER);
    uber.setPower(-LIFT_POWER);}//uber.setPower(-LIFT_POWER);}
    public void off() {lyft.setPower(SHHHHHHH_GOODNIGHT_SWEET_PRINCE);
    uber.setPower(SHHHHHHH_GOODNIGHT_SWEET_PRINCE);
    }
    public void servoPuff(double pos) {
        servo.setPosition(pos);
        while (servo.getPosition() != pos) {}
    }
    public void maxPos() {servoPuff(MAX_POS);}
    public void mixPos() {servoPuff(MIN_POS);}
    public void stop() {
        lyft.setPower(0);
    }
}
