package com.company;

public class Cliente {

    private int idCliente;
    private int tiempoArribo;
    private int tiempoSeAtendio;
    private int tiempoServicio;


    public Cliente(int id,int t_a,int t_s_a,int t_s){
        this.idCliente = id;
        this.tiempoArribo = t_a;
        this.tiempoSeAtendio = t_s_a;
        this.tiempoServicio = t_s;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTiempoArribo() {
        return tiempoArribo;
    }

    public void setTiempoArribo(int tiempoArribo) {
        this.tiempoArribo = tiempoArribo;
    }

    public int getTiempoSeAtendio() {
        return tiempoSeAtendio;
    }

    public void setTiempoSeAtendio(int tiempoSeAtendio) {
        this.tiempoSeAtendio = tiempoSeAtendio;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }

    public void setTiempoServicio(int tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }
}
