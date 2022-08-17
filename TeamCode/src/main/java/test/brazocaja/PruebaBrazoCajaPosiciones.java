package test.brazocaja;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import test.motor.sinencoder.PruebaMotorSinEncoderConfig;

@TeleOp(name="PruebaBrazoCajaPosiciones", group="Pushbot")
//@Disabled
public class PruebaBrazoCajaPosiciones extends LinearOpMode {
    PruebaBrazoCajaPosicionesConfig robot = new PruebaBrazoCajaPosicionesConfig();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap, telemetry);
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        int posicion = 0;
        final int pulsosposicion = 177;

        while(opModeIsActive()){
            telemetry.update();

            //posicion 0
            if (gamepad1.x){
                if (posicion == 1)
                    moverseDistancia(0.5, -pulsosposicion);
                else if (posicion == 2)
                    moverseDistancia(0.5 , -pulsosposicion*2);
                posicion = 0;
            }
            //posicion 1
            else if (gamepad1.y){
                if (posicion == 0)
                    moverseDistanciaMantener(1 , pulsosposicion);
                else if(posicion == 2)
                    moverseDistanciaMantener(1 , -pulsosposicion);
                posicion = 1;
            }
            //posicion 2
            else if (gamepad1.b){
                if (posicion == 0)
                    moverseDistancia(0.5 , pulsosposicion*2);
                else if (posicion == 1)
                    moverseDistancia(0.5 ,pulsosposicion);
                posicion = 2;
            }


        }

        }





    public void moverseDistancia(double potencia , int distance){
        robot.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motor.setTargetPosition(distance);

        robot.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(0.5);

        while(robot.motor.isBusy()){

        }

        pararMotores();

        robot.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void moverseDistanciaMantener(double potencia , int distance){
        robot.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motor.setTargetPosition(distance);

        robot.motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(0.5);

        while(robot.motor.isBusy()){

        }

    }

    public void moverseEnfrente(double potencia){
        robot.motor.setPower(potencia);
    }

    public void pararMotores(){
        robot.motor.setPower(0);
    }

}
