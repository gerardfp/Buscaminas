package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        File file = new File("scores.txt");
        boolean debug = false;


        //                          0              1            2           3               4               5           6               7           8               t              m
        String[] cellColors = {"\033[37;47m", "\033[34;47m", "\033[32;47m", "\033[91;47m", "\033[94;47m", "\033[31;47m", "\033[96;47m", "\033[35;47m", "\033[37;47m", "\033[30;100m", "\033[30;41m"};

        while (true) {
            System.out.print("\033\143");

            System.out.println("\n\033[44;97m" +
                    "                                                                                    \n" +
                    "  ██████╗ ██╗   ██╗███████╗ ██████╗ █████╗ ███╗   ███╗██╗███╗   ██╗ █████╗ ███████╗ \n" +
                    "  ██╔══██╗██║   ██║██╔════╝██╔════╝██╔══██╗████╗ ████║██║████╗  ██║██╔══██╗██╔════╝ \n" +
                    "  ██████╔╝██║   ██║███████╗██║     ███████║██╔████╔██║██║██╔██╗ ██║███████║███████╗ \n" +
                    "  ██╔══██╗██║   ██║╚════██║██║     ██╔══██║██║╚██╔╝██║██║██║╚██╗██║██╔══██║╚════██║ \n" +
                    "  ██████╔╝╚██████╔╝███████║╚██████╗██║  ██║██║ ╚═╝ ██║██║██║ ╚████║██║  ██║███████║ \n" +
                    "  ╚═════╝  ╚═════╝ ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝ \033[0m\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "               \033[42m  ╗      ╔═╗╔═╗╔═╗╦ ╦        \033[0m\n" +
                    "               \033[42m  ║      ║╣ ╠═╣╚═╗╚╦╝        \033[0m\n" +
                    "               \033[42m  ╩      ╚═╝╩ ╩╚═╝ ╩         \033[0m\n" +
                    "\n" +
                    "               \033[43m ╔═╗     ╔╦╗╔═╗╦═╗╦╦ ╦╔╦╗    \033[0m\n" +
                    "               \033[43m ╔═╝     ║║║║╣ ║ ║║║ ║║║║    \033[0m\n" +
                    "               \033[43m ╚═╝     ╩ ╩╚═╝╩═╝╩╚═╝╩ ╩    \033[0m\n" +
                    "\n" +
                    "               \033[41m ╔═╗     ╦ ╦╔═╗╦═╗╦═╗        \033[0m\n" +
                    "               \033[41m  ═╣     ╠═╣╠═╣╠╦╝║ ║        \033[0m\n" +
                    "               \033[41m ╚═╝     ╩ ╩╩ ╩╩╚═╩═╝        \033[0m\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "               \033[45m ╔═╗     ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                    "               \033[45m ║ ║     ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                    "               \033[45m ╚═╝     ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m");

            int option = scanner.nextInt();
            scanner.nextLine();


            if(option != 0) {

                long startTime = System.currentTimeMillis();
                long endTime;

                int alto = 3;
                int ancho = 3;
                int densidad = 8;
                if (option == 2) {
                    alto = 8;
                    ancho = 8;
                    densidad = 7;
                } else if (option == 3) {
                    alto = 14;
                    ancho = 14;
                    densidad = 6;
                }

                int[][] cuentaMinas = new int[alto][ancho];
                boolean[][] tieneMina = new boolean[alto][ancho];
                boolean[][] destapada = new boolean[alto][ancho];

                int totalMinas = alto * ancho / densidad;

                for (int m = 0; m < totalMinas; ) {
                    int i = random.nextInt(alto);
                    int j = random.nextInt(ancho);

                    if (!tieneMina[i][j]) {
                        tieneMina[i][j] = true;
                        m++;

                        int[][] vecinas = {
                                {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                                {i, j - 1}, {i, j + 1},
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
                int casillasSinMina = ancho * alto - totalMinas;
                boolean gameOver = false;

                while (true) {
                    System.out.print("\033\143");

                    endTime = System.currentTimeMillis();

                    if(debug) {
                        System.out.print("   ");
                        for (int i = 0; i < ancho; i++) {
                            System.out.format("%2d ", i);
                        }
                        System.out.println();
                        for (int i = 0; i < alto; i++) {
                            System.out.format("%2d ", i);
                            for (int j = 0; j < ancho; j++) {
                                if (tieneMina[i][j]) {
                                    System.out.print(cellColors[10] + " * ");
                                } else {
                                    System.out.print(cellColors[cuentaMinas[i][j]] + " " + cuentaMinas[i][j] + " ");
                                }
                            }
                            System.out.println("\033[0m");
                        }
                        System.out.println("\033[0m");
                    }

                    System.out.format(" \033[30;101mTime: \033[1;91;40m %4s\033[0m%n%n", (endTime - startTime)/1000);
                    System.out.print("    ");
                    for (int i = 0; i < ancho; i++) {
                        System.out.format("\033[90;103m%2d \033[0m", i);
                    }
                    System.out.println();
                    for (int i = 0; i < alto; i++) {
                        System.out.format(" \033[90;105m%2d \033[0m", i);
                        for (int j = 0; j < ancho; j++) {
                            if (destapada[i][j]) {
                                System.out.print(tieneMina[i][j] ? cellColors[10] + " * " : cellColors[cuentaMinas[i][j]] + " " + cuentaMinas[i][j] + " ");
                            } else {
                                System.out.print(cellColors[9] + " · ");
                            }
                            System.out.print("\033[0m");
                        }
                        System.out.println("\033[0m");
                    }
                    System.out.println("\033[0m");


                    if (gameOver || destapadas == casillasSinMina) break;


                    int f = scanner.nextInt();
                    if(f < 0){
                        debug = !debug;
                        continue;
                    }
                    int c = scanner.nextInt();

                    if (f >= alto || c >= ancho) continue;

                    if (tieneMina[f][c]) {
                        gameOver = true;
                        for (int i = 0; i < alto; i++) {
                            for (int j = 0; j < ancho; j++) {
                                destapada[i][j] = true;
                            }
                        }
                    } else {
                        destapada[f][c] = true;
                        destapadas++;
                        if (cuentaMinas[f][c] == 0) {
                            boolean destapoAlguna = true;
                            while (destapoAlguna) {
                                destapoAlguna = false;
                                for (int i = 0; i < alto; i++) {
                                    for (int j = 0; j < ancho; j++) {
                                        if (destapada[i][j] && cuentaMinas[i][j] == 0) {
                                            int[][] vecinas = {
                                                    {i - 1, j},
                                                    {i, j - 1}, {i, j + 1},
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

                scanner.nextLine();

                if (gameOver) {
                    System.out.println("\n\033[30;101m" +
                            "  ╦ ╦╔═╗╦ ╦  ╦  ╔═╗╔═╗╔═╗╔═╗  \n" +
                            "  ╚╦╝║ ║║ ║  ║  ║ ║║ ║╚═╗║╣   \n" +
                            "   ╩ ╚═╝╚═╝  ╩═╝╚═╝╚═╝╚═╝╚═╝  ");
                    scanner.nextLine();
                } else {
                    System.out.println("\n\033[30;102m" +
                            "  ╦ ╦╔═╗╦ ╦  ╦ ╦ ╦ ╔╗╔  \n" +
                            "  ╚╦╝║ ║║ ║  ║║║ ║ ║║║  \n" +
                            "   ╩ ╚═╝╚═╝  ╚╩╝ ╩ ╝╚╝  \033[0m");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    FileWriter fileWriter = new FileWriter(file, true);
                    fileWriter.write( (endTime-startTime)/1000 + " " + name + "\n");
                    fileWriter.close();

                    option = 0;
                }
            }

            if(option == 0){
                System.out.print("\033\143");
                System.out.println("\n" +
                        "  \033[1;30;105m  ╔╦╗╔═╗╔═╗  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                        "  \033[1;30;105m   ║ ║ ║╠═╝  ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                        "  \033[1;30;105m   ╩ ╚═╝╩    ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m");
                System.out.println();

                Scanner scanner1 = new Scanner(file);
                while(scanner1.hasNext()){
                    int score = scanner1.nextInt();
                    String name = scanner1.nextLine();

                    System.out.format("  \033[44m%20s \033[0m \033[42m  %8s \033[0m%n", name, score);
                }

                scanner.nextLine();
            }
        }
    }
}
