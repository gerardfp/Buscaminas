package com.company2;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    void clearScreen(){
        System.out.print("\033\143");
    }

    void printMainScreen(){
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

    void printLoose(){
        System.out.println("\n\033[30;101m" +
                "  ╦ ╦╔═╗╦ ╦  ╦  ╔═╗╔═╗╔═╗╔═╗  \n" +
                "  ╚╦╝║ ║║ ║  ║  ║ ║║ ║╚═╗║╣   \n" +
                "   ╩ ╚═╝╚═╝  ╩═╝╚═╝╚═╝╚═╝╚═╝  \033[0m");
    }

    void printWin(){
        System.out.println("\n\033[30;102m" +
                "  ╦ ╦╔═╗╦ ╦  ╦ ╦ ╦ ╔╗╔  \n" +
                "  ╚╦╝║ ║║ ║  ║║║ ║ ║║║  \n" +
                "   ╩ ╚═╝╚═╝  ╚╩╝ ╩ ╝╚╝  \033[0m");
    }

    void printTopScores(){
        System.out.println("\n" +
                "  \033[1;30;105m  ╔╦╗╔═╗╔═╗  ╔═╗╔═╗╔═╗╦═╗╔═╗╔═╗  \033[0m\n" +
                "  \033[1;30;105m   ║ ║ ║╠═╝  ╚═╗║  ║ ║╠╦╝║╣ ╚═╗  \033[0m\n" +
                "  \033[1;30;105m   ╩ ╚═╝╩    ╚═╝╚═╝╚═╝╩╚═╚═╝╚═╝  \033[0m\n");
    }

    void printScore(String nombre, int score){
        System.out.format("  \033[44m%20s \033[0m \033[42m  %8s \033[0m%n", nombre, score);
    }

    void printTime(int time){
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
}
