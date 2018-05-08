package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        CallCenter cc = new CallCenter();
        int i = 0;
        while(i < 100){
            cc.procesarEvento(cc.obtenerSigEvento());
            cc.compareTime();
            i++;
        }

    }
}
