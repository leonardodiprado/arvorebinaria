public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(72);
        arvoreBinaria.inserir(87);
        arvoreBinaria.inserir(37);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(12);

        System.out.println("Árvore original:");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());

        arvoreBinaria.removerNoFolha(12);


        System.out.println("Árvore após remover folhas:");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
    }
}