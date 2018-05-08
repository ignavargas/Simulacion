package com.company;

import java.util.*;

public class CallCenter {

    private int agentesDisp;
    private int cola;
    private int clientesCola;
    private boolean estadoAgentes;
    private int tiempoReloj;
    PriorityQueue<Evento> colaPriori = new PriorityQueue<Evento>();

    public CallCenter() {

        estadoAgentes = false;
        tiempoReloj = 0;
        agentesDisp = 0;
    }

    private void hangIn() {
        if (this.agentesDisp == 0) {
            cola++;
        } else {
            agentesDisp--;
            this.generarHangOut();
        }

        this.generarHangIn();
    }

    private void hangOut() {
        if (this.cola > 0) {
            cola--;
            generarHangOut();
        } else {
            agentesDisp++;
        }

    }

    private void generarHangIn() {

        int minuto = 0;
        float numAleatorio = obtenerNumRandom();

        if (numAleatorio <= 0.40){

            minuto = 1;
        }else{

            if (numAleatorio <= 0.75){

                minuto = 2;
            }else{

                minuto = 3;
            }
        }

        colaPriori.add(new Evento(tiempoReloj + minuto, true));
    }

    private void generarHangOut() {
    }

    public Evento obtenerSigEvento(){

        return colaPriori.poll();

    }

    private float obtenerNumRandom(){

        float out = 0;
        Random ran = new Random();
        out = ran.nextFloat();
        return out;
    }
}
