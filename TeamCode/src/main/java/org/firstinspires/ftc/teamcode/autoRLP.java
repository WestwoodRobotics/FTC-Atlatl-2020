package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
//Assumes robot moves 3ft every 5 seconds
//Assumed robot turns 10 degrees every 1 second
@Autonomous(name="AutoRLWP", group="Linear Opmode")
public class autoRLP extends LinearOpMode {


    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        Robot robot = new Robot(hardwareMap);
        waitForStart();
        runtime.reset();


        while (opModeIsActive()) {

            robot.functions.moveleft(14.25);
            robot.functions.pause(.5);
            robot.functions.moveForward(54);
            robot.functions.pause(.5);


            //this block of code shoots
            robot.functions.shootOneRing();
            robot.functions.turnLeftCenter(5.94);
            robot.functions.shootOneRing();
            robot.functions.turnLeftCenter(5.82);
            robot.functions.shootOneRing();

            //parks at white line
            robot.functions.turnRightCenter(11.76);
            robot.functions.pause(.5);
            robot.functions.moveForward(21);



            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}


