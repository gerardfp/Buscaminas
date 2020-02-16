package com.company;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //                          0              1            2           3               4               5           6               7           8               t              m
        String[] cellColors = {"\033[37;47m","\033[34;47m","\033[32;47m","\033[91;47m","\033[94;47m","\033[31;47m","\033[96;47m","\033[35;47m","\033[37;47m", "\033[30;100m","\033[30;41m"};

        System.out.print("\033\143");

        System.out.println("\n" +
                "  ██████╗ ██╗   ██╗███████╗ ██████╗ █████╗ ███╗   ███╗██╗███╗   ██╗ █████╗ ███████╗\n" +
                "  ██╔══██╗██║   ██║██╔════╝██╔════╝██╔══██╗████╗ ████║██║████╗  ██║██╔══██╗██╔════╝\n" +
                "  ██████╔╝██║   ██║███████╗██║     ███████║██╔████╔██║██║██╔██╗ ██║███████║███████╗\n" +
                "  ██╔══██╗██║   ██║╚════██║██║     ██╔══██║██║╚██╔╝██║██║██║╚██╗██║██╔══██║╚════██║\n" +
                "  ██████╔╝╚██████╔╝███████║╚██████╗██║  ██║██║ ╚═╝ ██║██║██║ ╚████║██║  ██║███████║\n" +
                "  ╚═════╝  ╚═════╝ ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝\n" +
                "\n" +
                "\n" +
                "\n" +
                "                 ╗      ╔═╗╔═╗╔═╗╦ ╦\n" +
                "                 ║      ║╣ ╠═╣╚═╗╚╦╝\n" +
                "                 ╩      ╚═╝╩ ╩╚═╝ ╩ \n" +
                "\n" +
                "                ╔═╗     ╔╦╗╔═╗╦═╗╦╦ ╦╔╦╗\n" +
                "                ╔═╝     ║║║║╣ ║ ║║║ ║║║║\n" +
                "                ╚═╝     ╩ ╩╚═╝╩═╝╩╚═╝╩ ╩\n" +
                "\n" +
                "                ╔═╗     ╦ ╦╔═╗╦═╗╦═╗\n" +
                "                 ═╣     ╠═╣╠═╣╠╦╝║ ║\n" +
                "                ╚═╝     ╩ ╩╩ ╩╩╚═╩═╝\n" +
                "\n" +
                "\n" +
                "\n" +
                "                ╔═╗     ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗\n" +
                "                ║ ║     ╚═╗║  ║ ║╠╦╝║╣ ╚═╗\n" +
                "                ╚═╝     ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝");

        scanner.nextLine();

        System.out.print("\033\143");

        int alto = 25; //scanner.nextInt();
        int ancho = 25; //scanner.nextInt();
        int dificultad = 1; //scanner.nextInt();

        int[][] cuentaMinas = new int[alto][ancho];
        boolean[][] tieneMina = new boolean[alto][ancho];
        boolean[][] destapada = new boolean[alto][ancho];

        int densidad = 8;
        if(dificultad == 2){
            densidad = 7;
        } else if(dificultad == 3){
            densidad = 6;
        }
        int totalMinas = alto*ancho/densidad;

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
            System.out.print("\033\143");
//            System.out.print("   ");
//            for (int i = 0; i < ancho; i++) {
//                System.out.format("%2d ", i);
//            }
//            System.out.println();
//            for (int i = 0; i < alto; i++) {
//                System.out.format("%2d ", i);
//                for (int j = 0; j < ancho; j++) {
//                    if (tieneMina[i][j]) {
//                        System.out.print(cellColors[10] + " * ");
//                    } else{
//                        System.out.print(cellColors[cuentaMinas[i][j]] + " " + cuentaMinas[i][j] + " ");
//                    }
//                }
//                System.out.println("\033[0m");
//            }
//            System.out.println("\033[0m");

            System.out.print("   ");
            for (int i = 0; i < ancho; i++) {
                System.out.format("%2d ", i);
            }
            System.out.println();
            for (int i = 0; i < alto; i++) {
                System.out.format("%2d ", i);
                for (int j = 0; j < ancho; j++) {
                    if (destapada[i][j]) {
                        System.out.print(tieneMina[i][j] ? cellColors[10] + " * " : cellColors[cuentaMinas[i][j]] + " " + cuentaMinas[i][j] + " ");
                    } else{
                        System.out.print(cellColors[9] + " · ");
                    }
                    System.out.print("\033[0m");
                }
                System.out.println("\033[0m");
            }
            System.out.println("\033[0m");


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
                                                            {i - 1, j},
                                            {i    , j - 1},             {i    , j + 1},
                                                            {i + 1, j}
                                    };
//                                    int[][] vecinas = {
//                                            {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
//                                            {i    , j - 1},             {i    , j + 1},
//                                            {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1},
//                                    };

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
