package test.servo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.templates.ConfiguracionHardwareTempl;

@Autonomous(name="PruebaServo", group="Pushbot")
//@Disabled
public class PruebaServo extends LinearOpMode {

    PruebaServoConfig robot = new PruebaServoConfig();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap , telemetry);
        sleep(1000);
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            robot.servo.setPosition(robot.MAX_SERVO);
            telemetry.addData("Posicion:" , "Maximo");
            telemetry.update();
            sleep(3000);

            robot.servo.setPosition(robot.MIN_SERVO);
            telemetry.addData("Posicion:" , "Mínimo");
            telemetry.update();
            sleep(3000);
        }
    }
}
