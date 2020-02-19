package com.company2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInterface();
        ScoreManager sm = new ScoreManager();

        boolean cheat = false;

        while (true) {
            ui.limpiarPantalla();

            ui.mostrarPantallaPrincipal();

            int opcion = ui.leerOpcion();

            if(opcion != 0) {

                Tablero tablero = new Tablero(opcion);
                Cronometro cronometro = new Cronometro();

                boolean gameOver = false;

                while (true) {

                    cronometro.actualizar();

                    ui.limpiarPantalla();

                    if(cheat) ui.mostrarTableroCheat(tablero);

                    ui.mostrarTiempo(cronometro.duracion);

                    ui.mostrarTablero(tablero);

                    if (gameOver || tablero.completado()) break;

                    int fila = ui.leerFila();
                    if(fila < 0){
                        cheat = !cheat;
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

                    sm.guardarPuntuacion(ui.pedirNombre(), cronometro.duracion);

                    opcion = 0;
                }
            }

            if(opcion == 0){
                ui.limpiarPantalla();
                ui.mostrarPuntuaciones();

                for(Puntuacion puntuacion : sm.obtenerPuntuaciones()){
                    ui.mostrarPuntuacion(puntuacion.nombre, puntuacion.duracion);
                }

                ui.pressAnyKey();
            }
        }
    }
}
