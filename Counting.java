package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Couting {
  static String texto = "";
  static int[] v;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\vetor\\5teste.txt"))
        .useDelimiter("\n");
    while (scanner.hasNext()) {
      texto = scanner.next();
    }

    String[] separatedStrings = texto.replaceAll("\\[", "")
        .replaceAll("]", "").replace(" ", "").split(",");

    int[] intArray = new int[separatedStrings.length];

    for (int i = 0; i < separatedStrings.length; i++) {

      try {
        intArray[i] = Integer.parseInt(separatedStrings[i]);
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

    countSort(intArray, 0);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5ordenado1.txt");
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

  public static void countSort(int intArray[], int size) {
    int[] output = new int[size + 1];

    // Encontra o maior elemento do array
    int max = intArray[0];
    for (int i = 1; i < size; i++) {
      if (intArray[i] > max)
        max = intArray[i];
    }
    int[] count = new int[max + 1];

    // Inicializa o array de contagem com todos os zeros.
    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    // Armazena a contagem de cada elemento
    for (int i = 0; i < size; i++) {
      count[intArray[i]]++;
    }

    // Armazena a contagem cumulativa de cada array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Encontra o índice de cada elemento do array original no array de contagem e
    //coloca os elementos no array de saída
    for (int i = size - 1; i >= 0; i--) {
      output[count[intArray[i]] - 1] = intArray[i];
      count[intArray[i]]--;
    }

    // Copia os elementos ordenados no array original
    for (int i = 0; i < size; i++) {
      intArray[i] = output[i];
    }
  }

}
