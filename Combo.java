package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Combo {
  static String texto = "";
  static int[] v;
  //Para encontrar a lacuna entre os elementos
  static int getNextGap(int gap)
    {
        // Espaço de contração por fator de contração
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\vetor\\5piorcaso.txt"))
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

    combo(intArray);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5piorcasoordenado.txt");
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

  static void combo(int intArray[])
    {
        int trocas = 0;
        int n = intArray.length;
 
        // inicializar lacuna
        int gap = n;
 
        // Inicialize swapped como true para garantir que
        // loop runs
        boolean swapped = true;
 
        // Continue run enquanto a lacuna for maior que 1 e durar
        // iteração causou uma troca
        while (gap != 1 || swapped == true)
        {
            //proxima lacuna ou gap
            gap = getNextGap(gap);
            
            // Inicialize trocado como falso para que possamos
            // verifique se a troca aconteceu ou não
            swapped = false;
 
            // Comparar todos os elementos com o gap atual
            for (int i=0; i<n-gap; i++)
            {
                if (intArray[i] > intArray[i+gap])
                {
                    int temp = intArray[i];
                    intArray[i] = intArray[i+gap];
                    intArray[i+gap] = temp;

                    swapped = true;
                }
                trocas++;
            }
        }
        System.out.println("Trocas: "+trocas);
    }
}
