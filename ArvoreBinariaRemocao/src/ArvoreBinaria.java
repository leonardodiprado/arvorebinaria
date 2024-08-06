public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void removerNoFolha(int valor) {
        if (this.raiz == null) {
            return;
        }
        No atual = this.raiz;
        No pai = null;

        while (atual != null) {
            if (valor == atual.getValor()) {
                if (atual.getEsq() == null && atual.getDir() == null) {

                    if (pai == null) {
                        this.raiz = null;
                    } else if (pai.getEsq() == atual) {
                        pai.setEsq(null);
                    } else {
                        pai.setDir(null);
                    }
                }
                return;
            } else if (valor < atual.getValor()) {
                pai = atual;
                atual = atual.getEsq();
            } else {
                pai = atual;
                atual = atual.getDir();
            }
        }
    }
}