package com.company2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInterface();
        ScoreManager sm = new ScoreManager();

        while (true) {
            ui.limpiarPantalla();

            ui.mostrarPantallaPrincipal();

            int opcion = ui.leerOpcion();

            if(opcion > 0) {

                Cronometro cronometro = new Cronometro();

                Tablero tablero;
                if(opcion == 4){
                    tablero = new Tablero(ui.leerAlto(), ui.leerAncho(), ui.leerMinas());
                } else {
                    tablero = new Tablero(opcion);
                }

                boolean gameOver = false;
                boolean cheat = false;

                while (true) {

                    cronometro.actualizar();

                    ui.limpiarPantalla();

                    if(cheat) ui.mostrarTableroCheat(tablero);

                    ui.mostrarTiempo(cronometro.duracion);

                    ui.mostrarTablero(tablero);

                    if (gameOver || tablero.completado()) break;

                    int fila = ui.leerFila();

                    if(fila == -1){
                        cheat = !cheat;
                        continue;
                    }

                    if(fila == -2){
                        gameOver = true;
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
                    ui.mostrarHasPerdido();
                    ui.pressAnyKey();
                } else {
                    ui.mostrarHasGanado();
                    if(opcion < 4) {
                        sm.guardarPuntuacion(ui.pedirNombre(), cronometro.duracion, opcion);
                        opcion = 0;
                    }
                }
            }

            if(opcion == 0){
                ui.limpiarPantalla();
                ui.mostrarPuntuaciones(sm.obtenerPuntuaciones());
                ui.pressAnyKey();
            }

            if(opcion < 0){
                return;
            }
        }
    }
}
