public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(72);
        arvoreBinaria.inserir(87);
        arvoreBinaria.inserir(37);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(75);
        arvoreBinaria.inserir(85);
        arvoreBinaria.inserir(90);
        arvoreBinaria.inserir(88);

        System.out.println("Árvore original:");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

        arvoreBinaria.remover(12);
        arvoreBinaria.remover(75);

        System.out.println("Árvore após remoções:");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
    }
}