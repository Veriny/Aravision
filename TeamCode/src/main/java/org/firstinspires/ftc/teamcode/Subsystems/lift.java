package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import static android.os.SystemClock.sleep;


public class lift {
    public  DcMotor l;
    public  Servo hook;
    static final double     COUNTS_PER_MOTOR_REV = 1440 ;
    static final double DISTANCE_TO_TRAVEL = 5.7;
    public lift(DcMotor lifter, Servo hooker){
        this.l = lifter;
        this.hook = hooker;
        lifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void unhook(){
        l.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorDrive(l, -(COUNTS_PER_MOTOR_REV * DISTANCE_TO_TRAVEL), 1.0);
        jigglypuff(l);
        hook.setPosition(1);
        sleep(300);
    }
    public void ununhook(){
        l.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorDrive(l, (COUNTS_PER_MOTOR_REV * DISTANCE_TO_TRAVEL), 1.0);
        sleep(300);
    }
    public void motorDrive(DcMotor motor, double ticks, double power){
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition((int)ticks);
        motor.setPower(power);
    }

    public void jigglypuff(DcMotor motor){
        while (motor.isBusy()){

        }
    }



}