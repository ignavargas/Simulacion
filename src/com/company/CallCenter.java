package com.company;

import java.util.*;

public class CallCenter {

    private int agentesDisp;
    private int cola;
    private int clientesCola;
    private boolean estadoAgentes;
    private int tiempoReloj;
    List<Evento> kistaDeEventos = new ArrayList();
    PriorityQueue<Evento> colaPriori = new PriorityQueue<Evento>();

    public CallCenter() {
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
    }

    private void generarHangOut() {
    }

    public Evento obtenerSigEvento(){

        return colaPriori.poll();

    }
}
