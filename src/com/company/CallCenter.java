package com.company;

import java.util.*;

public class CallCenter {

    private int agentesDisp;
    private int cola;
    private int clientesAtend;
    private int tiempoReloj;
    PriorityQueue<Evento> colaPriori = new PriorityQueue<Evento>();
    List<Evento> listaEventos = new LinkedList<>();
    Queue<Cliente> colaClientes = new LinkedList<>();
    List<Cliente> conjuntoClientes = new LinkedList<>();
    private int idCliente = 1;

    public CallCenter() {
        setCola(0);
        clientesAtend = 0;
        tiempoReloj = 0;
        agentesDisp = 2;
        listaEventos.add(new Evento(0,true));
        colaPriori.add(new Evento(0,true));
    }


    private void hangIn() {
        if (this.agentesDisp == 0) {
            setCola(getCola() + 1);
            colaClientes.add(new Cliente(idCliente,tiempoReloj,0,0));
        } else {
            agentesDisp--;
            int ts = this.generarHangOut();
            conjuntoClientes.add(new Cliente(idCliente,tiempoReloj,tiempoReloj,ts));

        }
        idCliente++;
        this.generarHangIn();
    }

    private void hangOut() {
        if (this.getCola() > 0) {
            setCola(getCola() - 1);
            Cliente c = colaClientes.poll();
            int ts = generarHangOut();
            conjuntoClientes.add(new Cliente(c.getIdCliente(),c.getTiempoArribo(),tiempoReloj,ts));

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

    private int generarHangOut() {
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

        return minutoB;
    }

    public Evento obtenerSigEvento(){


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

    public List<Evento> sendListEvent(){
        return listaEventos;
    }

    public List<Cliente> sendListClient(){
        return conjuntoClientes;
    }

    public void limpiar(){
        listaEventos.clear();
        conjuntoClientes.clear();
        colaClientes.clear();
        colaPriori.clear();
    }


    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }
}
