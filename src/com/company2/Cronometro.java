package com.company2;

public class Cronometro {

    long tiempoInicio;
    int duracion;

    void actualizar(){
        if(tiempoInicio == 0) {
            tiempoInicio = System.currentTimeMillis();
        } else {
            duracion = (int) (System.currentTimeMillis() - tiempoInicio)/1000;
        }
    }
}
