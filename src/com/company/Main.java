package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int alto = 3; //scanner.nextInt();
        int ancho = 3; //scanner.nextInt();
        int dificultad = 0; //scanner.nextInt();

        int[][] cuentaMinas = new int[alto][ancho];
        boolean[][] tieneMina = new boolean[alto][ancho];
        boolean[][] destapada = new boolean[alto][ancho];

        int totalMinas = 0;
        if(dificultad == 0){
            totalMinas = alto*ancho/6;
        }

        for (int m = 0; m < totalMinas;) {
            int i = random.nextInt(alto);
            int j = random.nextInt(ancho);

            if(!tieneMina[i][j]){
                tieneMina[i][j] = true;
                m++;

                int[][] vecinas = {
                        {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                        {i    , j - 1},             {i    , j + 1},
                        {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1},
                };

                for (int k = 0; k < vecinas.length; k++) {
                    int vf = vecinas[k][0];
                    int vc = vecinas[k][1];
                    if (vf >= 0 && vf < alto && vc >= 0 && vc < ancho) {
                        cuentaMinas[vf][vc]++;
                    }
                }


            }
        }

        int destapadas = 0;
        int casillasSinMina = ancho*alto-totalMinas;
        boolean gameOver = false;

        while(true) {

            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (tieneMina[i][j]) {
                        System.out.print("*");
                    } else{
                        System.out.print(cuentaMinas[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.println();

            System.out.println(gameOver ? ":(" : ":)");
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (destapada[i][j]) {
                        System.out.print(tieneMina[i][j] ? "*" : cuentaMinas[i][j] == 0 ? "." : ""+cuentaMinas[i][j]);
                    } else{
                        System.out.print("#");
                    }
                }
                System.out.println();
            }

            if(gameOver || destapadas == casillasSinMina) break;


            int f = scanner.nextInt();
            int c = scanner.nextInt();

            if(f >= alto || c >= ancho) continue;

            if(tieneMina[f][c]){
                gameOver = true;
                for (int i = 0; i < alto; i++) {
                    for (int j = 0; j < ancho; j++) {
                        destapada[i][j] = true;
                    }
                }
            } else {
                destapada[f][c] = true;
                destapadas++;
                if(cuentaMinas[f][c] == 0){
                    boolean destapoAlguna = true;
                    while(destapoAlguna) {
                        destapoAlguna = false;

                        for (int i = 0; i < alto; i++) {
                            for (int j = 0; j < ancho; j++) {
                                if (destapada[i][j] && cuentaMinas[i][j] == 0) {
                                    int[][] vecinas = {
                                            {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                                            {i    , j - 1},             {i    , j + 1},
                                            {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1},
                                    };

                                    for (int k = 0; k < vecinas.length; k++) {
                                        int vf = vecinas[k][0];
                                        int vc = vecinas[k][1];
                                        if (vf >= 0 && vf < alto && vc >= 0 && vc < ancho && !destapada[vf][vc] && cuentaMinas[vf][vc] == 0) {
                                            destapada[vf][vc] = true;
                                            destapadas++;
                                            destapoAlguna = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
