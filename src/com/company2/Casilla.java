package com.company2;

public class Casilla {
    //                          0              1            2           3               4               5              6               7             8               t              m
    static String[] colores = {"\033[37;47m", "\033[34;47m", "\033[32;47m", "\033[91;47m", "\033[94;47m", "\033[31;47m", "\033[96;47m", "\033[35;47m", "\033[37;47m", "\033[30;100m", "\033[30;41m"};

    int cuentaMinas;
    boolean tieneMina;
    boolean destapada;

    void mostrar(){
        if (destapada) {
            System.out.print(tieneMina ? colores[10] + " * " : colores[cuentaMinas] + " " + cuentaMinas + " ");
        } else {
            System.out.print(colores[9] + " · ");
        }
        System.out.print("\033[0m");
    }

    void mostrarDebug(){
        if (tieneMina) {
            System.out.print(colores[10] + " * ");
        } else {
            System.out.print(colores[cuentaMinas] + " " + cuentaMinas + " ");
        }
        System.out.print("\033[0m");
    }
}
