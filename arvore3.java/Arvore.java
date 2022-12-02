package Comparador.arvores3;

public class Arvore<TIPO extends Comparable>{
    
    private Elemento<TIPO> raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void adicionar(String[] array){
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(array);
        if (raiz==null){
            this.raiz = novoElemento;
        } else{
            Elemento<TIPO> atual = this.raiz;
            while(true){
                if(novoElemento.getValor().compareTo( atual.getValor()) == -1){
                    if(atual.getEsquerda()!= null){
                    atual = atual.getEsquerda();
                    }  else{
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                } else{
                    if(atual.getDireita() != null){
                        atual = atual.getDireita();
                    } else{
                        atual.setDIreita(novoElemento);
                        break;
                    }
                }
            }
        }
    }
    
    public Elemento<TIPO> getRaiz(){
        return raiz;
    }

    public void emOrdem(Elemento<TIPO> atual){
        if (atual != null){
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Elemento<TIPO> atual){
        if (atual != null){
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Elemento<TIPO> atual){
        if (atual != null){
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }

    public boolean remover(TIPO valor){
        //bucar elemento na árvore
        Elemento<TIPO> atual = this.raiz;
        Elemento<TIPO> paiAtual = null;
        while(atual != null){
            if(atual.getValor().equals(valor)){//valor procurado é igual ao pai
                break;
            } else if(valor.compareTo (atual.getValor()) == -1) { //valor procurado é menor que o pai
                paiAtual = atual;
                atual = atual.getEsquerda();
            } else{//valor procurado é maior que o pai
                paiAtual = atual;
                atual = atual.getDireita();
            }
        }
        //verifica se existe o elemento
        if(atual != null){
            if(atual.getDireita() != null){//elemento tem 2 filhos ou elemento tem somente filho a direita
                Elemento<TIPO> substituto = atual.getDireita();
                Elemento<TIPO> paiSubstituto = atual;
                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }
                if(paiAtual!=null){
                    if(atual.getValor().compareTo(paiAtual.getValor()) == -1){//atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    } else{
                        paiAtual.setDIreita(substituto);
                    }
                } else{//se não tem pai atual, então é a raiz
                    this.raiz = substituto;
                }
                //removeu o elemento da árvore
                if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){//substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                } else{
                    paiSubstituto.setDIreita(null);
                }
            } else if (atual.getEsquerda() != null){//tem filho só a esquerda
                Elemento<TIPO> substituto = atual.getEsquerda();
                Elemento<TIPO> paiSubstituto = atual;
                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                }
                if(paiAtual != null){
                    if(atual.getValor().compareTo(paiAtual.getValor()) == -1){//atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    } else{
                        paiAtual.setDIreita(substituto);
                    }
                } else{//se não tem pai atual, então é a raiz
                    this.raiz = substituto;
                }
               
                //removeu o elemento da árvore
                if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){//substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                } else{
                    paiSubstituto.setDIreita(null);
                }
            } else{//não tem filho
                if(paiAtual != null){
                    if(atual.getValor().compareTo(paiAtual.getValor()) == -1){//atual < paiAtual
                        paiAtual.setEsquerda(null);
                    } else{
                        paiAtual.setDIreita(null);
                    }
                } else{//é a raiz
                    this.raiz=null;
                }
            }
            return true;
        } else{
            return false;
        }
    }
}
