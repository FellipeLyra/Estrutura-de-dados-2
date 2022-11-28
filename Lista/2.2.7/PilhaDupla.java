
public class PilhaDupla {
	
	int vetor[];
	int tamanhoPilha1;
	int tamanhoPilha2;
	int comecoPilha2;
	
	public PilhaDupla(int tamanhoVetor) {
		this.vetor = new int[tamanhoVetor];
		this.tamanhoPilha1 = 0;
		this.tamanhoPilha2 = 0;
		this.comecoPilha2 = tamanhoVetor - 1;
	}

	public boolean push1(int elemento) {
		if(this.tamanhoPilha1 == this.vetor.length - this.tamanhoPilha2) {
			return false;
		}
		this.vetor[this.tamanhoPilha1++] = elemento;
		return true;
	}
	
	public boolean push2(int elemento) {
		if(this.tamanhoPilha2 == this.vetor.length - this.tamanhoPilha1) {
			return false;
		}
		this.vetor[this.comecoPilha2--] = elemento;
		this.tamanhoPilha2++;
		return true;
	}
	
	public boolean pop1() {
		if(this.tamanhoPilha1 == 0) {
			return false;
		}
		this.vetor[--this.tamanhoPilha1] = 0;
		return true;
	}
	
	public boolean pop2() {
		if(this.tamanhoPilha2 == 0) {
			return false;
		}else {
		this.vetor[++this.comecoPilha2] = 0;
		this.tamanhoPilha2--;
		return true;
		}
	}
	
	public int[] obterVetor() {
		return this.vetor;
	}
	
}

