package Comparador.arvores2;

public class Elemento <TIPO>{
    private TIPO valor;
    private Elemento<TIPO> direita;
    private Elemento<TIPO> esquerda;

    public Elemento (TIPO novovalor){
        this.valor = novovalor;
        this.esquerda = null;
        this.direita = null;
    }

    public TIPO getValor(){
        return valor;
    }

    public void setValor(TIPO valor){
        this.valor = valor;
    }

    public Elemento<TIPO> getEsquerda(){
        return esquerda;
    }

    public void setEsquerda(Elemento<TIPO> esquerda){
        this.esquerda = esquerda;
    }

    public Elemento<TIPO> getDireita(){
        return direita;
    }

    public void setDIreita(Elemento<TIPO> direita){
        this.direita = direita;
    }
}
