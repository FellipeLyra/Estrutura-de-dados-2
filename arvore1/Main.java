package Comparador.arvores;
import java.util.Random;

public class Main {
    public static void main(String[]args){
        Random gerador = new Random();
        Arvore arvore = new Arvore();
        int x[] = new int [20];
        for(int i = 0; i<20; i++){//gera um vetor de 20 posições
            //gerador.nextInt(101);
            x[i] = gerador.nextInt(101);//gera numeros aleatorios de 0 a 100
            arvore.adicionar(x[i]);
        }
        //arvore.adicionar(10);
        //arvore.adicionar(5);
        System.out.println("In-ordem: ");
        arvore.emOrdem(arvore.getRaiz());
        
        System.out.println("Pre-ordem: ");
        arvore.preOrdem(arvore.getRaiz());
        
        System.out.println("Pos-ordem: ");
        arvore.posOrdem(arvore.getRaiz());

        arvore.remover(x[gerador.nextInt(6)]);//gera 5 posições aleatorias para que as retire do array
        System.out.println("Nova In-ordem: ");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(x[gerador.nextInt(6)]);
        System.out.println("Nova Pre-ordem: ");
        arvore.preOrdem(arvore.getRaiz());

        arvore.remover(x[gerador.nextInt(6)]);
        System.out.println("Nova Pos-ordem: ");
        arvore.posOrdem(arvore.getRaiz());
        
    }
}
