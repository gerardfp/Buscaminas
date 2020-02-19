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
        File ficheroScores = new File("scores.txt");
        ficheroScores.createNewFile();

        //                          0              1            2           3               4               5              6               7             8               t              m
        String[] colores = {"\033[37;47m", "\033[34;47m", "\033[32;47m", "\033[91;47m", "\033[94;47m", "\033[31;47m", "\033[96;47m", "\033[35;47m", "\033[37;47m", "\033[30;100m", "\033[30;41m"};
        String[] niveles = {"\033[42m  EASY  \033[0m", "\033[43m MEDIUM \033[0m", "\033[41m  HARD  \033[0m"};

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
                    "               \033[42m   ╗      ╔═╗╔═╗╔═╗╦ ╦        \033[0m\n" +
                    "               \033[42m   ║      ║╣ ╠═╣╚═╗╚╦╝        \033[0m\n" +
                    "               \033[42m   ╩      ╚═╝╩ ╩╚═╝ ╩         \033[0m\n" +
                    "\n" +
                    "               \033[43m  ╔═╗     ╔╦╗╔═╗╦═╗╦╦ ╦╔╦╗    \033[0m\n" +
                    "               \033[43m  ╔═╝     ║║║║╣ ║ ║║║ ║║║║    \033[0m\n" +
                    "               \033[43m  ╚═╝     ╩ ╩╚═╝╩═╝╩╚═╝╩ ╩    \033[0m\n" +
                    "\n" +
                    "               \033[41m  ╔═╗     ╦ ╦╔═╗╦═╗╦═╗        \033[0m\n" +
                    "               \033[41m   ═╣     ╠═╣╠═╣╠╦╝║ ║        \033[0m\n" +
                    "               \033[41m  ╚═╝     ╩ ╩╩ ╩╩╚═╩═╝        \033[0m\n" +
                    "\n" +
                    "               \033[104m  ╦ ╦     ╔═╗╦ ╦╔═╗╔╦╗╔═╗╔╦╗  \033[0m\n" +
                    "               \033[104m  ╚═╣     ║  ║ ║╚═╗ ║ ║ ║║║║  \033[0m\n" +
                    "               \033[104m    ╩     ╚═╝╚═╝╚═╝ ╩ ╚═╝╩ ╩  \033[0m\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "               \033[45m  ╔═╗     ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                    "               \033[45m  ║ ║     ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                    "               \033[45m  ╚═╝     ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m");

            int opcion = scanner.nextInt();
            scanner.nextLine();


            if(opcion > 0) {

                long tiempoInicio = System.currentTimeMillis();
                int duracion = 0;

                int alto = 16;
                int ancho = 31;
                int totalMinas = 99;
                if (opcion == 1) {
                    alto = 8;
                    ancho = 8;
                    totalMinas = 10;
                } else if (opcion == 2) {
                    alto = 16;
                    ancho = 16;
                    totalMinas = 40;
                } else if(opcion == 4){
                    System.out.println("Filas:");
                    alto = scanner.nextInt();
                    System.out.println("Columnas:");
                    ancho = scanner.nextInt();
                    System.out.println("Minas:");
                    totalMinas = scanner.nextInt();
                }

                int[][] cuentaMinas = new int[alto][ancho];
                boolean[][] tieneMina = new boolean[alto][ancho];
                boolean[][] destapada = new boolean[alto][ancho];


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
                boolean cheat = false;

                while (true) {
                    System.out.print("\033\143");

                    duracion = (int) (System.currentTimeMillis() - tiempoInicio)/1000;

                    if(cheat) {
                        System.out.print("    ");
                        for (int i = 0; i < ancho; i++) {
                            System.out.format("\033[90;103m%2d \033[0m", i);
                        }
                        System.out.println();
                        for (int i = 0; i < alto; i++) {
                            System.out.format(" \033[90;105m%2d \033[0m", i);
                            for (int j = 0; j < ancho; j++) {
                                if (tieneMina[i][j]) {
                                    System.out.print(colores[10] + " * ");
                                } else {
                                    System.out.print(colores[cuentaMinas[i][j]] + " " + cuentaMinas[i][j] + " ");
                                }
                                System.out.print("\033[0m");
                            }
                            System.out.println();
                        }
                        System.out.println();
                    }

                    System.out.format(" \033[30;101mTime: \033[1;91;40m %4s\033[0m%n%n", duracion);
                    System.out.print("    ");
                    for (int i = 0; i < ancho; i++) {
                        System.out.format("\033[90;103m%2d \033[0m", i);
                    }
                    System.out.println();
                    for (int i = 0; i < alto; i++) {
                        System.out.format(" \033[90;105m%2d \033[0m", i);
                        for (int j = 0; j < ancho; j++) {
                            if (destapada[i][j]) {
                                System.out.print(tieneMina[i][j] ? colores[10] + " * " : colores[cuentaMinas[i][j]] + " " + cuentaMinas[i][j] + " ");
                            } else {
                                System.out.print(colores[9] + " · ");
                            }
                            System.out.print("\033[0m");
                        }
                        System.out.println();
                    }


                    if (gameOver || destapadas == casillasSinMina) break;


                    int fila = scanner.nextInt();

                    if(fila == -1){
                        cheat = !cheat;
                        continue;
                    }

                    if(fila == -2){
                        gameOver = true;
                        continue;
                    }

                    int columna = scanner.nextInt();

                    if (fila >= alto || columna >= ancho) continue;

                    if (tieneMina[fila][columna]) {
                        gameOver = true;
                        for (int i = 0; i < alto; i++) {
                            for (int j = 0; j < ancho; j++) {
                                destapada[i][j] = true;
                            }
                        }
                    } else {
                        destapada[fila][columna] = true;
                        destapadas++;
                        if (cuentaMinas[fila][columna] == 0) {
                            boolean destapoAlguna = true;
                            while (destapoAlguna) {
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

                scanner.nextLine();

                if (gameOver) {
                    System.out.println("\n\033[30;101m" +
                            "  ╦ ╦╔═╗╦ ╦  ╦  ╔═╗╔═╗╔═╗╔═╗  \n" +
                            "  ╚╦╝║ ║║ ║  ║  ║ ║║ ║╚═╗║╣   \n" +
                            "   ╩ ╚═╝╚═╝  ╩═╝╚═╝╚═╝╚═╝╚═╝  \033[0m");
                    scanner.nextLine();
                } else {
                    System.out.println("\n\033[30;102m" +
                            "  ╦ ╦╔═╗╦ ╦  ╦ ╦ ╦ ╔╗╔  \n" +
                            "  ╚╦╝║ ║║ ║  ║║║ ║ ║║║  \n" +
                            "   ╩ ╚═╝╚═╝  ╚╩╝ ╩ ╝╚╝  \033[0m");

                    if(opcion < 4) {
                        System.out.print("Name: ");
                        String nombre = scanner.nextLine();
                        FileWriter fileWriter = new FileWriter(ficheroScores, true);
                        fileWriter.write(opcion + " " + duracion + " " + nombre + "\n");
                        fileWriter.close();
                        opcion = 0;
                    }
                }
            }

            if(opcion == 0){
                System.out.print("\033\143");
                System.out.println("\n" +
                        "  \033[1;30;105m  ╔╦╗╔═╗╔═╗  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                        "  \033[1;30;105m   ║ ║ ║╠═╝  ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                        "  \033[1;30;105m   ╩ ╚═╝╩    ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m\n");

                Scanner scannerScores = new Scanner(ficheroScores);
                while(scannerScores.hasNext()){
                    int nivel = scannerScores.nextInt();
                    int score = scannerScores.nextInt();
                    String nombre = scannerScores.next() + scannerScores.nextLine();

                    System.out.format("  \033[44m%18s \033[0m \033[45m %6s \033[0m %6s \033[0m%n", nombre, score, niveles[nivel-1]);
                }

                scanner.nextLine();
            }

            if(opcion < 0){
                return;
            }
        }
    }
}
