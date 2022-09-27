package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Quick {
  static String texto = "";
  static int[] v;

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\10milteste.txt"))
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

    quickSort(intArray,0,intArray.length-1);


    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\10milteste1.txt");
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

  private static void quickSort(int[] intArray, int inicio, int fim) {
    if (inicio < fim) {
           int posicaoPivo = separar(intArray, inicio, fim);
           quickSort(intArray, inicio, posicaoPivo - 1);
           quickSort(intArray, posicaoPivo + 1, fim);
    }
}

private static int separar(int[] intArray, int inicio, int fim) {
    int pivo = intArray[inicio];
    int i = inicio + 1, f = fim;
    int trocas = 0;
    while (i <= f) {
           if (intArray[i] <= pivo)
                  i++;
           else if (pivo < intArray[f])
                  f--;
           else {
                  int troca = intArray[i];
                  intArray[i] = intArray[f];
                  intArray[f] = troca;
                  i++;
                  f--;
           }
           trocas++;
    } System.out.println("Trocas: " + trocas);
    intArray[inicio] = intArray[f];
    intArray[f] = pivo;
    return f;
    
}
}
