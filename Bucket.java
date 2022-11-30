package Comparador;

import java.util.*;
import java.util.Collections;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bucket {
  static String texto = "";
  static int[] v;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\vetor\\5piorcaso.txt"))
        .useDelimiter("\n");
    while (scanner.hasNext()) {
      texto = scanner.next();
    }

    String[] separatedStrings = texto.replaceAll("\\[", "")
        .replaceAll("]", "").replace(" ", "").split(",");

    Float[] intArray = new Float[separatedStrings.length];

    for (int i = 0; i < separatedStrings.length; i++) {

      try {
        intArray[i] = Float.parseFloat(separatedStrings[i]);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    long n;
    long horas;
    long minutos;
    long segundos;
    long mili;

    long tempoInicial = System.currentTimeMillis();

    int e = intArray.length;
    bucketSort(intArray, e);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5piorcasoordenado1.txt");
    PrintWriter gravarArq = new PrintWriter(arq);

    String v = "[";

    for (int i = 0; i < intArray.length; i++) {
      v += intArray[i];

      if (i == intArray.length - 1)
        v += "]";
      else {
        v += ", ";
      }
    }
    gravarArq.println("Nome: Fellipe Henrique Gomes Lyra");
    gravarArq.println("Tempo: " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    gravarArq.println("Vetor ordenado: " + v);
    arq.close();

  }
  private static void bucketSort(Float[] intArray, int e) {
    int trocas = 0;
    if (e <= 0)
    return;

// Criar n baldes vazios
@SuppressWarnings("unchecked")
Vector<Float>[] buckets = new Vector[e];

for (int i = 0; i < e; i++) {
    buckets[i] = new Vector<Float>();
}

// Coloque os elementos da matriz em diferentes baldes
for (int i = 0; i < e; i++) {
    float idx = intArray[i] * e;
    buckets[(int)idx].add(intArray[i]);
}

// 3) Classifique baldes individuais
for (int i = 0; i < e; i++) {
    Collections.sort(buckets[i]);
}

//Concatenar todos os baldes em intArray[]
int index = 0;
for (int i = 0; i < e; i++) {
    for (int j = 0; j < buckets[i].size(); j++) {
        intArray[index++] = buckets[i].get(j);
        trocas++;
    }
}
System.out.println("Trocas: " + trocas);
}

}
