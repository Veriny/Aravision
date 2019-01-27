package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by your mom on 9/9/18.
 */

public class WestCoast {
    public DcMotor rightMotorOne;
    public DcMotor leftMotorOne;
    public DcMotor rightMotorTwo;
    public DcMotor leftMotorTwo;
    static final double COUNTS_PER_MOTOR_REV = 1440;
    static final double DRIVE_GEAR_REDUCTION = 1.0;
    static final double WHEEL_DIAMETER_INCHES = 4.0;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);
    static final double BOT_CIRCUMFERENCE = (17.5 * Math.PI);
    static final double DEGREES_PER_INCH = 360 / (BOT_CIRCUMFERENCE);


    public WestCoast(DcMotor rightOne, DcMotor rightTwo, DcMotor leftOne, DcMotor leftTwo) {
        this.rightMotorOne = rightOne;
        this.rightMotorTwo = rightTwo;
        this.leftMotorTwo = leftTwo;
        this.leftMotorOne = leftOne;
        rightMotorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotorOne.setDirection(DcMotor.Direction.REVERSE);
        leftMotorTwo.setDirection(DcMotor.Direction.REVERSE);
    }

//    public void drive(Gamepad gp) {
//        double power = gp.left_stick_y;
//        double turn = -gp.right_stick_x;
//
//        rightMotorOne.setPower(power+turn);
//        rightMotorTwo.setPower(power+turn);
//        leftMotorOne.setPower(power+turn);
//        rightMotorOne.setPower(power+turn);
//    }

    public void stop() {
        rightMotorOne.setPower(0);
        rightMotorTwo.setPower(0);
        leftMotorOne.setPower(0);
        leftMotorTwo.setPower(0);
    }

    public void motorDrive(DcMotor motor, double ticks, double power) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition((int) ticks);
        motor.setPower(power);
    }


    public void goGoGadgetBot(double position, double power, Telemetry telemetry) {
        resetEncoders();
        position = position - (position * 0.16);
        double totalRotations = COUNTS_PER_INCH * position;
        motorDrive(rightMotorTwo, totalRotations, power);
        motorDrive(leftMotorTwo, totalRotations, power);
        motorDrive(rightMotorOne, totalRotations, power);
        motorDrive(leftMotorOne, totalRotations, power);
        telemetry.addData("Total Rotations", totalRotations);
        telemetry.update();
        jigglypuff();
        resetEncoders();
    }

    public void turnTo(double degrees, double power, Telemetry telemetry) {
        resetEncoders();
        double position = (BOT_CIRCUMFERENCE) * (degrees / 360);
        position = position - (position * 0.16);
        double totalRotations = COUNTS_PER_INCH * position;
        motorDrive(rightMotorOne, -totalRotations, power);
        motorDrive(rightMotorTwo, -totalRotations, power);
        motorDrive(leftMotorTwo, totalRotations, power);
        motorDrive(leftMotorOne, totalRotations, power);
        telemetry.addData("Total Tururntations", totalRotations);
        telemetry.update();
        jigglypuff();
        resetEncoders();
    }

    public void resetEncoders() {
        rightMotorTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void jigglypuff() {
        while (rightMotorOne.isBusy() || rightMotorTwo.isBusy() || leftMotorOne.isBusy() || leftMotorTwo.isBusy()) {
        }
    }

    public void servoPuff(Servo servo, double finalPosition) {
        servo.setPosition(finalPosition);
        while (servo.getPosition() != finalPosition) {

        }
    }
}
