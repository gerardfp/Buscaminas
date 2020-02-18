package com.company2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File ficheroScores = new File("scores.txt");
        UserInterface ui = new UserInterface();
        Scores scores = new Scores();

        boolean debug = false;

        while (true) {
            ui.clearScreen();

            ui.printMainScreen();

            int opcion = ui.leerOpcion();

            if(opcion != 0) {

                Tablero tablero = new Tablero(opcion);
                Cronometro cronometro = new Cronometro();

                boolean gameOver = false;

                while (true) {

                    cronometro.actualizar();

                    ui.clearScreen();

                    if(debug) tablero.mostrarDebug();

                    ui.printTime(cronometro.duracion);

                    tablero.mostrar();

                    if (gameOver || tablero.completado()) break;

                    int fila = ui.leerFila();
                    if(fila < 0){
                        debug = !debug;
                        continue;
                    }

                    int columna = ui.leerColumna();

                    if (!tablero.valida(fila, columna)) continue;

                    if (tablero.tieneMina(fila, columna)) {
                        gameOver = true;
                        tablero.destaparTodas();
                    } else {
                        tablero.destapar(fila,columna);
                    }
                }

                ui.pressAnyKey();

                if (gameOver) {
                    ui.printLoose();
                    ui.pressAnyKey();
                } else {
                    ui.printWin();

                    String nombre = ui.pedirNombre();

                    scores.saveScore(nombre, cronometro.duracion);

                    opcion = 0;
                }
            }

            if(opcion == 0){
                ui.clearScreen();
                ui.printTopScores();

                // loadScores
                Scanner scannerScores = new Scanner(ficheroScores);
                while(scannerScores.hasNext()){
                    int score = scannerScores.nextInt();
                    String nombre = scannerScores.nextLine();

                    ui.printScore(nombre, score);
                }

                ui.pressAnyKey();
            }
        }
    }
}
