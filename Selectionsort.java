package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Selection {
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

    selectionSort(intArray);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5ordenado.txt");
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

  public static void selectionSort(int[] intArray){  
    int trocas = 0;
    for (int i = 0; i < intArray.length - 1; i++)  
    {  
        int index = i;  
        for (int j = i + 1; j < intArray.length; j++){  
            if (intArray[j] < intArray[index]){  
                index = j; 
                trocas++;
            }  
        }  
        int smallerNumber = intArray[index];    
        intArray[index] = intArray[i];  
        intArray[i] = smallerNumber;  
    }  
    System.out.println("Trocas: " + trocas);
}  
  
}
