package com.company2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreManager {
    File ficheroScores;

    ScoreManager() throws IOException {
        ficheroScores = new File("scores.txt");
        ficheroScores.createNewFile();
    }

    void guardarPuntuacion(String nombre, int score) throws IOException {
        FileWriter fileWriter = new FileWriter(ficheroScores, true);
        fileWriter.write(score + " " + nombre + "\n");
        fileWriter.close();
    }

    Iterable<Puntuacion> obtenerPuntuaciones() throws FileNotFoundException {
        Scanner scannerScores = new Scanner(ficheroScores);
        return () -> new Iterator<Puntuacion>() {
            @Override
            public boolean hasNext() {
                return scannerScores.hasNext();
            }

            @Override
            public Puntuacion next() {
                int score = scannerScores.nextInt();
                String nombre = scannerScores.nextLine();

                return new Puntuacion(nombre, score);
            }
        };
    }
}
