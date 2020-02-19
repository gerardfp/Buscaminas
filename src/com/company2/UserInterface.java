package com.company2;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    //                          0              1            2           3               4               5              6               7             8               t              m
    String[] colores = {"\033[37;47m", "\033[34;47m", "\033[32;47m", "\033[91;47m", "\033[94;47m", "\033[31;47m", "\033[96;47m", "\033[35;47m", "\033[37;47m", "\033[30;100m", "\033[30;41m"};


    void limpiarPantalla(){
        System.out.print("\033\143");
    }

    void mostrarPantallaPrincipal(){
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
    }

    int leerOpcion(){
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    void mostrarHasPerdido(){
        System.out.println("\n\033[30;101m" +
                "  ╦ ╦╔═╗╦ ╦  ╦  ╔═╗╔═╗╔═╗╔═╗  \n" +
                "  ╚╦╝║ ║║ ║  ║  ║ ║║ ║╚═╗║╣   \n" +
                "   ╩ ╚═╝╚═╝  ╩═╝╚═╝╚═╝╚═╝╚═╝  \033[0m");
    }

    void mostrarHasGanado(){
        System.out.println("\n\033[30;102m" +
                "  ╦ ╦╔═╗╦ ╦  ╦ ╦ ╦ ╔╗╔  \n" +
                "  ╚╦╝║ ║║ ║  ║║║ ║ ║║║  \n" +
                "   ╩ ╚═╝╚═╝  ╚╩╝ ╩ ╝╚╝  \033[0m");
    }

    void mostrarPuntuaciones(){
        System.out.println("\n" +
                "  \033[1;30;105m  ╔╦╗╔═╗╔═╗  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                "  \033[1;30;105m   ║ ║ ║╠═╝  ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                "  \033[1;30;105m   ╩ ╚═╝╩    ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m\n");
    }

    void mostrarPuntuacion(String nombre, int score){
        System.out.format("  \033[44m%20s \033[0m \033[42m  %8s \033[0m%n", nombre, score);
    }

    void mostrarTiempo(int time){
        System.out.format(" \033[30;101mTime: \033[1;91;40m %4s\033[0m%n%n", time);
    }

    String pedirNombre(){
        System.out.print("Name: ");
        return scanner.nextLine();
    }

    void pressAnyKey(){
        scanner.nextLine();
    }

    int leerFila(){
        return scanner.nextInt();
    }

    int leerColumna(){
        return scanner.nextInt();
    }

    void mostrarTablero(Tablero tablero){

        mostrarNumerosColumna(tablero.ancho);

        for (int i = 0; i < tablero.alto; i++) {
            mostrarNumeroFila(i);
            for (int j = 0; j < tablero.ancho; j++) {
                mostrarCasilla(tablero.casillas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void mostrarCasilla(Casilla casilla){
        if ( casilla.destapada) {
            System.out.print(casilla.tieneMina ? colores[10] + " * " : colores[casilla.cuentaMinas] + " " + casilla.cuentaMinas + " ");
        } else {
            System.out.print(colores[9] + " · ");
        }
        System.out.print("\033[0m");
    }

    void mostrarTableroCheat(Tablero tablero){
        mostrarNumerosColumna(tablero.ancho);
        for (int i = 0; i < tablero.alto; i++) {
            mostrarNumeroFila(i);
            for (int j = 0; j < tablero.ancho; j++) {
                mostrarCasillaCheat(tablero.casillas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void mostrarCasillaCheat(Casilla casilla){
        if (casilla.tieneMina) {
            System.out.print(colores[10] + " * ");
        } else {
            System.out.print(colores[casilla.cuentaMinas] + " " + casilla.cuentaMinas + " ");
        }
        System.out.print("\033[0m");
    }

    void mostrarNumerosColumna(int ancho){
        System.out.print("    ");
        for (int i = 0; i < ancho; i++) {
            System.out.format("\033[90;103m%2d \033[0m", i);
        }
        System.out.println();
    }

    void mostrarNumeroFila(int numeroFila){
        System.out.format(" \033[90;105m%2d \033[0m", numeroFila);
    }
}
