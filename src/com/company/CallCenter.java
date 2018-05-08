package com.company;

import java.util.*;

public class CallCenter {

    private int agentesDisp;
    private int cola;
    private int clientesAtend;
    private int tiempoReloj;
    PriorityQueue<Evento> colaPriori = new PriorityQueue<Evento>();
    List<Evento> listaEventos = new LinkedList<>();

    public CallCenter() {
        cola = 0;
        clientesAtend = 0;
        tiempoReloj = 0;
        agentesDisp = 2;
        listaEventos.add(new Evento(0,true));
        colaPriori.add(new Evento(0,true));
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
        clientesAtend++;

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
        listaEventos.add(new Evento(tiempoReloj+minuto,true));
    }

    private void generarHangOut() {
        int minutoB = 0;

        float numAleatorioB = obtenerNumRandom();

        if (numAleatorioB <= 0.10){

            minutoB = 2;
        }else {

            if (numAleatorioB <= 0.35){

                minutoB = 3;
            }else {

                if (numAleatorioB <= 0.75){

                    minutoB = 4;
                }else {

                    if (numAleatorioB <= 0.95){

                        minutoB = 7;
                    }else {

                        minutoB = 10;
                    }
                }
            }
        }


        colaPriori.add(new Evento(tiempoReloj + minutoB, false));
        listaEventos.add(new Evento(tiempoReloj+minutoB,false));
    }

    public Evento obtenerSigEvento(){

        System.out.println(colaPriori.peek().getTiempo() + "  " + cola);
        return colaPriori.poll();

    }

    public void procesarEvento(Evento event){
        if(event.getIdEvento()){
            this.hangIn();
        }else{
            this.hangOut();
        }
    }


    public void compareTime(){
        int tiempoEvento = colaPriori.peek().getTiempo();
        if(tiempoEvento != tiempoReloj){
            tiempoReloj = tiempoEvento;
        }
    }

    private float obtenerNumRandom(){

        float out = 0;
        Random ran = new Random();
        out = ran.nextFloat();
        return out;
    }
}
