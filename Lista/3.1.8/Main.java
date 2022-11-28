
public class Main {
	public static void main(String[] args) {
		System.out.println("\nRecursivo:");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + ": " + Main.fiboRecursivo(i));
		}
		
		System.out.println("\nIterativo:");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1  + ": " + Main.fiboImperativo(i));
		}
		
	}
	
	static long fiboRecursivo(int n) {
		if(n < 2) {
			return n;
		}
		return fiboRecursivo(n - 2) + fiboRecursivo(n - 1);
	}
	
	static long fiboImperativo(int n) {
		int atual = 0;
		int anterior = 0;
		
		for (int i = 1; i <= n; i++) {
			if(i == 1) {
				atual = 1;
				anterior = 0;
			}else {
				atual += anterior;
				anterior = atual - anterior;
			}
		}
		return atual;
	}
}
