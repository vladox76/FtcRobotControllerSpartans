package org.firstinspires.ftc.teamcode.domain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Chasis {

    DcMotor enfrenteDer = null;
    DcMotor enfrenteIzq = null;
    DcMotor atrasDer = null;
    DcMotor atrasIzq = null;

    public Chasis(DcMotor enfrenteDer , DcMotor enfrenteIzq , DcMotor atrasDer , DcMotor atrasIzq){
        this.enfrenteDer = enfrenteDer;
        this.enfrenteIzq = enfrenteIzq;
        this.atrasDer = atrasDer;
        this.atrasIzq = atrasIzq;
    }

    public static double controlesVelocidad (Gamepad gamepad, double velocidad){
        velocidad = (gamepad.a)? 0 : velocidad;
        velocidad = (gamepad.x)? 0.3 : velocidad;
        velocidad = (gamepad.y)? 0.6 : velocidad;
        velocidad = (gamepad.b)? 1 : velocidad;

        return velocidad;
    }

    public void moverseEnfrente(double potencia , int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(pulsos);
        enfrenteIzq.setTargetPosition(pulsos);
        atrasDer.setTargetPosition(pulsos);
        atrasIzq.setTargetPosition(pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(potencia);

        while(enfrenteDer.isBusy() && enfrenteIzq.isBusy() && atrasDer.isBusy() && atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void moverseEnfrente(double potencia){
        enfrenteDer.setPower(potencia);
        enfrenteIzq.setPower(potencia);
        atrasDer.setPower(potencia);
        atrasIzq.setPower(potencia);
    }


    public void moverseAtras(double potencia){
        moverseEnfrente(-potencia);
    }

    public void moverseAtras(double potencia, int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(-pulsos);
        enfrenteIzq.setTargetPosition(-pulsos);
        atrasDer.setTargetPosition(-pulsos);
        atrasIzq.setTargetPosition(-pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(potencia);

        while(enfrenteDer.isBusy() && enfrenteIzq.isBusy() && atrasDer.isBusy() &&
                atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }



    public void girarDerecha(double potencia){
        enfrenteDer.setPower(-potencia);
        enfrenteIzq.setPower(potencia);
        atrasDer.setPower(-potencia);
        atrasIzq.setPower(potencia);
    }

    public void girarDerecha(double potencia, int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(-pulsos);
        enfrenteIzq.setTargetPosition(pulsos);
        atrasDer.setTargetPosition(-pulsos);
        atrasIzq.setTargetPosition(pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(potencia);

        while(enfrenteDer.isBusy() && enfrenteIzq.isBusy() && atrasDer.isBusy() &&
                atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }



    public void girarIzquierda(double potencia){
        girarDerecha(-potencia);
    }

    public void girarIzquierda(double potencia , int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(pulsos);
        enfrenteIzq.setTargetPosition(-pulsos);
        atrasDer.setTargetPosition(pulsos);
        atrasIzq.setTargetPosition(-pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseDerecha(potencia);

        while(enfrenteDer.isBusy() && enfrenteIzq.isBusy() && atrasDer.isBusy() &&
                atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }



    public void moverseEnfIzq(double potencia){
        enfrenteDer.setPower(potencia);
        atrasIzq.setPower(potencia);
    }

    public void moverseEnfIzq(double potencia, int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(pulsos);
        atrasDer.setTargetPosition(pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);;

        moverseEnfIzq(potencia);

        while(enfrenteDer.isBusy()  && atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void moverseEnfDer(double potencia){
        moverseEnfIzq(-potencia);
    }

    public void moverseEnfDer(double potencia, int pulsos){
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteIzq.setTargetPosition(pulsos);
        atrasDer.setTargetPosition(pulsos);

        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);;

        moverseEnfIzq(potencia);

        while(enfrenteIzq.isBusy()  && atrasDer.isBusy()){

        }

        parar();

        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void moverseAtrIzq(double potencia){
        moverseEnfDer(-potencia);
    }

    public void moverseAtrIzq(double potencia, int pulsos){
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteIzq.setTargetPosition(-pulsos);
        atrasDer.setTargetPosition(-pulsos);

        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);;

        moverseEnfIzq(potencia);

        while(enfrenteIzq.isBusy()  && atrasDer.isBusy()){

        }

        parar();

        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void moverseAtrDer(double potencia){
        moverseEnfIzq(potencia);
    }

    public void moverseAtrDer(double potencia , int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(-pulsos);
        atrasDer.setTargetPosition(-pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);;

        moverseEnfIzq(potencia);

        while(enfrenteDer.isBusy()  && atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void moverseDerecha(double potencia){
        enfrenteDer.setPower(-potencia);
        enfrenteIzq.setPower(potencia);
        atrasDer.setPower(potencia);
        atrasIzq.setPower(-potencia);
    }

    public void moverseIzquierda(double potencia){
        moverseDerecha(-potencia);
    }

    public void moverseIzquierda(double potencia , int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(pulsos);
        enfrenteIzq.setTargetPosition(-pulsos);
        atrasDer.setTargetPosition(-pulsos);
        atrasIzq.setTargetPosition(pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(potencia);

        while(enfrenteDer.isBusy() && enfrenteIzq.isBusy() && atrasDer.isBusy() &&
                atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void moverseDerecha(double potencia , int pulsos){
        enfrenteDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        enfrenteDer.setTargetPosition(-pulsos);
        enfrenteIzq.setTargetPosition(pulsos);
        atrasDer.setTargetPosition(pulsos);
        atrasIzq.setTargetPosition(-pulsos);

        enfrenteDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasDer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        atrasIzq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        moverseEnfrente(potencia);

        while(enfrenteDer.isBusy() && enfrenteIzq.isBusy() && atrasDer.isBusy() &&
                atrasIzq.isBusy()){

        }

        parar();

        enfrenteDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        enfrenteIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasDer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        atrasIzq.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public void parar(){
        moverseEnfrente(0);
    }

} 
