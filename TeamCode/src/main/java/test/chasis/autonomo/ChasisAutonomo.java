package test.chasis.autonomo;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.domain.Chasis;

@Autonomous(name="ChasisAutonomo", group="Pushbot")
//@Disabled
public class ChasisAutonomo extends LinearOpMode {

    ChasisSimpleConfig_1 robot = new ChasisSimpleConfig_1();


    @Override
    public void runOpMode() {
        robot.init(hardwareMap , telemetry);
        Chasis chasis = new Chasis(robot.enfrenteDer , robot.enfrenteIzq , robot.atrasDer , robot.atrasIzq);
        telemetry.update();

        waitForStart();

        chasis.girarIzquierda(0.2);
        sleep(3000);

        chasis.girarIzquierda(0.1 , 1000);

    }

}
