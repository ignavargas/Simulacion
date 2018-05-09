package com.company;

import java.util.Iterator;
import java.util.List;

public class Vista {

    public void showWelcome(){
        System.out.println("Bienvenido al sistema de simulación de un CallCenter");
        System.out.println("El sistema cuenta con dos servidores y tanto la tasa de arribos como el tiempo de servicio, sigue una distribución dada por unas tablas.");
    }

    public void exeSim(){
        System.out.println("Desea ejecutar la simulacion: ");
        System.out.println("1. Si");
        System.out.println("2. No");
    }

    public void bye(){
        System.out.println("Hasta pronto!!!");
    }

    public void cantClientes(){
        System.out.println("Digite cuantos clientes desea en la simulacion: ");
    }

    public void numIncorrecto(){
        System.out.println("Numero incorrecto. Solo puede usar 1 o 2.");
    }

    public void finSim(){
        System.out.println("La simulacion ha terminado con exito!!!");
    }

    public void showData(){
        System.out.println("Los datos de la simulacion se dividen en la lista de eventos y la lista de clientes");
        System.out.println("Que lista desea ver: ");
        System.out.println("1. Lista de eventos");
        System.out.println("2. Lista de clientes");
        System.out.println("3. Tamano de cola");
        System.out.println("0. Ninguna");
    }

    public String escEvento(Boolean b){
        String ret = "";
        if (b == true)
            ret = "HangIn";
        else
            ret = "HangOut";
        return ret;
    }




}
