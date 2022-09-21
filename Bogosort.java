package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Bogo {
  static String texto = "";
  static int[] v;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5teste.txt"))
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

    bogoSort(intArray);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5teste1.txt");
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
    gravarArq.print(v);
    arq.close();

  }

  public static void bogoSort(int[] intArray) {
    int trocas = 0;
    Random rand = new Random();
    while (!isSorted(intArray)) {
      for (int i = 0; i < intArray.length; i++) {
        int r = rand.nextInt(intArray.length);
        int temp = intArray[i];
        intArray[i] = intArray[r];
        intArray[r] = temp;
        trocas++;
      }
    }
    System.out.println("Trocas: " + trocas);
  }

  private static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= arr[i - 1]) {
      } else {
        return false;
      }
    }
    return true;
  }
}
