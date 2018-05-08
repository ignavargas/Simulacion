package com.company;

import java.util.Comparator;

public class Evento implements Comparable<Evento>{

    private int tiempo = 0;
    private int idHangIn;
    private int idHangOut;

    public Evento() {
        this.idHangIn = this.idHangOut = 0;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setIdHangIn(int idHangIn) {
        this.idHangIn = idHangIn;
    }

    public void setIdHangOut(int idHangOut) {
        this.idHangOut = idHangOut;
    }

    public int getIdHangIn() {
        return this.idHangIn;
    }

    public int getIdHangOut() {
        return this.idHangOut;
    }

    @Override
    public int compareTo(Evento o) {
        return this.tiempo - o.tiempo;
    }
}
