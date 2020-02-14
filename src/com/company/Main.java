package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int alto = 6; //scanner.nextInt();
        int ancho = 8; //scanner.nextInt();
        int dificultad = 0; //scanner.nextInt();

        int[][] cuentaMinas = new int[alto][ancho];
        boolean[][] tieneMina = new boolean[alto][ancho];
        boolean[][] destapada = new boolean[alto][ancho];

        int totalMinas = 0;
        if(dificultad == 0){
            totalMinas = alto*ancho/6;
        }

        for (int i = 0; i < totalMinas;) {
            int f = random.nextInt(alto);
            int c = random.nextInt(ancho);

            if(!tieneMina[f][c]){
                tieneMina[f][c] = true;

                if(f-1 >= 0){
                    if(c-1 >= 0){
                        cuentaMinas[f-1][c-1]++;
                    }
                    if(c+1 < ancho){
                        cuentaMinas[f-1][c+1]++;
                    }
                    cuentaMinas[f-1][c]++;
                }
                if(f+1 < alto){
                    if(c-1 >= 0){
                        cuentaMinas[f+1][c-1]++;
                    }
                    if(c+1 < ancho){
                        cuentaMinas[f+1][c+1]++;
                    }
                    cuentaMinas[f+1][c]++;
                }
                if(c-1 >= 0){
                    cuentaMinas[f][c-1]++;
                }
                if(c+1 < ancho){
                    cuentaMinas[f][c+1]++;
                }

                i++;
            }
        }

        boolean fin = false;

        while(!fin) {

            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (destapada[i][j]) {
                        System.out.print(tieneMina[i][j] ? "*" : cuentaMinas[i][j] == 0 ? " " : ""+cuentaMinas[i][j]);
                    } else{
                        System.out.print("#");
                    }
                }
                System.out.println();
            }

            int f = scanner.nextInt();
            int c = scanner.nextInt();

            if(tieneMina[f][c]){
                System.out.println("PERDIDO");
            } else {
                destapada[f][c] = true;
            }
        }
    }
}
