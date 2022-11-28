import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PilhaDupla pd = new PilhaDupla(5);
		
		while(true) {
			System.out.println("Qual opcao deseja realizar:\n"
					+ "1 - Push1\n"
					+ "2 - Push2\n"
					+ "3 - Pop1\n"
					+ "4 - Pop2\n"
					+ "5 - ListarVetor\n"
					+ "6 - Sair");
			int n = s.nextInt();
			
			if(n == 1) {
				int valor = s.nextInt();
				pd.push1(valor);
			}
			else if(n == 2) {
				int valor = s.nextInt();
				pd.push2(valor);
			}
			else if(n == 3) {
				pd.pop1();
			}
			else if(n == 4) {
				pd.pop2();
			}
			else if(n == 5) {
				Main.listarVetor(pd.obterVetor());
			}
			else if(n == 6) {
				break;
			}
		}
		s.close();
	}
	
	static void listarVetor(int[] vetor) {
		if(vetor == null) {
			System.out.println("Nao ha valores na pilha");
		}else {
			for(int elemento:vetor) {
				System.out.println("- " + elemento);
			}
		}
	}

}
