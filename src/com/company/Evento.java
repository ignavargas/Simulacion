package com.company;

import java.util.Comparator;

public class Evento implements Comparable<Evento>{

    private int tiempo;
    private boolean idEvento;

    public Evento(int t, boolean estado) {

        tiempo = t;
        idEvento = estado;

    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(boolean idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int compareTo(Evento o) {
        return this.tiempo - o.tiempo;
    }
}
