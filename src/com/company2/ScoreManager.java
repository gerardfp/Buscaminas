package com.company2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ScoreManager {
    File ficheroScores;

    ScoreManager() throws IOException {
        ficheroScores = new File("scores.txt");
        ficheroScores.createNewFile();
    }

    void guardarPuntuacion(String nombre, int score, int level) throws IOException {
        FileWriter fileWriter = new FileWriter(ficheroScores, true);
        fileWriter.write(level + " " + score + " " + nombre + "\n");
        fileWriter.close();
    }

    List<Puntuacion> obtenerPuntuaciones() throws FileNotFoundException {
        Scanner scannerScores = new Scanner(ficheroScores);

        List<Puntuacion> resultado = new ArrayList<>();
        while(scannerScores.hasNext()){
            int nivel = scannerScores.nextInt();
            int score = scannerScores.nextInt();
            String nombre = scannerScores.next() + scannerScores.nextLine();

            resultado.add(new Puntuacion(nivel, score, nombre));
        }

        resultado.sort((o1, o2) -> {
            if(o1.nivel == o2.nivel){
                return Integer.compare(o1.duracion, o2.duracion);
            }
            return -Integer.compare(o1.nivel, o2.nivel);
        });
        return resultado;
    }
}
