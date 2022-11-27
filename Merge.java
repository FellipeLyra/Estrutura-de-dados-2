package Comparador;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Merge {
  static String texto = "";
  static int[] v;

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

    mergeSort(intArray, 0, intArray.length - 1);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);
    // System.out.println(Arrays.toString(intArray));
    FileWriter arq = new FileWriter("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\5melhorcasoordenado1.txt");
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

  public static void merge (int [] intArray, int p, int q, int r){
    int n1= q - p + 1;
    int trocas = 0;
    int n2 = r - q;

    int L[] = new int[n1];
    int M[] = new int[n2];

    for (int i=0; i<n1; i++){
      L[i] = intArray[p+1];
      for (int j=0; j<n2; j++){
        M[j] = intArray[q+1+j];
      }
      trocas++;
    }

    int i,j,k;
    i=0;
    j=0;
    k=p;

    while (i<n1 && j<n2){
      if (L[i] <= M[j]){
        intArray[k] = L[i];
        i++;
      } else{
        intArray[k] = M[j];
        j++;
      }
      k++;
    }

    while (i<n1){
      intArray[k] = L[i];
      i++;
      k++;
    }

    while (j<n2){
      intArray[k] = M[j];
      j++;
      k++;
    }
    System.out.println("Trocas: " + trocas);
  }

  public static void mergeSort(int [] intArray, int l, int r){
    if (l<r){
      int m = (l+r)/2;

      mergeSort(intArray, l, m);
      merge(intArray, m, 1, r);

      merge (intArray,l,m,r);
    }
  }
}
