package org.firstinspires.ftc.teamcode.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Dump;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeArm;
import org.firstinspires.ftc.teamcode.Subsystems.TeleOPLift;
import org.firstinspires.ftc.teamcode.Subsystems.WestCoast;


/**
 * Created by JUSTIN on 9/9/18.
 */
@TeleOp(name="Ỳ̙̜͕̤U̯͍H̫̝̱̘ ̛ͅY̭͓̦͈E̘E̥̙͚̞͉̮͘E͝E̠T͉̲̤̫͚̞\n", group = "DrivetrainTests")
public class WestCoastTeleOP extends OpMode {
    public WestCoast robot;
    public TeleOPLift lift;
    public IntakeArm inArm;
    public Intake inSystem;
    public Dump dumptruck;

    @Override
    public void init() {
        robot = new WestCoast(hardwareMap.dcMotor.get("rFront"), hardwareMap.dcMotor.get("rBack"), hardwareMap.dcMotor.get("lFront"), hardwareMap.dcMotor.get("lBack"));
        lift = new TeleOPLift(hardwareMap.dcMotor.get("lift"), hardwareMap.servo.get("hooker"));
        inArm = new IntakeArm(hardwareMap.dcMotor.get("pseudoArm"), hardwareMap.servo.get("arm"));
        inSystem = new Intake(hardwareMap.dcMotor.get("brush"));
        dumptruck = new  Dump(hardwareMap.servo.get("output"));

        robot.stop();
    }

    @Override
    public void start() {
        super.start();
        telemetry.addLine("Yought");
    }

    @Override
    public void loop() {
        robot.rightMotorOne.setPower((gamepad1.left_stick_y + gamepad1.right_stick_x));
        robot.leftMotorOne.setPower((gamepad1.left_stick_y - gamepad1.right_stick_x));
        robot.rightMotorTwo.setPower((gamepad1.left_stick_y + gamepad1.right_stick_x));
        robot.leftMotorTwo.setPower((gamepad1.left_stick_y - gamepad1.right_stick_x));
        lift.c(gamepad2);
        inArm.c(gamepad1);
        inSystem.c(gamepad1);
        dumptruck.c(gamepad2);
    }

    public void stop() {
        robot.stop();
        lift.stop();
        inArm.stop();
        inSystem.stop();
        dumptruck.reset();
    }
}
