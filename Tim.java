package Comparador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tim {
  static String texto = "";
  static int[] v;
  static int MIN_MERGE = 32;

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

    timSort(intArray, 0);

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

  public static void insertionSort(int[] arr, int left,
  int right)
{
for (int i = left + 1; i <= right; i++)
{
int temp = arr[i];
int j = i - 1;
while (j >= left && arr[j] > temp)
{
arr[j + 1] = arr[j];
j--;
}
arr[j + 1] = temp;
}
}

// A função merge mescla as execuções classificadas
public static void merge(int[] arr, int l,
int m, int r)
{
// O array original é quebrado em duas partes
// matriz esquerda e direita
int len1 = m - l + 1, len2 = r - m;
int[] left = new int[len1];
int[] right = new int[len2];
for (int x = 0; x < len1; x++)
{
left[x] = arr[l + x];
}
for (int x = 0; x < len2; x++)
{
right[x] = arr[m + 1 + x];
}

int i = 0;
int j = 0;
int k = l;

// Depois de comparar, mesclamos esses dois arrays
// em sub array maior
while (i < len1 && j < len2)
{
if (left[i] <= right[j])
{
arr[k] = left[i];
i++;
}
else {
arr[k] = right[j];
j++;
}
k++;
}
// Copia os elementos restantes
// da esquerda, se houver
while (i < len1)
{
arr[k] = left[i];
k++;
i++;
}

// Copia o elemento restante
// de direito, se houver
while (j < len2)
{
arr[k] = right[j];
k++;
j++;
}
}

// Função iterativa Timsort para ordenar o
// array[0...n-1] (semelhante ao merge sort)
public static void timSort(int[] arr, int n)
{
int minRun = minRunLength(MIN_MERGE);

// Classifica subarrays individuais de tamanho RUN
for (int i = 0; i < n; i += minRun)
{
insertionSort(arr, i,
Math.min((i + MIN_MERGE - 1), (n - 1)));
}

// Inicia a mesclagem a partir do tamanho
// EXECUTAR (ou 32). Será
// mescla para formar o tamanho 64,
// então 128, 256 e assim por diante
// ....
for (int size = minRun; size < n; size = 2 * size)
{

// Escolha o ponto de partida
// do sub array esquerdo. Nós
// vão se fundir
// arr[esquerda..esquerda+tamanho-1]
// e arr[esquerda+tamanho, esquerda+2*tamanho-1]
// Depois de cada fusão, nós
// aumenta a esquerda em 2*tamanho
for (int left = 0; left < n;
left += 2 * size)
{

// Encontra o ponto final do sub array esquerdo
// mid+1 é o ponto inicial do sub direito
// variedade
int mid = left + size - 1;
int right = Math.min((left + 2 * size - 1),
  (n - 1));

// Mesclar subarray arr[left.....mid] &
// arr[meio+1....direita]
if(mid < right)
merge(arr, left, mid, right);
}
}
}

private static int minRunLength(int mIN_MERGE2) {
    return 0;
}
}
