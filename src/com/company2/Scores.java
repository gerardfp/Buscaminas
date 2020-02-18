package com.company2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Scores {
    File ficheroScores = new File("scores.txt");

    void saveScore(String nombre, int score) throws IOException {
        FileWriter fileWriter = new FileWriter(ficheroScores, true);
        fileWriter.write(score + " " + nombre + "\n");
        fileWriter.close();
    }

    void loadScores(){

    }
}
