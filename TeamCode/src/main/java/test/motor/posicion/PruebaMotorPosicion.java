package test.motor.posicion;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import test.motor.sinencoder.PruebaMotorSinEncoderConfig;

@Autonomous(name="PruebaMotorPosicion", group="Pushbot")
//@Disabled
public class PruebaMotorPosicion extends LinearOpMode {
    PruebaMotorSinEncoderConfig robot = new PruebaMotorSinEncoderConfig();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap , telemetry);
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)


            telemetry.addData("Motor" , "20% -- 1300p");
            moverseDistanciaMantener(1 , -1500);

            telemetry.update();

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
