package Comparador.arvores3;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String texto = "";
    static int[] v;
    public static void main(String[]args) throws IOException{
        Arvore arvore = new Arvore();
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\fhlyr\\OneDrive\\Área de Trabalho\\vetor\\100milteste.txt"))
        .useDelimiter("\n");
    while (scanner.hasNext()) {
      texto = scanner.next();
    }

    String[] separatedStrings = texto.replaceAll("\\[", "")
        .replaceAll("]", "").replace(" ", "").split(",");

    String[] Array = new String[separatedStrings.length];

    long n;
    long horas;
    long minutos;
    long segundos;
    long mili;

    long tempoInicial = System.currentTimeMillis();

    arvore.adicionar(Array);

    long tempoFinal = System.currentTimeMillis();

    n = tempoFinal - tempoInicial;

    horas = n / 3600000;
    minutos = (n / 60000) % 60;
    segundos = (n / 1000) % 60;
    mili = n;

    System.out.println("Executado em = " + horas + ":" + minutos + ":" + segundos + ":" + mili);

        System.out.println("In-ordem: ");
        arvore.emOrdem(arvore.getRaiz());
        
        System.out.println("Pre-ordem: ");
        arvore.preOrdem(arvore.getRaiz());
        
        System.out.println("Pos-ordem: ");
        arvore.posOrdem(arvore.getRaiz());

        
    }
}
