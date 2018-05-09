package com.company;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {







    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);
        Vista v = new Vista();

        int op = -1;
        int cant = 0;
        int clientes = 1;


        v.showWelcome();
        while(op != 2){
            v.exeSim();
            op = scanner.nextInt();
            if(op > 2 || op==0){
                v.numIncorrecto();
            }else if(op == 2){
                v.bye();
            }else{
                CallCenter cc = new CallCenter();
                v.cantClientes();
                cant = scanner.nextInt();
                clientes = 1;
                while(cc.getClientesAtend() < cant){
                    cc.procesarEvento(cc.obtenerSigEvento());
                    cc.compareTime();

                }
                v.finSim();


                int opDatos = -1;
                while(opDatos !=0) {
                    v.showData();
                    opDatos = scanner.nextInt();
                    if (opDatos == 1) {
                        Iterator<Evento> ite = cc.listaEventos.iterator();
                        while (ite.hasNext()) {
                            Evento e = ite.next();
                            System.out.println("Evento" + "  " + "Tiempo de Reloj");
                            System.out.println(v.escEvento(e.getIdEvento()) + "  " + e.getTiempo());
                        }
                    } else if (opDatos == 2) {

                        Iterator<Cliente> itr = cc.conjuntoClientes.iterator();
                        while (itr.hasNext()) {
                            Cliente c = itr.next();
                            System.out.println("IdCliente" + "              " + "Tiempo de Arribo" + "              " + "Tiempo que fue atendido" + "            " + "Tiempo de servicio");
                            System.out.println(c.getIdCliente() + "                      " + c.getTiempoArribo() + "                             " + c.getTiempoSeAtendio() + "                                  " + c.getTiempoServicio());

                        }
                    } else if (opDatos == 3){
                        System.out.println("Tamano de la cola al finalizar: "+cc.getCola());


                    }else {
                        v.bye();
                        cc.limpiar();



                    }

                }
            }
        }












        /*int i = 0;
        while(i < 100){
            cc.procesarEvento(cc.obtenerSigEvento());
            cc.compareTime();
            i++;
        }
        System.out.println("------------------------------------------------------------------------");

        Iterator<Cliente> itr = cc.conjuntoClientes.iterator();
        while(itr.hasNext()) {
            Cliente o = itr.next();
            System.out.println(o.getIdCliente()+" "+o.getTiempoArribo()+" "+o.getTiempoSeAtendio()+" "+o.getTiempoServicio());
        }*/
    }
}
