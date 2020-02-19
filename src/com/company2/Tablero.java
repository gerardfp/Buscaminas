package com.company2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tablero {
    int alto;
    int ancho;
    int totalMinas;
    int destapadas;
    int casillasSinMina;

    Casilla[][] casillas;

    Tablero(int dificultad) {
        alto = 16;
        ancho = 31;
        totalMinas = 99;
        if (dificultad == 1) {
            alto = 8;
            ancho = 8;
            totalMinas = 10;
        } else if (dificultad == 2) {
            alto = 16;
            ancho = 16;
            totalMinas = 40;
        }

        inicializar();
    }

    Tablero(int alto, int ancho, int totalMinas){
        this.alto = alto;
        this.ancho = ancho;
        this.totalMinas = totalMinas;

        inicializar();
    }

    void inicializar(){
        casillasSinMina = ancho * alto - totalMinas;

        casillas = new Casilla[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                casillas[i][j] = new Casilla(i, j);
            }
        }

        Random random = new Random();

        for (int minasColocadas = 0; minasColocadas < totalMinas; ) {
            int fila = random.nextInt(alto);
            int columna = random.nextInt(ancho);

            if (!tieneMina(fila,columna)) {
                ponerMina(fila,columna);
                minasColocadas++;

                for(Casilla vecina : vecinas(fila, columna)){
                    vecina.cuentaMinas++;
                }
            }
        }
    }

    boolean tieneMina(int fila, int columna){
        return casillas[fila][columna].tieneMina;
    }

    void ponerMina(int fila, int columna){
        casillas[fila][columna].tieneMina = true;
    }

    boolean valida(int fila, int columna){
        return fila >=0 && fila < alto && columna >= 0 && columna < ancho;
    }

    boolean completado(){
        return destapadas == casillasSinMina;
    }

    void destaparTodas(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                casillas[i][j].destapada = true;
            }
        }
    }

    void destapar(int fila, int columna){
        casillas[fila][columna].destapada = true;
        destapadas++;
        if(casillas[fila][columna].cuentaMinas == 0) {
            for (Casilla vecina : vecinas(fila, columna)){
                if (!vecina.destapada && vecina.cuentaMinas == 0) {
                    destapar(vecina.fila, vecina.columna);
                }
            }
        }
    }

    List<Casilla> vecinas(int fila, int columna){
        int[][] vecinas = {
                {fila - 1, columna - 1}, {fila - 1, columna}, {fila - 1, columna + 1},
                {fila    , columna - 1},                      {fila    , columna + 1},
                {fila + 1, columna - 1}, {fila + 1, columna}, {fila + 1, columna + 1},
        };

        List<Casilla> result = new ArrayList<>();

        for (int k = 0; k < vecinas.length; k++) {
            if (valida(vecinas[k][0], vecinas[k][1])) {
                result.add(casillas[vecinas[k][0]][vecinas[k][1]]);
            }
        }
        return result;
    }
}
