package Comparador.arvores2;
import java.util.Random;

public class Main {
    public static void main(String[]args){
        Random gerador = new Random();
        Arvore arvore = new Arvore();
        int x[] = new int [20];
        int i;
        for( i = 0; i<20; i++){//gera um vetor de 20 posições
            //gerador.nextInt(101);
            x[i] = gerador.nextInt(101);//gera numeros aleatorios de 0 a 100
            arvore.adicionar(x[i]);
        }
        //arvore.adicionar(10);
        //arvore.adicionar(5);
        System.out.println("In-ordem: ");
        arvore.emOrdem(arvore.getRaiz());
        
        arvore.adicionar(x[i]+ gerador.nextInt(21));

        System.out.println("Nova In-ordem: ");
        arvore.emOrdem(arvore.getRaiz());

    }
}
