package test.chasis.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.domain.Chasis;

import java.util.*;

import test.chasis.autonomo.ChasisSimpleConfig_1;

@TeleOp(name="ChasisTeleop", group="Pushbot")

public class ChasisTeleop extends LinearOpMode {

    ChasisSimpleConfig_1 robot = new ChasisSimpleConfig_1();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap , telemetry);
        Chasis chasis = new Chasis(robot.enfrenteDer , robot.enfrenteIzq , robot.atrasDer , robot.atrasIzq);
        telemetry.update();
        double velocidad = 0.3;

        waitForStart();

        while (opModeIsActive()){

            velocidad = chasis.controlesVelocidad(gamepad1 , velocidad);
            telemetry.addData("Velocidad" , velocidad * 100 + "%");
            telemetry.update();

            if (gamepad1.dpad_up)
                chasis.moverseEnfrente(velocidad);
            else if (gamepad1.dpad_down){
                chasis.moverseAtras(velocidad);
            }
            else if (gamepad1.dpad_left){
                chasis.moverseIzquierda(velocidad);
            }
            else if (gamepad1.dpad_right){
                chasis.moverseDerecha(velocidad);
            }
            else if (gamepad1.right_stick_x < -0.7){
                chasis.girarIzquierda(velocidad);
            }
            else if(gamepad1.right_stick_x > 0.7){
                chasis.girarDerecha(velocidad);
            } else {
                chasis.parar();
            }



        }

    }

}
