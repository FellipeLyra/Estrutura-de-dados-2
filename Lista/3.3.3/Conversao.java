
public class Conversao {
	
	public boolean operadores(String str) {
        return "+-*/@".contains(str);
    }

    public boolean operandos(String str){
        return "abcdefghijklmnopqrstuvwxyz".contains(str.toLowerCase());
    }
	
	public int find (String exp) {
        String temp;
        int tamanho, m, n;
        if ((tamanho = exp.length()) == 0) {
        	return 0;
        }
        if (Character.isLetter(exp.charAt(0))) {
        	return 1;
        }
        if (exp.length() < 2) {
        	return 0;
        }
        if (exp.charAt (0) == '@' ) {
            temp = this.substr (exp , 1, tamanho - 1);
            m = this.find (temp);
            if (m == 0 || exp.length () == m) {
            	return 0;
            }
            return m + 1;
        }
        temp = this.substr(exp, 1, tamanho - 1);
        m = this.find (temp);
        if (m == 0 || exp.length() == m) {
        	return 0;
        }
        temp = this.substr (exp, m + 1, tamanho - m - 1);
        n = this.find (temp);
        if (n == 0) {
        	return 0;
        }
        return m + n + 1;
    }
	
	public String substr(String str, int inx, int caracteres) {
        String toReturn = "";
        for (int i = 0, comeco = inx ; i < caracteres ; i++ , comeco++) {
            toReturn += str.split("")[comeco];
        }
        return toReturn;
    }
	
	String preFixPPosFix(String exp) {
		 if (exp.contains (" ")) {
			 exp = exp.replaceAll(" ", "");
		 }
	        String opnd1, opnd2;
	        String post1, post2;
	        String temp;
	        String op;
	        int tamanho, m, n;
	        
	        if ((tamanho = exp.length()) == 1) {
	            if (Character.isLetter(exp.charAt(0))) {
	            	return exp;
	            }
	            return "Caractere unico invalido";
	        }
	        if (exp.charAt(0) == '@') {
	            op = this.substr(exp ,0 ,1);
	            m = tamanho - 1; 
	            if (m == 0) {
	            	return "Expressao contem elementos invalidos";
	            }
	            opnd1 = this.substr (exp, 1, m);
	            post1 = this.preFixPPosFix(opnd1);
	            post1 += op;
	            return post1;
	        }else {
	            op = this.substr (exp, 0, 1);
	            temp = this.substr (exp, 1, tamanho - 1);
	            m = this.find (temp);
	            temp = this.substr (exp, m + 1, tamanho - m - 1);
	            n = this.find (temp);
	            if (!this.operadores(op) || (m == 0) || (n == 0) || (m + n + 1 != tamanho)){
	            	return "Expressao contem elementos invalidos";
	            }
	            opnd1 = this.substr(exp, 1, m);
	            opnd2 = this.substr(exp, m + 1, n);
	            post1 = this.preFixPPosFix(opnd1);
	            post2 = this.preFixPPosFix(opnd2);
	            post1 += post2 + op;
	            return post1;
	        }
	}
}
