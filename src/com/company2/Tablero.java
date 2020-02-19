package com.company2;

import java.util.Random;

public class Tablero {
    int alto;
    int ancho;
    int densidad;
    int totalMinas;
    int destapadas;
    int casillasSinMina;

    Casilla[][] casillas;

    Tablero(int dificultad) {

        alto = 3;
        ancho = 3;
        densidad = 8;
        if (dificultad == 2) {
            alto = 8;
            ancho = 8;
            densidad = 7;
        } else if (dificultad == 3) {
            alto = 14;
            ancho = 14;
            densidad = 6;
        }

        totalMinas = alto * ancho / densidad;
        casillasSinMina = ancho * alto - totalMinas;

        casillas = new Casilla[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                casillas[i][j] = new Casilla();
            }
        }

        inicializar();
    }

    void inicializar(){
        Random random = new Random();

        for (int m = 0; m < totalMinas; ) {
            int i = random.nextInt(alto);
            int j = random.nextInt(ancho);

            if (!casillas[i][j].tieneMina) {
                casillas[i][j].tieneMina = true;
                m++;

                int[][] vecinas = {
                        {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                        {i    , j - 1},             {i    , j + 1},
                        {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1},
                };

                for (int k = 0; k < vecinas.length; k++) {
                    int vf = vecinas[k][0];
                    int vc = vecinas[k][1];
                    if (valida(vf, vc)) {
                        casillas[vf][vc].cuentaMinas++;
                    }
                }
            }
        }
    }

    boolean tieneMina(int fila, int columna){
        return casillas[fila][columna].tieneMina;
    }

    void destaparTodas(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                casillas[i][j].destapada = true;
            }
        }
    }

    void destapar(int fila, int columna){
        if(valida(fila, columna) && !casillas[fila][columna].destapada && casillas[fila][columna].cuentaMinas == 0){
            casillas[fila][columna].destapada = true;
            destapadas++;
            int[][] vecinas = {
                    {fila - 1, columna},
                    {fila, columna - 1}, {fila, columna + 1},
                    {fila + 1, columna}
            };
            for (int k = 0; k < vecinas.length; k++) {
                destapar(vecinas[k][0],vecinas[k][1]);
            }
        }
    }

    boolean valida(int fila, int columna){
        return fila >=0 && fila < alto && columna >= 0 && columna < ancho;
    }

    boolean completado(){
        return destapadas == casillasSinMina;
    }

    void mostrar(){
        System.out.print("    ");
        for (int i = 0; i < ancho; i++) {
            System.out.format("\033[90;103m%2d \033[0m", i);
        }
        System.out.println();
        for (int i = 0; i < alto; i++) {
            System.out.format(" \033[90;105m%2d \033[0m", i);
            for (int j = 0; j < ancho; j++) {
                casillas[i][j].mostrar();
            }
            System.out.println();
        }
    }

    void mostrarDebug(){
        System.out.print("   ");
        for (int i = 0; i < ancho; i++) {
            System.out.format("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < alto; i++) {
            System.out.format("%2d ", i);
            for (int j = 0; j < ancho; j++) {
                casillas[i][j].mostrarDebug();
            }
            System.out.println();
        }
        System.out.println();
    }
}
