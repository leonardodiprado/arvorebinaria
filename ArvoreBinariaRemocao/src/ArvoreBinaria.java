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
                if (novoNo.getValor() == atual.getValor()) {
                    System.out.println("O nó " + valor + " já existe na árvore.");
                    return null;
                }
                pai = atual;
                if (novoNo.getValor() < atual.getValor()) {
                    atual = atual.getEsq();
                } else {
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

                    /*caso onde o nó folha é o nó raiz (árvore com apenas um nó)*/
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

    public void removerNoComUmFilho(int valor) {
        if (this.raiz == null) {
            return;
        }

        No atual = this.raiz;
        No pai = null;

        while (atual != null) {
            if (valor == atual.getValor()) {

                if ((atual.getEsq() == null && atual.getDir() != null) || (atual.getEsq() != null && atual.getDir() == null)) {

                    No filho;
                    if (atual.getEsq() != null) {
                        filho = atual.getEsq();
                    } else {
                        filho = atual.getDir();
                    }
                    /*aqui identifica onde esta o filho que vai entrar no lugar do removido, se está
                    a esquerda ou a direita (declara variavel No filho para guardar o filho) */

                    if (pai == null) {
                        this.raiz = filho;
                    } else if (pai.getEsq() == atual) {
                        pai.setEsq(filho);
                    } else {
                        pai.setDir(filho);
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

    public void removerNoComDoisFilhos(int valor) {
        if (this.raiz == null) {
            return;
        }

        No atual = this.raiz;
        No pai = null;

        while (atual != null) {
            if (valor == atual.getValor()) {
                if (atual.getEsq() != null && atual.getDir() != null) {
                    No sucessor = atual.getDir();
                    No paiSucessor = atual;
                    /*declara a variavel No sucessor para procurar o sucessor (que aqui não é necessariamente o filho)
                    na subarvore a direita, essa variavel armazena areferencia ao nó sucessor*/

                    while (sucessor.getEsq() != null) {
                        paiSucessor = sucessor;
                        sucessor = sucessor.getEsq();
                    }
                    /*dentro do percurso da subarvore direita do nó a ser removido o laço se move o máximo
                    para a esquerda até a esquerda ser null, garantindo assim que o nó sucessor será o menor da
                    subárvore direita*/

                    atual.setValor(sucessor.getValor());

                    if (paiSucessor.getEsq() == sucessor) {
                        paiSucessor.setEsq(sucessor.getDir());
                    } else {
                        paiSucessor.setDir(sucessor.getDir());
                    }
                    /*aqui o nó que é o sucessor (menor da subárvore direita) é removido da sua posição original
                    para não ficar duplicado, já que ele foi "copiado" para o lugar do nó que foi removido inicialmente*/
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

    public void removerNoRaiz() {
        if (this.raiz == null) {

            return;
        }

        if (this.raiz.getEsq() == null && this.raiz.getDir() == null) {
            this.raiz = null;
        } else if (this.raiz.getEsq() != null && this.raiz.getDir() == null) {
            this.raiz = this.raiz.getEsq();
        } else if (this.raiz.getEsq() == null && this.raiz.getDir() != null) {
            this.raiz = this.raiz.getDir();
        } else {
            No sucessor = this.raiz.getDir();
            No paiSucessor = this.raiz;

            while (sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            this.raiz.setValor(sucessor.getValor());

            if (paiSucessor.getEsq() == sucessor) {
                paiSucessor.setEsq(sucessor.getDir());
            } else {
                paiSucessor.setDir(sucessor.getDir());
            }
        }
    }

    public void remover(int valor) {
        No atual = this.raiz;
        No pai = null;

        while (atual != null) {
            if (valor == atual.getValor()) {
                if (atual.getEsq() == null && atual.getDir() == null) {
                    removerNoFolha(valor);
                    System.out.println("Removido nó folha: " + valor);
                } else if (atual.getEsq() != null && atual.getDir() != null) {
                    if (atual == this.raiz) {
                        removerNoRaiz();
                        System.out.println("Removido nó raiz com dois filhos: " + valor);
                    } else {
                        removerNoComDoisFilhos(valor);
                        System.out.println("Removido nó com dois filhos: " + valor);
                    }
                } else {
                    if (atual == this.raiz) {
                        removerNoRaiz();
                        System.out.println("Removido nó raiz com um filho: " + valor);
                    } else {
                        removerNoComUmFilho(valor);
                        System.out.println("Removido nó com um filho: " + valor);
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
        System.out.println("Nó " + valor + " não encontrado na árvore.");
    }
}