package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cocktail {
  static String texto = "";
  static int[] v;
  void cocktailSort(int intArray[])
  {
    
      boolean swapped = true;
      int start = 0;
      int end = intArray.length;

      while (swapped == true)
      {
          // redefinir o sinalizador trocado ao entrar no
           // loop, porque pode ser verdadeiro de um
           // iteração anterior.
          swapped = false;

          // loop de baixo para cima igual ao
           // o tipo de bolha
          for (int i = start; i < end - 1; ++i)
          {
              if (intArray[i] > intArray[i + 1]) {
                  int temp = intArray[i];
                  intArray[i] = intArray[i + 1];
                  intArray[i + 1] = temp;
                  swapped = true;
              }
          }

          // se nada for movido, a matriz será classificada.
          if (swapped == false)
              break;

          // caso contrário, redefinir o sinalizador trocado para que ele
           // pode ser usado na próxima etapa
          swapped = false;

          // move o ponto final para trás em um, porque
           // item no final está em seu devido lugar
          end = end - 1;

          // de cima para baixo, fazendo o
           // mesma comparação da etapa anterior
          for (int i = end - 1; i >= start; i--)
          {
              if (intArray[i] > intArray[i + 1])
              {
                  int temp = intArray[i];
                  intArray[i] = intArray[i + 1];
                  intArray[i + 1] = temp;
                  swapped = true;
              }
          }

          // aumenta o ponto inicial, porque
           // o último estágio teria movido o próximo
           // menor número ao seu devido lugar.
          start = start + 1;
      }
  }

  /* Imprime o array */
  void printArray(int intArray[])
  {
    Scanner ler = new Scanner(System.in);
      int n = intArray.length;
      for (int i = 0; i < n; i++)
          System.out.print(intArray[i] + " ");
      System.out.println();
      int e = ler.nextInt();
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\vetor\\5melhorcaso.txt"))
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

    Cocktail ob = new Cocktail();
    ob.cocktailSort(intArray);
    ob.printArray(intArray);
    
    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5melhorcasoordenado.txt");
    PrintWriter gravarArq = new PrintWriter(arq);

    String v = "[";
    int e = intArray.length;
    int f;
    for(int j=0; j<e; j++){
        f = intArray[j];
    for (int i = 0; i < f; i++) {
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

      }  }

}
