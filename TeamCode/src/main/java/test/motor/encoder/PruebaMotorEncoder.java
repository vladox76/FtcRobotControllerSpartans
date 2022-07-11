package test.motor.encoder;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import test.motor.sinencoder.PruebaMotorSinEncoderConfig;

@Autonomous(name="PruebaMotorEncoder", group="Pushbot")
//@Disabled
public class PruebaMotorEncoder extends LinearOpMode {
    PruebaMotorSinEncoderConfig robot = new PruebaMotorSinEncoderConfig();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap , telemetry);
        sleep(1000);
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            robot.motor.setPower(0.3);
            telemetry.addData("Motor" , "30%");
            telemetry.update();
            sleep(3000);

            robot.motor.setPower(1);
            telemetry.addData("Motor" , "100%");
            telemetry.update();
            sleep(3000);

        }
    }

}
