package com.company2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File ficheroScores = new File("scores.txt");
        boolean debug = false;


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
                    "\n" +
                    "\n" +
                    "               \033[45m  ╔═╗     ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                    "               \033[45m  ║ ║     ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                    "               \033[45m  ╚═╝     ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m");

            int opcion = scanner.nextInt();
            scanner.nextLine();


            if(opcion != 0) {

                long tiempoInicio = System.currentTimeMillis();
                int duracion = 0;

                int alto = 3;
                int ancho = 3;
                int densidad = 8;
                if (opcion == 2) {
                    alto = 8;
                    ancho = 8;
                    densidad = 7;
                } else if (opcion == 3) {
                    alto = 14;
                    ancho = 14;
                    densidad = 6;
                }

                Tablero tablero = new Tablero(alto, ancho, densidad);

                boolean gameOver = false;

                while (true) {
                    System.out.print("\033\143");

                    duracion = (int) (System.currentTimeMillis() - tiempoInicio)/1000;

                    if(debug) {
                        tablero.mostrarDebug();
                    }

                    System.out.format(" \033[30;101mTime: \033[1;91;40m %4s\033[0m%n%n", duracion);
                    tablero.mostrar();


                    if (gameOver || tablero.destapadas == tablero.casillasSinMina) break;


                    int f = scanner.nextInt();
                    if(f < 0){
                        debug = !debug;
                        continue;
                    }
                    int c = scanner.nextInt();

                    if (f >= alto || c >= ancho) continue;

                    if (tablero.tieneMina(f, c)) {
                        gameOver = true;
                        tablero.destaparTodas();
                    } else {
                        tablero.destapar(f,c);
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
                    System.out.print("Name: ");
                    String nombre = scanner.nextLine();
                    FileWriter fileWriter = new FileWriter(ficheroScores, true);
                    fileWriter.write(duracion + " " + nombre + "\n");
                    fileWriter.close();

                    opcion = 0;
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
                    int score = scannerScores.nextInt();
                    String nombre = scannerScores.nextLine();

                    System.out.format("  \033[44m%20s \033[0m \033[42m  %8s \033[0m%n", nombre, score);
                }

                scanner.nextLine();
            }
        }
    }
}
